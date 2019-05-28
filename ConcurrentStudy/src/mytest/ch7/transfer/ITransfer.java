package mytest.ch7.transfer;

/**
 * @ClassName ITransfer
 * @Description TODO
 * @Author 曹博
 * @Date 2019/5/28 8:17
 * @Version 1.0
 */
public interface ITransfer {
    void transfer(UserAccount from,UserAccount to,int amount)throws InterruptedException;
}
