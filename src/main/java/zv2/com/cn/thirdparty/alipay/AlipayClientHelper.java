package zv2.com.cn.thirdparty.alipay;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.internal.util.AlipaySignature;
import com.alipay.api.request.AlipayTradePagePayRequest;
import zv2.com.cn.thirdparty.alipay.config.AlipayConfig;
import zv2.com.cn.thirdparty.alipay.request.PayRequest;
import zv2.com.cn.thirdparty.alipay.response.PayResponse;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @author lb
 * @date 2019/8/21 22:23
 */
public class AlipayClientHelper {
    public static String pay(PayRequest payRequest) {
        //获得初始化的AlipayClient
        AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfig.gatewayUrl, AlipayConfig.app_id, AlipayConfig.merchant_private_key, "json", AlipayConfig.charset, AlipayConfig.alipay_public_key, AlipayConfig.sign_type);

        //设置请求参数
        AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();
        alipayRequest.setReturnUrl(AlipayConfig.return_url);
        alipayRequest.setNotifyUrl(AlipayConfig.notify_url);
        alipayRequest.setBizContent("{\"out_trade_no\":\""+ payRequest.getOut_trade_no() +"\","
                + "\"total_amount\":\""+ payRequest.getTotal_amount() +"\","
                + "\"subject\":\""+ payRequest.getSubject() +"\","
                + "\"body\":\""+ payRequest.getBody() +"\","
                + "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");

        //请求
        String result = null;
        try {
            result = alipayClient.pageExecute(alipayRequest).getBody();
        } catch (AlipayApiException e) {
            return "";
        }
        //输出
        return result;
    }
    
    public static PayResponse callback(HttpServletRequest request) throws UnsupportedEncodingException {
        PayResponse payResponse = new PayResponse();
        //获取支付宝POST过来反馈信息
        Map<String,String> params = new HashMap<String,String>();
        Map<String,String[]> requestParams = request.getParameterMap();
        for (Iterator<String> iter = requestParams.keySet().iterator(); iter.hasNext();) {
            String name = (String) iter.next();
            String[] values = (String[]) requestParams.get(name);
            String valueStr = "";
            for (int i = 0; i < values.length; i++) {
                valueStr = (i == values.length - 1) ? valueStr + values[i]
                        : valueStr + values[i] + ",";
            }
            //乱码解决，这段代码在出现乱码时使用
            valueStr = new String(valueStr.getBytes("ISO-8859-1"), "utf-8");
            params.put(name, valueStr);
        }

        boolean signVerified = false; //调用SDK验证签名
        try {
            signVerified = AlipaySignature.rsaCheckV1(params, AlipayConfig.alipay_public_key, AlipayConfig.charset, AlipayConfig.sign_type);
        } catch (AlipayApiException e) {
            payResponse.setIsSuccess(false);
            payResponse.setExt_desc("验证签名失败");
            return payResponse;
        }

        if(signVerified) {//验证成功
            //商户订单号
            String out_trade_no = new String(request.getParameter("out_trade_no").getBytes("ISO-8859-1"),"UTF-8");
            //支付宝交易号
            String trade_no = new String(request.getParameter("trade_no").getBytes("ISO-8859-1"),"UTF-8");
            //交易金额
            String total_amount = new String(request.getParameter("total_amount").getBytes("ISO-8859-1"),"UTF-8");

            payResponse.setOut_trade_no(out_trade_no);
            payResponse.setTrade_no(trade_no);
            payResponse.setTotal_amount(total_amount);
            payResponse.setIsSuccess(true);
        } else {//验证失败
            payResponse.setIsSuccess(false);
            payResponse.setExt_desc("验证签名失败");
        }
        return payResponse;
    }
}
