package mytest.ch8a;

/**
 * @ClassName a
 * @Description TODO
 * @Author 曹博
 * @Date 2019/5/28 19:44
 * @Version 1.0
 */
public class a {
    public static void  add(int[] array){
        array[array.length-1]=10000;
    }

    public static void main(String[] args) {
        int[] array=new int[2];
        a.add(array);
        System.out.println(array[1]);
    }
}
