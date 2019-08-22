package zv2.com.cn.thirdparty.alipay.request;

import lombok.Data;

/**
 * @author lb
 * @date 2019/8/21 2:40
 */
@Data
public class PayRequest {
    /**
     * 商户订单号
     */
    private String out_trade_no;
    /**
     * 付款金额
     */
    private String total_amount;
    /**
     * 订单名称
     */
    private String subject;
    /**
     * 商品描述
     */
    private String body;
}
