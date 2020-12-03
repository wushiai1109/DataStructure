package CyclicBarrierDemo;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @ClassName CyclicBarrierDemo1
 * @Description
 * @Author Bruce
 * @Date 2020/11/30 7:14 下午
 */
public class CyclicBarrierDemo1 {
    //可用于多线程计数数据，最后合并计数结果的场景。
    //使用CyclicBarrier实现等待的线程都被称为参与方。参与方只需要执行cyclicBarrier.await() 就可以实现等待。
    //由于CyclicBarrier内部维护了一个显示锁，这可以知道参与方中谁最后一个执行cyclicBarrier.await() 。
    // 当最后一个线程执行完，会使得使用相应CyclicBarrier实例的其他参与方被唤醒，而最后一个线程自身不会被暂停
    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(7, () -> {
            System.out.println("****召唤神龙");
        });
        for (int i = 1; i <= 7; i++) {
            int finalI = i;
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + "\t 收集到第" + finalI + "颗龙珠");
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }, String.valueOf(i)).start();
        }
    }
}
