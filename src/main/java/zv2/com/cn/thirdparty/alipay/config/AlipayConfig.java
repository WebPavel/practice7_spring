package zv2.com.cn.thirdparty.alipay.config;

import java.io.FileWriter;
import java.io.IOException;

/* *
 *类名：AlipayConfig
 *功能：基础配置类
 *详细：设置帐户有关信息及返回路径
 *修改日期：2017-04-05
 *说明：
 *以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
 *该代码仅供学习和研究支付宝接口使用，只是提供一个参考。
 */

public class AlipayConfig {

//↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓

    // 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
    public static String app_id = "2016100200646284";

    // 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCY0ufYvnhxKRPfnt56DA8yU6PbRjLbtNttvy9rzkOE37Pp5syLR4YHhuFpIQbzacYtHnJUqpBzsH9bGqcVbH+xyWKxmdge0rCFtFLbqdlBrSb7xhF0zBgp2lXBZp1btvPGKsATTQo4hMzdVddFMgFeKEs3uJ1n4yHeaiK6s/WEzAncvIAgUzxtgt1gkgp94TWJFctZPy0QYZodU+Aw2slsIdg1kwVino2nupMiNBUHKwURuiT6STrfAwEzeLJjirwhMChYeovniootmSo+3Ky/bGwKYfW0Jb51iF6IiXQzADucVvpPFMkfWWLedyGZwEKc6jhR/85ILqCAtS9mU/LbAgMBAAECggEAYfR1hTj5DFdvFJvJMGOAbhqsYYVKXgc7ysmLxMcOAiI9OMSmAPRUVYi//NmdkfIPg6YLVHeLZYwQ5b1csV+9LaDOsNXScFdNrDXcEk55Ih6xaRoY4EtdhZ4b734tiLbo4/FM8lIkJfwBMDGwbPrTY53iMJIV2pv8fop7Pj7RNU9xsT+Y2Ghjas9g7O7ZO4VJ/Z/oBdRrVjD7N2CTKeFOPAF92vLvKYRtPHVHmQkF3KS2DH9j3O9hZWbBwMdP6csvOixaSzSwLdl414Rb+7arCaFeoWY6A7QrTzdc8pRrsSloh425rGPXFPqkYaYKWxzr7B63mQ/R8BY3ja/blhVEqQKBgQDK7FqB8Yvb66c/UvwLXdXjV1Tuf6LZnotr0PLSCKWSl1qc8h0GeOy4UKEQXgaui2HKZAVEsyg8ZNkxY7QEWfmWhh0HaHEChTm1FNxWqeprYsf9xlVcSVv3VoTTJ8LtvgvrDbq2MgZ7oSIIGD587c0NnTYgyhC+K6L8iacQ4TZoLwKBgQDAy+tWe10NWbK9LKMqSc4EI9vyk9p9+ocyfr44cS1exuKVTY9xzfM+gLnkYbP/eZUhr1Mu+gX20v3lVtcZNCDhBnnLkP3rMWr3YG9V3RkSKQpAXATHIuyLlya4I/PxnTZRJgBki9bwnkFXQASP3wSWaJyTduXfcyAJeJRJt1hJFQKBgBqPaSFM/mNgqtltATRzqcVB7wnwht45FEKebMn0+8b+LIwSXJ42QbW2R/6eb/10nO4ivVXKpV+SS6NdS3iuVi7PiwknMHOGAJGlE1n8j4RSv56F0TJtH652EpiYwbjggSrY9zFVxudzpcKtebBcZ9R6WVVdXWemyoSHd+iLsdVdAoGBAKAf/WrLdOJksFX8H9w8hjXcDo5vjFV7YRRoPdak8Ti5WHEGhO/RTIiJ41qyZwv1UA41DpKCp7dzT9pNgML3D6O1fCy9VJclaSDiYDXhNzRlD5Wal4FJGUtqk4b2nWH736QQOt1HY5Je7gfoLKHNaYL+iaTUaGFovaAAHLEI7PNtAoGAQevEcAB1s4lvgIZfIENVhVr88RPfKfVcbJe4HjnBL83yculsuMtRA6gZcbXaVzQGEm2cm6oeLgQQ/tCwevvyFYgd+Tbt6eM3dgDcoRMmF2Z5j8Q6a+2VYPn3RQ2eMV98lz3U5U518xL7kYrkBhDPwh0QNpCABb+mHd46oingCRA=";

    // 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAiEbt/5MF7X5QhrGpBnx8VoVM1VTWUs7LqxwzjBrtCWcwH3NvjXV8NoWN/FyJKcY6/quQoADqRh1s+SkmvaHGmhrXH3gZJIkd9tfpfam4NH32H424te/FB4qIsiNaEkdbpI8Zy3wxqlW8r4Q9miRzBzp2/inZ1s+raexdf8rLpZbsn3j+TRc0NsKizhpow1F2T3eLffBV/1ExrYFwNhMOl6mQTYLFHmZHshih+eyAc4WMBElJmNYFK4F/YEOdvZuABfYdL1Ho4RkbJOfZ6W5482WWDFZbzJXe1F+yXb2PmJVL+rDrZgnnEmOBoekTjXSuahNsqeiJiC9f3QJeI41leQIDAQAB";

    // 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String notify_url = "http://b904463e.ngrok.io/biz/order/callback.action";

    // 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String return_url = "http://b904463e.ngrok.io/biz/order/callback.action";

    // 签名方式
    public static String sign_type = "RSA2";

    // 字符编码格式
    public static String charset = "utf-8";

    // 支付宝网关
    public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";

    // 支付宝网关
    public static String log_path = "C:\\";


//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

    /**
     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
     * @param sWord 要写入日志里的文本内容
     */
    public static void logResult(String sWord) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis()+".txt");
            writer.write(sWord);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
