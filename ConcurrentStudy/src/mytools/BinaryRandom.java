package mytools;

import java.util.Random;

/**
 * @ClassName mytools
 * @Description TODO
 * @Author 曹博
 * @Date 2019/5/23 12:55
 * @Version 1.0
 */
public class  BinaryRandom {
    public static void main(String[] args) {
        Random random=new Random();
        for(int i=0;i<32;i++){
            System.out.print(random.nextInt(2));
            int num=i&3;
            if(num==3){
                System.out.print("\t");
            }
        }
    }
}
