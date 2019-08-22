package zv2.com.cn.thirdparty.alipay.response;

import lombok.Data;

/**
 * @author lb
 * @date 2019/8/21 23:07
 */
@Data
public class PayResponse {
    /**
     * 商户订单号
     */
    private String out_trade_no;
    /**
     * 支付宝交易号
     */
    private String trade_no;
    /**
     * 交易金额
     */
    private String total_amount;

    private Boolean isSuccess;
    private String ext_desc;
}
