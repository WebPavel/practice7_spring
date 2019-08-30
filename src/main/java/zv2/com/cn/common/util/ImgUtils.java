package zv2.com.cn.common.util;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 制作图片缩略图
 * @author lb
 * @date 2019/8/28 23:48
 */
public class ImgUtils {
    private String srcFile;
    private String destFile;
    private int width;
    private int height;
    private Image image;

    public ImgUtils(String fileName) throws IOException {
        this.srcFile = fileName;
        int index = this.srcFile.lastIndexOf(".");
        String suffix = this.srcFile.substring(index);
        this.destFile = this.srcFile.substring(0, index) + "_thumbnail" + suffix;
        File file = new File(fileName);
        this.image = ImageIO.read(file);
        // 获取原图宽和高
        this.width = this.image.getWidth(null);
        this.height = this.image.getHeight(null);
    }

    /**
     * 强制压缩|放大图片到指定大小
     * @param width
     * @param height
     * @throws IOException
     */
    public void resize(int width, int height) throws IOException {
        BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_BGR);
        bufferedImage.getGraphics().drawImage(image, 0, 0, width, height, null);
        FileOutputStream outputStream = new FileOutputStream(destFile);
        JPEGImageEncoder imageEncoder = JPEGCodec.createJPEGEncoder(outputStream);
        imageEncoder.encode(bufferedImage);
        outputStream.close();
    }

    /**
     * 按比例缩放图片
     * @param scale
     * @throws IOException
     */
    public void resize(double scale) throws IOException {
        int width = (int) (this.width * scale);
        int height = (int) (this.height * scale);
        resize(width, height);
    }

    /**
     * 以宽度为基准，等比例缩放图片
     */
    public void resizeByWidth(int width) throws IOException {
        int height = this.height * width / this.width;
        resize(width, height);
    }

    public void resizeByHeight(int height) throws IOException {
        int width = this.width * height / this.height;
        resize(width, height);
    }

    public void resizeFix(int width, int height) throws IOException {
        if (width/height > this.width/this.height) {
            resizeByWidth(width);
        } else {
            resizeByHeight(height);
        }
    }

    public String getDestFile() {
        return destFile;
    }

    public void setDestFile(String fileName) throws Exception {
        if (!fileName.endsWith(".jpg")) {
            throw new Exception("Dest File must end with .jpg");
        }
        this.destFile = fileName;
    }

    public int getSrcWidth() {
        return width;
    }

    public int getSrcHeight() {
        return height;
    }
}
