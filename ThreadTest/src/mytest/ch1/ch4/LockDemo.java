package mytest.ch1.ch4;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName LockDemo
 * @Description TODO
 * @Author 曹博
 * @Date 2019/5/21 15:53
 * @Version 1.0
 */
public class LockDemo {
    private Lock lock =new ReentrantLock();

    private int count;
    public void increament(){
        lock.lock();
        try{
            count++;
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            lock.unlock();
        }
    }
    public synchronized void incr2(){
        count++;
    }
}
