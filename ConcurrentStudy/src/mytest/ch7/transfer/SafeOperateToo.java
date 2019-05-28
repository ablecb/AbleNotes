package mytest.ch7.transfer;

import java.util.Random;

/**
 * @ClassName SafeOperateToo
 * @Description TODO
 * @Author 曹博
 * @Date 2019/5/28 8:33
 * @Version 1.0
 */
public class SafeOperateToo implements ITransfer {
    @Override
    public void transfer(UserAccount from, UserAccount to, int amount) throws InterruptedException {
        Random random=new Random();
        while(true){
            if(from.getLock().tryLock()){
                try{
                    if(to.getLock().tryLock()){
                        try{
                            //两把锁都拿到了
                            from.flyMoney(amount);
                            from.addMoney(amount);
                            break;
                        }catch(Exception e){
                            e.printStackTrace();
                        }finally{
                            to.getLock().unlock();
                        }
                    }
                }catch(Exception e){
                    e.printStackTrace();
                }finally{
                    from.getLock().unlock();
                }
            }
            Thread.currentThread().sleep(random.nextInt(10));
        }
    }
}
