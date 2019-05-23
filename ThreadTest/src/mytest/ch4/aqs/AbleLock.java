package mytest.ch4.aqs;



import java.util.concurrent.atomic.AtomicReference;

/**
 * @ClassName AbleLock
 * @Description TODO
 * @Author 曹博
 * @Date 2019/5/22 9:38
 * @Version 1.0
 */
public class AbleLock {
    AtomicReference<Thread> reference=new AtomicReference<Thread>();
    Thread thread=null;
    public void lock() {
        thread = Thread.currentThread();
        if (reference.get() == null) {
            reference.compareAndSet(null, thread);
        }
    }
    public void unlock(){
        reference.set(null);
    }
}
