package mytest.ch7.performance;

import javafx.scene.effect.SepiaTone;

import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName FinenessLock
 * @Description TODO
 * @Author 曹博
 * @Date 2019/5/28 17:23
 * @Version 1.0
 */
public class FinenessLock {
    public final Set<String> users=new HashSet<String>();
    public final Set<String> queries=new HashSet<>();
    /*public synchronized void addUser(String u){
        users.add(u);
    }*/
    public  void addUser(String u){
        synchronized (users){
            users.add(u);
        }
    }
    //下面的依次改变
    public synchronized void addQuery(String q){
        queries.add(q);
    }
    public synchronized void removeUser(String u){
        users.remove(u);
    }
    public synchronized void removeQuery(String q){
        queries.remove(q);
    }
}
