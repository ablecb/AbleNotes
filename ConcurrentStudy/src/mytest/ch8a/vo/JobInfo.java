package mytest.ch8a.vo;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @ClassName JobInfo
 * @Description TODO
 * @Author 曹博
 * @Date 2019/5/28 19:56
 * @Version 1.0
 */
public class JobInfo<R> {
    //区分唯一的工作
    private final String jobName;
    //工作的任务个数
    private final int jobLength;
    private final ITaskProcesser<?,?> taskProcesser;
    private AtomicInteger successCount;
    private AtomicInteger taskProcesserCount;
    private LinkedBlockingDeque<TaskResult<R>> taskDetailQueue;
    private final long expireTime;

    public JobInfo(String jobName,
                   int jobLength,
                   ITaskProcesser<?, ?> taskProcesser,
                   LinkedBlockingDeque<TaskResult<R>> taskDetailQueue,
                   long expireTime) {
        this.jobName = jobName;
        this.jobLength = jobLength;
        this.taskProcesser = taskProcesser;
        this.successCount = new AtomicInteger(0);
        this.taskProcesserCount = new AtomicInteger(0);
        this.taskDetailQueue = taskDetailQueue;
        this.expireTime = expireTime;
    }

    public int getSuccessCount() {
        return successCount.get();
    }



    public int getTaskProcesserCount() {
        return taskProcesserCount.get();
    }

    public List<TaskResult<R>> getTaskDetail(){
        List<TaskResult<R>> taskList=new LinkedList<>();
        TaskResult<R> taskResult ;
        while((taskResult=taskDetailQueue.pollFirst())!=null){
            taskList.add(taskResult);
        }
        return taskList;
    }
    //从业务应用的角度来讲，保证最终一致性即可，不需要对方法加锁的
    public void addTaskResult(TaskResult<R> result){
        if(TaskResultType.Success.equals(result.getResultType())){
            successCount.incrementAndGet();
        }
        taskDetailQueue.addLast(result);
        taskProcesserCount.incrementAndGet();
    }
}
