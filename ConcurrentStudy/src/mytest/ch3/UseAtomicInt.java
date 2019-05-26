package mytest.ch3;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @ClassName UseAtomicInt
 * @Description TODO
 * @Author 曹博
 * @Date 2019/5/21 14:59
 * @Version 1.0
 */
public class UseAtomicInt {
    static AtomicInteger ai=new AtomicInteger(10);
    public static void main(String[] args) {
        System.out.println(ai.getAndIncrement());
        System.out.println(ai.get());
        System.out.println(ai.incrementAndGet());
        System.out.println(ai.get());
    }
}
