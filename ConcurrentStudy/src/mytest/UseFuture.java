package mytest;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * @ClassName UseFuture
 * @Description TODO
 * @Author 曹博
 * @Date 2019/5/21 10:51
 * @Version 1.0
 */
public class UseFuture {
    private  static  class  UseCallable implements Callable<Integer>{
        private  int sum;
        /**
         * Computes a result, or throws an exception if unable to do so.
         *
         * @return computed result
         * @throws Exception if unable to compute a result
         */
        @Override
        public Integer call() throws Exception {
            System.out.println("Callable 子线程开始计算");
            Thread.currentThread().sleep(2);
            for(int i=0;i<5000;i++){
                sum=sum+i;
            }
            System.out.println("Callable子线程计算完成，结果是"+sum);
            return sum;
        }
    }

    public static void main(String[] args) throws  Exception {
        UseCallable callable=new UseCallable();
        FutureTask<Integer> futureTask=new FutureTask<Integer>(callable);
        new Thread(futureTask).start();
        Random random=new Random();
        Thread.currentThread().sleep(1);
        if(random.nextBoolean()){
            System.out.println("Get UseCallable  result"+futureTask.get());
        }else {
            System.out.println("中断操作");
            futureTask.cancel(true);
        }
    }
}
