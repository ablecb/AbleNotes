package mytest.ch7.safeclass;

/**
 * @ClassName ImmutableFinal
 * @Description 看起来不可变的类，实际可以改变
 * @Author 曹博
 * @Date 2019/5/27 20:05
 * @Version 1.0
 */
public class ImmutableFinalRef {
    private  final int a;
    private final int b;
    private final User user;//这里，就不能保证线程安全了

    public User getUser() {
        return user;
    }

    public ImmutableFinalRef(int a, int b) {
        this.a = a;
        this.b = b;
        this.user=new User(35);
    }

    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }
    public static  class User{
        private final int age;

        public User(int age) {
            this.age = age;
        }

        public int getAge() {
            return age;
        }


    }

    public static void main(String[] args) {
        ImmutableFinalRef ref=new ImmutableFinalRef(12,23);
        User u=ref.getUser();
    }
}
