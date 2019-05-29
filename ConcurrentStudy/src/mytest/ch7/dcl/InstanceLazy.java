package mytest.ch7.dcl;

/**
 * @ClassName InstanceLazy
 * @Description TODO
 * @Author 曹博
 * @Date 2019/5/28 18:35
 * @Version 1.0
 */
public class InstanceLazy {
    private Integer value;
    private Integer val;
    public InstanceLazy(Integer value){
        this.value=value;
    }
    public Integer getValue(){
        return  value;
    }
    private static class ValHolder{
        public static Integer vHolder=new Integer(10000000);
    }
    public Integer getVal(){
        return ValHolder.vHolder;
    }
}
