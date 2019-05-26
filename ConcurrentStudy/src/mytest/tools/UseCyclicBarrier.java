package mytest.tools;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @ClassName UseCyclicBarrier
 * @Description TODO
 * @Author 曹博
 * @Date 2019/5/21 9:29
 * @Version 1.0
 */
public class UseCyclicBarrier implements Runnable{
    static int num=0;
    private static CyclicBarrier  cyclicBarrier=new CyclicBarrier(4,()->{
       num=9999;
    });
    @Override
    public void run() {
        try {
            System.out.println(Thread.currentThread().getName()+"开始等待了"+num);
            cyclicBarrier.await();
            System.out.println(Thread.currentThread().getName()+"开始执行了"+num);
            Thread.currentThread().sleep(1000);
            System.out.println(Thread.currentThread().getName()+"执行完毕了"+num);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws BrokenBarrierException, InterruptedException {
        UseCyclicBarrier barrier=new UseCyclicBarrier();
        for(int i=0;i<3;i++){
            new Thread(barrier,"线程"+i).start();
        }
        System.out.println(Thread.currentThread().getName()+"开始等待");
        cyclicBarrier.await();
        System.out.println("主线程执行完毕");
    }
}
