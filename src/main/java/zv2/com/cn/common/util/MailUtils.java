package zv2.com.cn.common.util;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

/**
 * 发送邮件工具类
 * @author lb
 * @date 2019/8/10 16:32
 */
public class MailUtils {
    /**
     * 发送邮件
     * @param to 接收者
     * @param activationCode 激活码
     */
    public static void sendMail(String to, String activationCode) throws Exception {
        Properties props = new Properties();
        props.setProperty("mail.smtp", "localhost");
        // 1.建立与邮箱服务器的会话连接
        Session session = Session.getInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("service@gwwind.cn", "123456");
            }
        });
        // 2.构建邮件对象
        Message message = new MimeMessage(session);
        // 发件人:
        message.setFrom(new InternetAddress("service@gwwind.cn"));
        // 收件人:
        message.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
        // 主题
        message.setSubject("来自GWWIND激活邮件");
        // 正文
        message.setContent("<h1>来自gwwind官网的激活邮件</h1><h3><a href='http://192.168.1.101:8080/usr/customer/activate?activationCode=" + activationCode + "'>点我激活</a></h3>", "text/html;charset=utf-8");
        // 发送对象
        Transport.send(message);
    }
}
