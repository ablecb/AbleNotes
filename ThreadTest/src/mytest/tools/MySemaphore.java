package mytest.tools;

import java.util.concurrent.Semaphore;

/**
 * @ClassName MySemaphore
 * @Description TODO
 * @Author 曹博
 * @Date 2019/5/21 10:16
 * @Version 1.0
 */
public class MySemaphore {
    static Semaphore semaphore=new Semaphore(0);
    public static void main(String[] args) throws InterruptedException {
        semaphore.release();
        semaphore.acquire();
        semaphore.release();
        /*semaphore.acquire();
        semaphore.release();
        semaphore.release();*/
        semaphore.getQueueLength();//获取等待的线程数量
        System.out.println(semaphore.availablePermits());
    }
}
