package mytest.ch3;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @ClassName UseAtomicReference
 * @Description TODO
 * @Author 曹博
 * @Date 2019/5/21 15:03
 * @Version 1.0
 */
public class UseAtomicReference {
    static  AtomicReference<UserInfo>  userRef=new AtomicReference<>();
    static  class  UserInfo{
        private String name;
        private int age;

        public UserInfo(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }
    }

    public static void main(String[] args) {
        UserInfo userInfo=new UserInfo("Mark",15);
        UserInfo userInfo1=new UserInfo("lison",18);
        userRef.set(userInfo);
        userRef.compareAndSet(userInfo,userInfo1);
        UserInfo info=userRef.get();
        System.out.println(info.getName());
        System.out.println(info.getAge());
    }
}
