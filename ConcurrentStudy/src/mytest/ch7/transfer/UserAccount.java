package mytest.ch7.transfer;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName UserAccount
 * @Description TODO
 * @Author 曹博
 * @Date 2019/5/28 8:18
 * @Version 1.0
 */
public class UserAccount {
    //private int id;
    private String name;
    private int money;
    private final Lock lock=new ReentrantLock();
    public Lock getLock(){
        return lock;
    }
    public UserAccount(String name, int money) {
        this.name = name;
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void flyMoney(int amount) {
    }

    public void addMoney(int amount) {
    }
}
