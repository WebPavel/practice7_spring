package zv2.com.cn.common.factory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author lb
 * @date 2019/7/10 2:58
 */
public class InstanceFactory {
    public static ExecutorService cachedThreadPool() {
        ExecutorService pool = Executors.newCachedThreadPool();
        return pool;
    }
}
