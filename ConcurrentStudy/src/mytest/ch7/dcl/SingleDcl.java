package mytest.ch7.dcl;

/**
 * @ClassName SingleDcl
 * @Description TODO
 * @Author 曹博
 * @Date 2019/5/27 20:00
 * @Version 1.0
 */
public class SingleDcl {
    private volatile static SingleDcl singleDcl;
    private SingleDcl(){

    }
    public static SingleDcl getInstance(){
        if(singleDcl==null){
            synchronized (SingleDcl.class){
                if(singleDcl==null){
                    singleDcl=new SingleDcl();
                }
            }
        }
        return singleDcl;
    }
}
