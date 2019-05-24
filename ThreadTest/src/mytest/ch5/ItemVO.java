package mytest.ch5;

import sun.rmi.runtime.Log;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName ItemVO
 * @Description TODO
 * @Author 曹博
 * @Date 2019/5/24 13:39
 * @Version 1.0
 */
public class ItemVO<T> implements Delayed {
    private long activeTime;//到期时间，毫秒
    private T date;

    public long getActiveTime() {
        return activeTime;
    }

    public T getDate() {
        return date;
    }

    //activeTime是过期时长
    public ItemVO(long activeTime, T date) {
        this.activeTime = TimeUnit.NANOSECONDS.convert(activeTime,
                TimeUnit.MILLISECONDS)+System.nanoTime();//将传入的时长转化为超时的时刻
        this.date = date;
    }
    //返回元素的剩余时间
    @Override
    public long getDelay(TimeUnit unit) {
        long d=unit.convert(this.activeTime-System.nanoTime(),TimeUnit.NANOSECONDS);
        return d;
    }
    //按照剩余时间排序
    @Override
    public int compareTo(Delayed o) {
        long d=getDelay(TimeUnit.NANOSECONDS)-o.getDelay(TimeUnit.NANOSECONDS);
        return (d==0)?0:((d>0)?1:-1);
    }
}
