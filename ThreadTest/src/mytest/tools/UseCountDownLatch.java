package mytest.tools;



import java.util.concurrent.CountDownLatch;

/**
 * @ClassName UseCountDownLatch
 * @Description TODO
 * @Author 曹博
 * @Date 2019/5/21 7:35
 * @Version 1.0
 */
public class UseCountDownLatch extends  Thread{
    static CountDownLatch latch=new CountDownLatch(6);

    @Override
    public void run() {
        Thread.currentThread().setName("子线程");
        System.out.println("子线程开始执行任务了");
        latch.countDown();
    }

    public static void main(String[] args) throws Exception {
        System.out.println("main 线程开始了");
        UseCountDownLatch latch1=new UseCountDownLatch();
        latch1.start();
        for(int i=0;i<5;i++){
            Thread.currentThread().sleep(10);
            latch.countDown();
            System.out.println("减一");
        }
        latch.await();
        System.out.println("wanbi");
    }
}
