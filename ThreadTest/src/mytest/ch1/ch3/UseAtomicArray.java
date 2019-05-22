package mytest.ch1.ch3;

import java.util.concurrent.atomic.AtomicIntegerArray;

/**
 * @ClassName UseAtomicArray
 * @Description TODO
 * @Author 曹博
 * @Date 2019/5/21 15:25
 * @Version 1.0
 */
public class UseAtomicArray {
    static  int[] value=new int[]{1,2};
    static AtomicIntegerArray atomicIntegerArray=new AtomicIntegerArray(value);

    public static void main(String[] args) {
        atomicIntegerArray.getAndSet(0,2222);
        System.out.println(atomicIntegerArray.get(0));
        System.out.println(value[0]);
    }
}
