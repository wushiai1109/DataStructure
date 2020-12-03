package CountDownLatchDemo;

import java.util.concurrent.CountDownLatch;

/**
 * @ClassName CountDownLatchDemo
 * @Description
 * @Author Bruce
 * @Date 2020/11/30 6:38 下午
 */
public class CountDownLatchDemo1 {
    //为了模拟高并发，让一组线程在指定时刻(秒杀时间)执行抢购，这些线程在准备就绪后，进行等待(CountDownLatch.await())，
    // 直到秒杀时刻的到来，然后一拥而上。这也是本地测试接口并发的一个简易实现。
    //在这个场景中，CountDownLatch充当的是一个发令枪的角色；就像田径赛跑时，运动员会在起跑线做准备动作，
    // 等到发令枪一声响，运动员就会奋力奔跑。和上面的秒杀场景类似。
    //通过CountDownLatch.await()，让多个参与者线程启动后阻塞等待，然后在主线程调用CountDownLatch.countdown(1) 将计数减为0，
    // 让所有线程一起往下执行；以此实现了多个线程在同一时刻并发执行，来模拟并发请求的目的。
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                try {
                    //准备完毕……运动员都阻塞在这，等待号令
                    countDownLatch.await();
                    String parter = "【" + Thread.currentThread().getName() + "】";
                    System.out.println(parter + "开始执行……");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }
        Thread.sleep(2000);// 裁判准备发令
        countDownLatch.countDown();// 发令枪：执行发令
    }
}
