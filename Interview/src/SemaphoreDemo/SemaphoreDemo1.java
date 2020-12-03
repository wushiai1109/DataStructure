package SemaphoreDemo;

import java.util.concurrent.*;

/**
 * @ClassName SemaphoreDemo1
 * @Description
 * @Author Bruce
 * @Date 2020/11/30 7:31 下午
 */
public class SemaphoreDemo1 {
    /**
     * 线程数量
     */
    private static final int THREAD_COUNT = 30;

    /**
     * 线程池
     */
    private static ExecutorService executor = Executors.newFixedThreadPool(THREAD_COUNT);
//    private static ExecutorService executor = new ThreadPoolExecutor(THREAD_COUNT, 10, 60, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(5), Executors.defaultThreadFactory());

    private static Semaphore semaphore = new Semaphore(10);

    public static void main(String[] args) {
        for (int i = 0; i < THREAD_COUNT; i++) {
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        // 获取一个"许可证"
                        semaphore.acquire();

                        // 模拟数据保存
                        TimeUnit.SECONDS.sleep(2);
                        System.out.println("save date...");

                        // 执行完后,归还"许可证"
                        semaphore.release();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        executor.shutdown();
    }
}
