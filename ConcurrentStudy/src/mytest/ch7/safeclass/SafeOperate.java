package mytest.ch7.safeclass;

import mytest.ch7.transfer.ITransfer;
import mytest.ch7.transfer.UserAccount;

import java.util.Random;

/**
 * @ClassName SafeOperate
 * @Description TODO
 * @Author 曹博
 * @Date 2019/5/28 9:01
 * @Version 1.0
 */
public class SafeOperate implements ITransfer {
    private  static Object tieLock=new Object();//加时赛
    @Override
    public void transfer(UserAccount from, UserAccount to, int amount) throws InterruptedException {
        int fromHash=System.identityHashCode(from);
        int toHash=System.identityHashCode(to);
        if(fromHash<toHash){
            synchronized (from){
                System.out.println(Thread.currentThread().getName()+" get "+from.getName());
                Thread.sleep(100);
                synchronized (to){
                    System.out.println(Thread.currentThread().getName()+" get "+to.getName());
                    from.flyMoney(amount);
                    to.addMoney(amount);
                }
            }
        }else if(toHash <fromHash){
            synchronized (to){
                System.out.println(Thread.currentThread().getName()+" get "+to.getName());
                Thread.sleep(100);
                synchronized (from){
                    System.out.println(Thread.currentThread().getName()+" get "+from.getName());
                    from.flyMoney(amount);
                    to.addMoney(amount);
                }
            }
        }else{
            synchronized (tieLock){
                synchronized (from){
                    synchronized (to){
                        from.flyMoney(amount);
                        to.addMoney(amount);
                    }
                }
            }
        }
    }
}
