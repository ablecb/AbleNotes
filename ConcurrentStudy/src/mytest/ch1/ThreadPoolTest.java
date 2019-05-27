package mytest.ch1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @ClassName ThreadPoolTest
 * @Description TODO
 * @Author 曹博
 * @Date 2019/5/27 10:01
 * @Version 1.0
 */
public class ThreadPoolTest {
    public static void main(String[] args) {
        ExecutorService service=Executors.newSingleThreadExecutor();
        ExecutorService service1=Executors.newWorkStealingPool();
    }
}
