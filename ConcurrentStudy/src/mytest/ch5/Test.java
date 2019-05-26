package mytest.ch5;

import java.util.concurrent.DelayQueue;

/**
 * @ClassName Test
 * @Description 测试延时订单
 * @Author 曹博
 * @Date 2019/5/24 14:15
 * @Version 1.0
 */
public class Test {
    public static void main(String[] args) throws  Exception{
        DelayQueue<ItemVO<Order>> queue=new DelayQueue<>();
        new Thread(new PutOrder(queue)).start();
        new Thread(new FetchOrder(queue)).start();
        for(int i=0;i<15;i++){
            Thread.sleep(500);
            System.out.println(i*500);
        }
    }
}
