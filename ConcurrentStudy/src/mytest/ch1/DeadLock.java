package mytest.ch1;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName DeadLock
 * @Description TODO
 * @Author 曹博
 * @Date 2019/5/27 9:39
 * @Version 1.0
 */
public class DeadLock {
    private Lock lock=new ReentrantLock();
    int count=0;
    public  void add(){
        lock.lock();
        System.out.println("sdfdsf");
        count++;

    }
    public static void main(String[] args) {
        DeadLock deadLock=new DeadLock();
        deadLock.add();
        System.out.println(deadLock.count);
    }
}
