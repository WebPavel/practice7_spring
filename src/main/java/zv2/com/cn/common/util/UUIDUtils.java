package zv2.com.cn.common.util;

import java.util.UUID;

/**
 * @author lb
 * @date 2019/7/10 2:50
 */
public class UUIDUtils {
    public static String generate() {
        return UUID.randomUUID().toString().replace("-", "");
    }
}
