package mytest.ch7.dcl;

/**
 * @ClassName SingleInit
 * @Description TODO
 * @Author 曹博
 * @Date 2019/5/28 18:32
 * @Version 1.0
 */
public class SingleInit {
    private SingleInit(){

    }
    private  static  class InstanceHolder{
        public static SingleInit instance=new SingleInit();
    }
    public static SingleInit getInstance(){
        return InstanceHolder.instance;
    }
}
