package mytest.ch1.ch4.template;

import java.util.Date;

/**
 * @ClassName SendCustom
 * @Description TODO
 * @Author 曹博
 * @Date 2019/5/22 8:03
 * @Version 1.0
 */
public abstract class SendCustom {
    public abstract void to();
    public abstract  void  from();
    public abstract  void content();
    public void date(){
        System.out.println(new Date());
    }
    public abstract void sent();
    public void sendMessage(){
        to();
        from();
        content();
        date();
        sent();
    }
}
