package mytest.ch5;

import com.sun.org.apache.xpath.internal.operations.Or;

import java.util.concurrent.DelayQueue;

/**
 * @ClassName PutOrder
 * @Description TODO
 * @Author 曹博
 * @Date 2019/5/24 14:02
 * @Version 1.0
 */
public class PutOrder implements  Runnable{
    private DelayQueue<ItemVO<Order>> queue;

    public PutOrder(DelayQueue<ItemVO<Order>> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        Order orderTb=new Order("Tb12345",360);
        ItemVO<Order> itemTb=new ItemVO<Order>(5000,orderTb);
        queue.offer(itemTb);
        System.out.println("订单5s后到期"+orderTb.getOrderNo());


        Order orderJd=new Order("Jd54321",360);
        ItemVO<Order> itemJd=new ItemVO<Order>(8000,orderJd);
        queue.offer(itemJd);
        System.out.println("订单8s后到期"+orderJd.getOrderNo());
    }
}
