package zv2.com.cn.common.util;

import java.util.Random;

/**
 * @author lb
 * @date 2019/7/10 2:41
 */
public class StringUtils {
    /**
     * 生成0-9组成的指定长度字符串
     * @param length
     * @return
     */
    public static String randomNumStr(long length) {
        if (length <= 0) {
            throw new IllegalArgumentException();
        }
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            sb.append(random.nextInt(10));
        }
        return sb.toString();
    }

    public static boolean isBlank(String plainText) {
        if (plainText == null || plainText.trim().length() == 0) {
            return true;
        }
        return false;
    }
}
