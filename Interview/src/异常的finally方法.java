/**
 * @author Wushiai
 * @date 2020/2/22 11:23
 * @content 代码在走到第 3 行的时候遇到了一个MathException，
 * 这时第四行的代码就不会执行了，代码直接跳转到 catch语句中，
 * 走到第 6 行的时候，异常机制有这么一个原则如果在 catch 中遇到了 return或者异常等能使该函数终止的话
 * 那么有 finally 就必须先执行完 finally 代码块里面的代码然后再返回值。
 * 因此代码又跳到第 8 行，可惜第 8 行是一个 return 语句，那么这个时候方法就结束了，
 * 因此第 6 行的返回结果就无法被真正返回。如果 finally 仅仅是处理了一个 释放资源的操作，
 * 那么该道题最终返回的结果就是 2。因此上面返回值是 3。
 */
public class 异常的finally方法 {
    public static void main(String[] args) {
        System.out.println(new 异常的finally方法().getNumy());
    }

    public int getNumy() {
        try {
            int a = 1 / 0;
            return 1;
        } catch (Exception e) {
            return 2;
        } finally {
            return 3;
        }
    }
}
