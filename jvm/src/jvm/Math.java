package jvm;

/**
 * @ClassName Math
 * @Description
 * @Author Bruce
 * @Date 2020/8/21 7:45 下午
 */
public class Math {

    public static int initData = 666;
    public static User user = new User();

    //一个方法对应一块栈帧内存区域

    public int compute() {
        int a = 1;
        int b = 2;
        int c = (a + b) * 10;
        return c;
    }

    public static void main(String[] args) {
        Math math = new Math();
        math.compute();
        Math math2 = new Math();
        math2.compute();
        new Thread().start();
    }

}
