package mytest.ch3;

import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * @ClassName UseAtomicStampReference
 * @Description TODO
 * @Author 曹博
 * @Date 2019/5/21 15:16
 * @Version 1.0
 */
public class UseAtomicStampReference {
    static AtomicStampedReference<String> asr=new AtomicStampedReference<String>("Mark",15);
    public static void main(String[] args) throws  Exception{
        final int oldStamp=asr.getStamp();
        final String oldRef=asr.getReference();
        System.out.println(oldRef+"  "+oldStamp);
        asr.compareAndSet("Mark","able",15,18);
        final int newStramp=asr.getStamp();
        final String newRef=asr.getReference();
        System.out.println(newRef+"\t"+newStramp);
    }
}
