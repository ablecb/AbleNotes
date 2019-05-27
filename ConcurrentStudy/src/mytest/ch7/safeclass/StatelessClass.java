package mytest.ch7.safeclass;

/**
 * @ClassName StatelessClass
 * @Description 无状态的类，没有任何的成员变量，线程安全
 * @Author 曹博
 * @Date 2019/5/27 20:00
 * @Version 1.0
 */
public class StatelessClass {
    public int service(int a,int b){
        return a*b;
    }
}
