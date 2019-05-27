package mytest.ch6.mypool;

import java.util.Random;
import java.util.concurrent.*;

/**
 * @ClassName UseMyThreadPool
 * @Description 线程池的使用
 * @Author 曹博
 * @Date 2019/5/27 10:09
 * @Version 1.0
 */
public class UseMyThreadPool {
    static class  Worker implements Runnable{
        private String taskName;
        private Random random = new Random();
        public Worker(String taskName){
            this.taskName=taskName;
        }

        public String getTaskName() {
            return taskName;
        }

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName()+" process the task :"+taskName);
            try {
                Thread.currentThread().sleep(random.nextInt(100)*5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    static class CallWorker implements Callable<String>{
        public String getTaskName() {
            return taskName;
        }

        public CallWorker(String taskName) {
            this.taskName = taskName;
        }

        private String taskName;
        private Random random=new Random();
        @Override
        public String call() throws Exception {
            System.out.println(Thread.currentThread().getName()+" process the task : "+taskName);
            return Thread.currentThread().getName()+":"+random.nextInt(100)*5;
        }
    }

    public static void main(String[] args) throws  Exception{
       /* ExecutorService pool=new ThreadPoolExecutor(2,4,3, TimeUnit.SECONDS,
                new ArrayBlockingQueue<Runnable>(10),
                new ThreadPoolExecutor.DiscardOldestPolicy());*/
      // ExecutorService pool=Executors.newCachedThreadPool();
       // ExecutorService pool=Executors.newSingleThreadExecutor();
        ExecutorService pool=Executors.newFixedThreadPool(12);
        for(int i=0;i<6;i++){
            Worker worker=new Worker("worker_"+i);
            pool.execute(worker);
        }
        for(int i=0;i<6;i++){
            CallWorker worker=new CallWorker("callWorker_"+i);
            Future<String> result = pool.submit(worker);
            System.out.println(result.get());
        }
        pool.shutdown();
    }
}
