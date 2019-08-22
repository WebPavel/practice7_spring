package zv2.com.cn.usr.customer.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.OutputStream;
import java.util.Random;

/**
 * @author lb
 * @date 2019/8/13 22:13
 */
public class CaptchaAction extends ActionSupport {
    public String captcha() throws Exception {
        // 1.画布
        int width = 120;
        int height = 30;
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_BGR);
        Graphics2D graphics = (Graphics2D) image.getGraphics();
        graphics.setColor(getRandomColor(200, 250));
        graphics.fillRect(0,0,width,height);
        // 2.画边框
        graphics.setColor(Color.WHITE);
        graphics.drawRect(0,0,width-1,height-1);
        // 3.生成随机字符串
        String words = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random random = new Random();
        StringBuilder captcha = new StringBuilder();
        graphics.setFont(new Font("宋体", Font.BOLD, 18));
        int x = 20;
        int y = 20;
        for (int i = 0; i < 4; i++) {
            // 随机颜色
            graphics.setColor(getRandomColor(20, 130));
            // 正负30度角之间旋转
            int angle = random.nextInt(60) - 30;
            // 通过角度获取弧度
            double theta = angle * Math.PI / 180;
            int index = random.nextInt(words.length());
            char word = words.charAt(index);
            captcha.append(word);
            graphics.rotate(theta, x, y);
            graphics.drawString(String.valueOf(word), x, y);
            graphics.rotate(-theta, x, y);
            x += 20;
        }
        ServletActionContext.getRequest().getSession().setAttribute("captcha", captcha.toString());
        // 4.划干扰线
        graphics.setColor(getRandomColor(160, 200));
        int x1, y1, x2, y2;
        for (int i = 0; i < 4; i++) {
            x1 = random.nextInt(width);
            y1 = random.nextInt(height);
            x2 = random.nextInt(width);
            y2 = random.nextInt(height);
            graphics.drawLine(x1, y1, x2, y2);
        }
        // 5.输出到浏览器
        String formatName = "jpg";
        OutputStream output = ServletActionContext.getResponse().getOutputStream();
        ImageIO.write(image, formatName, output);
        return NONE;
    }

    private Color getRandomColor(int fc, int bc) {
        Random random = new Random();
        if (fc > 255) {
            fc = 255;
        }
        if (bc > 255) {
            bc = 255;
        }
        int r = fc + random.nextInt(bc - fc);
        int g = fc + random.nextInt(bc - fc);
        int b = fc + random.nextInt(bc - fc);
        return new Color(r, g, b);
    }
}
