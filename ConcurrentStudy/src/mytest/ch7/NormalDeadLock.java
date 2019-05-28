package mytest.ch7;

/**
 * @ClassName NormalDeadLock
 * @Description 死锁
 * @Author 曹博
 * @Date 2019/5/28 7:43
 * @Version 1.0
 */
public class NormalDeadLock {
    private static Object valueFirst=new Object();//第一个锁
    private static Object valueSecond=new Object();//第二个锁
    //先拿第一个锁，再拿第二个锁
    private static void firstToSecond() throws InterruptedException {
        String threadName=Thread.currentThread().getName();
        synchronized (valueFirst){
            System.out.println(threadName+" get second");
            Thread.currentThread().sleep(100);
            synchronized (valueSecond){
                System.out.println(threadName+" get first");
            }
        }
    }
    private  static  void secondToFirst() throws InterruptedException {
        String threadName=Thread.currentThread().getName();
        synchronized (valueSecond){
            System.out.println(threadName+" get second");
            Thread.currentThread().sleep(100);
            synchronized (valueFirst){
                System.out.println(threadName+" get first");
            }
        }
    }
    private static class TestThread extends Thread{
        private String name;

        public TestThread(String name) {
            this.name = name;
        }

        @Override
        public void run() {
            Thread.currentThread().setName(name);
            try{
                secondToFirst();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Thread.currentThread().setName("ThreadDeadLock");
        TestThread testThread=new TestThread("SubTestThread");
        testThread.start();
        try {
            //Thread.currentThread().sleep(2000);
            firstToSecond();
        }catch (Exception e){

        }
    }
}
