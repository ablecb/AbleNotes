package mytest.ch1.ch4.aqs;

import javax.swing.plaf.nimbus.State;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * @ClassName SelfLock
 * @Description TODO
 * @Author 曹博
 * @Date 2019/5/22 8:33
 * @Version 1.0
 */
public class SelfLock implements Lock {

    private  static class Sync extends AbstractQueuedSynchronizer{
        //state 表示是否处于占用,1为占用，0为没有
        //当前锁是否处于占用
        @Override
        protected boolean isHeldExclusively() {
            return getState()==1;
        }

        @Override
        protected boolean tryAcquire(int arg) {
            if(compareAndSetState(0,1)){
                setExclusiveOwnerThread(Thread.currentThread());
                return true;
            }
            return false;
        }

        @Override
        protected boolean tryRelease(int arg) {
            if(getState()==0){
                throw  new  UnsupportedOperationException();
            }
            setExclusiveOwnerThread(null);
            setState(0);
            return true;
        }
        public Condition newCondition() {
            return new ConditionObject();
        }
    }
    private Sync sync=new Sync();
    @Override
    public void lock() {
        sync.acquire(1);
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {
        sync.acquireInterruptibly(1);
    }

    @Override
    public boolean tryLock() {
       return sync.tryAcquire(1);
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return sync.tryAcquireNanos(1,unit.toNanos(time));
    }

    @Override
    public void unlock() {
        sync.release(1);
    }

    @Override
    public Condition newCondition() {
        return sync.newCondition();
    }
}
