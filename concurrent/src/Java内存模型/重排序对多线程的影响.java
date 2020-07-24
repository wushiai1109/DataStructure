package Java内存模型;

/**
 * @ClassName 重排序多多线程的影响
 * @Description
 * @Author Bruce
 * @Date 2020/7/14 8:14 下午
 */
public class 重排序对多线程的影响 {
    int a = 0;
    boolean flag = false;

    public void writer() {
        a = 1;
        flag = true;
    }

    public void reader() {
        if (flag) {
            int i = a * a;
            
        }
    }

}
