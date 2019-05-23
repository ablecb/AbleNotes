package mytest.ch5;

import com.sun.deploy.panel.ITreeNode;


/**
 * @ClassName IntToBinary
 * @Description TODO
 * @Author 曹博
 * @Date 2019/5/23 11:39
 * @Version 1.0
 */
public class IntToBinary {
    public static void main(String[] args) throws  Exception{
        int data=4;
        System.out.println("the 4 Binary is"+Integer.toBinaryString(4));

        System.out.println("the 6 Binary is"+Integer.toBinaryString(6));
        //位与
        System.out.println(Integer.toBinaryString(4&6));
        //位或
        System.out.println(Integer.toBinaryString(4|6));
        //位非
        System.out.println(Integer.toBinaryString(~4));
        System.out.println(Integer.toBinaryString(~4).length());
        //位异或
        System.out.println(Integer.toBinaryString(4^6));


        System.out.println(" the Binary of 5 is "+Integer.toBinaryString(5));
        System.out.println(5<<2);
        System.out.println(" the Binary of  5<<2 is "+Integer.toBinaryString(5<<2) );
        System.out.println("============================================");
        System.out.println("5的原码是："+Integer.toBinaryString(5));
        System.out.println("5的反码是："+Integer.toBinaryString(~5));
        System.out.println(" the Binary of -5 is "+Integer.toBinaryString(-5));
        System.out.println(-5<<2);
        System.out.println(" the Binary of  -5<<2 is "+Integer.toBinaryString(-5<<2) );
    }
}
