package mytest.ch1.ch4;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @ClassName UseRWLock
 * @Description TODO
 * @Author 曹博
 * @Date 2019/5/21 16:26
 * @Version 1.0
 */
public class UseRWLock{
    private ReadWriteLock lock=new ReentrantReadWriteLock();
    private Lock readLock=lock.readLock();
    private Lock writeLock=lock.writeLock();
    int count=0;

    public int getCount() {
        try{
            readLock.lock();
            return count;
        }finally{
            readLock.unlock();
        }

    }

    public void setCount(int count) {
        try {
            writeLock.lock();
            this.count=count;
        }finally {
            writeLock.unlock();
        }
    }

    public static void main(String[] args) {
        UseRWLock rwLock=new UseRWLock();
        for(int i=0;i<10;i++){
            new Thread(()->{
                rwLock.getCount();
                System.out.println(Thread.currentThread().getName()+"开始读了");
            },"读线程"+(i+1)).start();
        }
        //alt +shift +ctrl+n查找一个类
        //alt+7显示类的所有方法
        for(int i=0;i<3;i++){
            new Thread(()->{
                rwLock.setCount(44);
                System.out.println(Thread.currentThread().getName()+"开始写了");
            },"写线程"+(i+1)).start();
        }
    }
}
