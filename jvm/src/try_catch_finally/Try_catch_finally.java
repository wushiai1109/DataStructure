package try_catch_finally;

/**
 * @ClassName Try_catch_finally
 * @Description
 * @Author Bruce
 * @Date 2020/9/26 3:16 下午
 */
public class Try_catch_finally {

    public static void main(String[] args) {
        System.out.println(new Try_catch_finally().TestReturn());
    }

    //测试return方法
    public int TestReturn() {
        try {
            return 1;
        } catch (Exception e) {
            return 2;
        } finally {
            return 3;
        }
    }
    //分析：try中没有异常，因此会先执行return 1，不会执行catch部分的代码return2;然后继续执行finally部分的代码return 3。
    // 最后程序返回3。有人可能会不理解，明明return就是返回了，为何还会继续执行catch和finally部分的代码块。
    // 这里我们可以粗浅地理解为try...catch...fianlly本身设置的一种处理机制。
    // 不管有没有异常，除非程序被强制终止，否则finally是一定要进去的。因此最后的返回值以finally里面的为准。
    // 而如果在try、catch或者finally中执行了return语句，try...catch...finally以外的代码块则不会再被执行。
    //
    //从Java虚拟机的角度来看：return指令分为两条字节码指令iload和ireturn，其中ireturn语句必须在整个方法中需要执行的代码都执行完了他才能执行。
    // 首先执行try部分的代码return 1中的iload部分，先把1这个数放到操作数栈顶。
    // 然后进入finally部分，执行return 3，同样地，把3放到操作数栈顶，覆盖原来的1。
    // 此时JVM发现TestReturn方法中所有需要执行的代码块都已经执行完毕了，于是就执行ireturn。最终返回3。
}
