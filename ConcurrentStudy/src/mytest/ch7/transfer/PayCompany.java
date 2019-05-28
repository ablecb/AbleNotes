package mytest.ch7.transfer;

import mytest.ch7.safeclass.SafeOperate;

/**
 * @ClassName PayCompany
 * @Description TODO
 * @Author 曹博
 * @Date 2019/5/28 8:23
 * @Version 1.0
 */
public class PayCompany {
    private static class TransferThread extends Thread{
        private String name;
        private UserAccount from;
        private UserAccount to;
        private int amount;
        private ITransfer transfer;
        public TransferThread(String name,UserAccount from,UserAccount to
        ,int amount,ITransfer transfer){
            this.name=name;
            this.from=from;
            this.to=to;
            this.amount =amount;
            this.transfer=transfer;
        }

        @Override
        public void run() {
            Thread.currentThread().setName(name);
            try{
                transfer.transfer(from,to, amount);
            }catch(Exception e){
                e.printStackTrace();
            }finally{

            }
        }
    }

    public static void main(String[] args) {
        PayCompany payCompany=new PayCompany();
        UserAccount zhangsan=new UserAccount("zhangsan",20000);
        UserAccount lisi=new UserAccount("lisi",20000);
        ITransfer transfer=new SafeOperate();
        TransferThread zhangsanToLisi=new TransferThread("zhangsanToLisi",zhangsan,lisi,2000,transfer);
        TransferThread lisiToZhangsan=new TransferThread("lisiToZhangsan",lisi,zhangsan,4000,transfer);
        zhangsanToLisi.start();
        lisiToZhangsan.start();
    }
}
