package mytest.ch1.ch4.template;

/**
 * @ClassName SendSms
 * @Description TODO
 * @Author 曹博
 * @Date 2019/5/22 8:07
 * @Version 1.0
 */
public class SendSms extends  SendCustom{

    @Override
    public void to() {
        System.out.println("Mark");
    }

    @Override
    public void from() {
        System.out.println("Bill");
    }

    @Override
    public void content() {
        System.out.println("Hello World");
    }

    @Override
    public void sent() {
        System.out.println("Send sms");
    }

    public static void main(String[] args) {
        SendCustom send=new SendSms();
        send.sendMessage();
    }
}
