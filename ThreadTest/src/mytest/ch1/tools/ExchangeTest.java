package mytest.ch1.tools;

import org.omg.PortableServer.THREAD_POLICY_ID;

import java.util.concurrent.Exchanger;

/**
 * @ClassName ExchangeTest
 * @Description TODO
 * @Author 曹博
 * @Date 2019/5/21 10:28
 * @Version 1.0
 */
public class ExchangeTest {
    static Exchanger<String > exchanger=new Exchanger<>();

    public static void main(String[] args) {
        new Thread(()->{
            String t1="我是t1线程";
            try {
                System.out.println(Thread.currentThread().getName()+"开始交换数据了，我的数据是"+t1);
                String  t2=exchanger.exchange(t1);
                System.out.println("交换后，"+Thread.currentThread().getName()+"获得的字符串是:"+t2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"t1").start();
        new Thread(()->{
            String t1="我是t2线程";
            try {
                System.out.println(Thread.currentThread().getName()+"开始交换数据了，我的数据是"+t1);
                String t2=exchanger.exchange(t1);
                System.out.println("交换后，"+Thread.currentThread().getName()+"获得的字符串是:"+t2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"t2").start();
    }
}
