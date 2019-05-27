package mytest.ch7.safeclass;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName ImmutetableToo
 * @Description 类说明:不可变的类（不提供任何可修改成员变量的地方，同时成员变量页不作为方法的返回）
 * @Author 曹博
 * @Date 2019/5/27 22:07
 * @Version 1.0
 */
public class ImmutetableToo {
    private  final List<Integer> list = new ArrayList<Integer>(3);
    public ImmutetableToo(){
        list.add(1);
        list.add(2);
        list.add(3);
    }
    public boolean isContains(int i){
        return list.contains(i);
    }
}
