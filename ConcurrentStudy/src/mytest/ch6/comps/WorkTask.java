package mytest.ch6.comps;

import java.util.Random;
import java.util.concurrent.Callable;

/**
 * @ClassName WorkTest
 * @Description TODO
 * @Author 曹博
 * @Date 2019/5/27 14:44
 * @Version 1.0
 */
public class WorkTask implements Callable<Integer> {
    private String name;

    public WorkTask(String name) {
        this.name = name;
    }

    @Override
    public Integer call() throws Exception {
        int sleepTime=new Random().nextInt(1000);
        Thread.sleep(sleepTime);
        return sleepTime;
    }
}
