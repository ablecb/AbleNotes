package mytest.ch4.aqs;

/**
 * @ClassName TestLock
 * @Description TODO
 * @Author 曹博
 * @Date 2019/5/22 9:21
 * @Version 1.0
 */
public class TestLock {
    int count=0;
    AbleLock lock=new AbleLock();
    public void add() {
        lock.lock();
        count++;
        lock.unlock();
    }
    public int getCount(){
        return count;
    }

    public static void main(String[] args) throws InterruptedException {
        TestLock testLock=new TestLock();

        for(int i=0;i<2000;i++){
            Thread thread=new Thread(()->{
                for(int j=0;j<500;j++){
                    testLock.add();
                }
            });
            thread.start();
            thread.join();
        }


        System.out.println("count的值是"+testLock.getCount());
    }
}
