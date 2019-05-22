package mytest.ch1.tools;

/**
 * @ClassName TestMy
 * @Description TODO
 * @Author 曹博
 * @Date 2019/5/21 11:19
 * @Version 1.0
 */
public class TestMy {
    public static void main(String[] args) {
        MySemaphore.semaphore.release();
        MySemaphore.semaphore.release();
        System.out.println(MySemaphore.semaphore.availablePermits());
    }
}
