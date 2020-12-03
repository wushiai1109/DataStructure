package CountDownLatchDemo;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @ClassName CountDownLatchDemo2
 * @Description
 * @Author Bruce
 * @Date 2020/11/30 6:44 下午
 */
public class CountDownLatchDemo2 {
    //很多时候，我们的并发任务，存在前后依赖关系；比如数据详情页需要同时调用多个接口获取数据，
    // 并发请求获取到数据后、需要进行结果合并；或者多个数据操作完成后，需要数据check；
    // 这其实都是：在多个线程(任务)完成后，进行汇总合并的场景。
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(5);
        for (int i = 0; i < 5; i++) {
            final int index = i;
            new Thread(() -> {
                try {
                    //一文秒懂 Java ThreadLocalRandom：https://www.twle.cn/c/yufei/javatm/javatm-basic-threadLocalrandom.html
                    Thread.sleep(1000 + ThreadLocalRandom.current().nextInt(1000));
                    System.out.println("finish" + index + Thread.currentThread().getName());
                    countDownLatch.countDown();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }

        countDownLatch.await();// 主线程在阻塞，当计数器==0，就唤醒主线程往下执行。
        System.out.println("主线程:在所有任务运行完成后，进行结果汇总");
    }
    //finish2Thread-2
    //finish4Thread-4
    //finish3Thread-3
    //finish1Thread-1
    //finish0Thread-0
    //主线程:在所有任务运行完成后，进行结果汇总
}
