package mytest.ch6.mypool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @ClassName MyThreadPool2
 * @Description TODO
 * @Author 曹博
 * @Date 2019/5/26 22:04
 * @Version 1.0
 */
public class MyThreadPool2 {
    //线程池中默认的线程池的个数
    private static int WORK_NUM=5;
    //队列默认的任务个数为100
    private static int TASK_COUNT=100;
    //任务队列，作为一个缓冲
    private WorkThread[] workThreads;
    private final BlockingQueue<Runnable> taskQueue;
    private final  int worker_num;
    //创建线程池,work_num为线程池中工作线程的个数
    public MyThreadPool2(int worker_num,int taskCount){
        if(worker_num<=0)
            worker_num=WORK_NUM;
        if(taskCount<=0)
            taskCount=TASK_COUNT;
        this.worker_num=worker_num;
        taskQueue=new ArrayBlockingQueue<>(taskCount);
        workThreads=new WorkThread[worker_num];
        for(int i=0;i<worker_num;i++){
            workThreads[i]=new WorkThread();
            workThreads[i].start();
        }
    }
    public MyThreadPool2(){
        this(WORK_NUM,TASK_COUNT);
    }
    public void execute(Runnable task){
        try {
            taskQueue.put(task);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void destroy(){
        System.out.println("ready close pool................");
        for(int i=0;i<worker_num;i++){
            workThreads[i].stopWorker();
            workThreads[i]=null;//help gc;
        }
        taskQueue.clear();//清空队列
    }

    @Override
    public String toString() {
        return "WorkThread  number:"+worker_num+"    wait task number:"+taskQueue.size();
    }

    private class WorkThread extends Thread{
        @Override
        public void run() {
            Runnable r=null;
            while(!isInterrupted()){
                try {
                    r=taskQueue.take();
                    if(r!=null){
                        System.out.println(getId()+" ready exec :"+r);
                        r.run();
                    }
                    r=null; //help gc;
                } catch (InterruptedException e) {
                    System.out.println("线程池被销毁了");
                }
            }
        }
        public void stopWorker(){
            interrupt();
        }
    }
}
