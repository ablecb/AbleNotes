package mytest.ch1.ch4.aqs;

import java.nio.channels.NonWritableChannelException;
import java.util.concurrent.locks.Lock;

/**
 * @ClassName TestMyLock
 * @Description TODO
 * @Author 曹博
 * @Date 2019/5/22 9:09
 * @Version 1.0
 */
public class TestMyLock {
    public void test() throws InterruptedException {
        final Lock lock=new SelfLock();
        class Work extends Thread{
            @Override
            public void run() {
                while(true){
                    lock.lock();
                    try{
                        Thread.currentThread().sleep(1000);
                        System.out.println(Thread.currentThread().getName());
                        Thread.currentThread().sleep(1000);
                    }catch (Exception e){

                    }finally {
                        lock.unlock();
                    }
                    try {
                        Thread.currentThread().sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        }
        for(int i=0;i<10;i++){
            Work w=new Work();
            w.setDaemon(true);
            w.start();
        }
        for(int i=0;i<10;i++){
            Thread.currentThread().sleep(1000);
            System.out.println();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        TestMyLock testMyLock=new TestMyLock();
        testMyLock.test();
    }
}
