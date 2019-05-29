package mytest.ch7.performance;

import javax.swing.*;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Pattern;

/**
 * @ClassName ReduceLock
 * @Description TODO
 * @Author 曹博
 * @Date 2019/5/28 11:00
 * @Version 1.0
 */
public class ReduceLock {
    private Map<String,String> matchMap=new HashMap<>();
    //private Map<String,String> matchMap=new ConcurrentHashMap<>();
    public synchronized boolean isMatch(String name,String regexp){
        String key="user."+name;
        String job=matchMap.get(key);
        if(job==null){
            return false;
        }else {
            return Pattern.matches(regexp,job);
        }
    }
    public boolean isMatchReduce(String name,String regexp){
        String key="user."+name;
        String job;
        synchronized (this){
           job=matchMap.get(key);
        }
        if(job==null){
            return false;
        }else {
            return Pattern.matches(regexp,job);
        }
    }
}
