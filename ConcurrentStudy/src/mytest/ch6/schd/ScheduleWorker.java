package mytest.ch6.schd;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @ClassName ScheduleWorker
 * @Description TODO
 * @Author 曹博
 * @Date 2019/5/27 10:52
 * @Version 1.0
 */
public class ScheduleWorker implements Runnable{
    public final static  int Normal=0;//普通任务类别
    public final static int HasException=-1;//会抛出异常的任务类型
    public final static  int ProcessException=1;//会抛出异常但会捕捉的任务类别
    public static SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private int taskType;

    public ScheduleWorker(int taskType) {
        this.taskType = taskType;
    }

    @Override
    public void run() {
        if(taskType==HasException){
            System.out.println(format.format(new Date())+"Exception made ....");
            throw  new RuntimeException("HasException Happen");
        }else if(taskType==ProcessException){
            try {
                System.out.println(format.format(new Date())+"Exception made ....,but catch");
                throw  new RuntimeException("HasException Happen");
            }catch (Exception e){
                System.out.println("Exception  is catched");
            }
        }else{
            System.out.println("Normal  ..........."+format.format(new Date()));
        }
    }
}
