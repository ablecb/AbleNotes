package mytest.ch5;

import java.util.concurrent.DelayQueue;

/**
 * @ClassName FetchOrder
 * @Description TODO
 * @Author 曹博
 * @Date 2019/5/24 14:10
 * @Version 1.0
 */
public class FetchOrder implements Runnable {
    private DelayQueue<ItemVO<Order>> queue;

    public FetchOrder(DelayQueue<ItemVO<Order>> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true){
            try {
                ItemVO<Order> item=queue.take();
                Order order=(Order)item.getDate();
                System.out.println("get from queue "+order.getOrderNo());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
