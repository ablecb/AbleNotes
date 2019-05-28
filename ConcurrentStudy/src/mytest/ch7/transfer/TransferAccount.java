package mytest.ch7.transfer;

import org.omg.PortableServer.THREAD_POLICY_ID;

/**
 * @ClassName TransferAccount
 * @Description TODO
 * @Author 曹博
 * @Date 2019/5/28 8:19
 * @Version 1.0
 */
public class TransferAccount implements ITransfer{
    @Override
    public void transfer(UserAccount from, UserAccount to, int amount)
            throws InterruptedException {
        synchronized (from){
            System.out.println(Thread.currentThread().getName()+" get "+from.getName());
            Thread.sleep(100);
            synchronized (to){
                System.out.println(Thread.currentThread().getName()+" get "+to.getName());
                from.flyMoney(amount);
                to.addMoney(amount);
            }
        }
    }
}
