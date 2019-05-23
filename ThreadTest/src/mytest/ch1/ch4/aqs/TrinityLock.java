package mytest.ch1.ch4.aqs;

import com.sun.corba.se.impl.orbutil.concurrent.Sync;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * @ClassName TrinityLock
 * @Description TODO
 * @Author 曹博
 * @Date 2019/5/23 9:03
 * @Version 1.0
 */
public class TrinityLock implements Lock {
    Sync sync=new Sync(3);
    private static  final  class  Sync extends AbstractQueuedSynchronizer{
        Sync(int count){
            if(count<=0)
                throw new IllegalArgumentException("count must larger than zero");
            setState(count);

        }

        @Override
        protected int tryAcquireShared(int reduceCount) {
            for (;;){
                int current=getState();
                int newCount=current-reduceCount;
                if(newCount<0||compareAndSetState(current,newCount)){
                    return newCount;
                }
            }
        }

        @Override
        protected boolean tryReleaseShared(int returnCount) {
           for (;;){
                int current=getState();
                int newCount=current+returnCount;
                if(compareAndSetState(current,newCount)){
                    return true;
                }
           }
        }
        final ConditionObject newCondition(){
            return new ConditionObject();
        }
    }
    @Override
    public void lock() {
        sync.tryAcquireShared(1);
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {
        sync.acquireSharedInterruptibly(1);
    }

    @Override
    public boolean tryLock() {
        return sync.tryAcquireShared(1)>=0;
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return  sync.tryAcquireSharedNanos(1,unit.toNanos(time));
    }

    @Override
    public void unlock() {
        sync.releaseShared(1);
    }

    @Override
    public Condition newCondition() {
        return sync.newCondition();
    }
}
