package mytest.ch7.safeclass;

/**
 * @ClassName ImmutableFinal
 * @Description 不可变的类
 * @Author 曹博
 * @Date 2019/5/27 20:05
 * @Version 1.0
 */
public class ImmutableFinal {
    private  final int a;
    private final int b;

    public ImmutableFinal(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }
}
