package mytest.ch6.schd;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName ScheduledCase
 * @Description TODO
 * @Author 曹博
 * @Date 2019/5/27 11:04
 * @Version 1.0
 */
public class ScheduledCase {
    public static void main(String[] args) {
        ScheduledThreadPoolExecutor schedule
                =new ScheduledThreadPoolExecutor(1);
        schedule.scheduleAtFixedRate(new ScheduleWorker(ScheduleWorker.HasException),1000,
                3000, TimeUnit.MILLISECONDS);
    }
}
