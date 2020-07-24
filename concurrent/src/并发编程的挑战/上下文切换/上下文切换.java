package 并发编程的挑战.上下文切换;

/**
 * @ClassName 上下文切换
 * @Description 即使是单核处理器也支持多线程执行代码，CPU通过给每个线程分配CPU时间片来实现这个机制。
 * 时间片是CPU分配给各个线程的时间，因为时间片非常短，所以CPU通过不停地切换线程执行，让我们感觉多个线程是同时执行的，时间片一般是几十毫秒(ms)。
 * CPU通过时间片分配算法来循环执行任务，当前任务执行一个时间片后会切换到下一个任务。
 * 但是，在切换前会保存上一个任务的状态，以便下次切换回这个任务时，可以再加载这个任务的状态。所以任务从保存到再加载的过程就是一次上下文切换。
 * 这就像我们同时读两本书，当我们在读一本英文的技术书时，发现某个单词不认识，于是 便打开中英文字典，但是在放下英文技术书之前，
 * 大脑必须先记住这本书读到了多少页的第多少行，等查完单词之后，能够继续读这本书。这样的切换是会影响读书效率的，同样上下文切换也会影响多线程的执行速度。
 * @Author Bruce
 * @Date 2020/7/13 3:20 下午
 */
public class 上下文切换 {

    private static final long count = 10000;

    public static void main(String[] args) throws InterruptedException {
        concurrency();
        serial();
    }

    private static void concurrency() throws InterruptedException {
        long start = System.currentTimeMillis();
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                int a = 0;
                for (long i = 0; i < count; i++) {
                    a += 5;
                }
            }
        });
        thread.start();
        int b = 0;
        for (long i = 0; i < count; i++) {
            b--;
        }
        long time = System.currentTimeMillis() - start;
        thread.join();
        System.out.println("concurrency :" + time + "ms,b=" + b);
    }

    private static void serial() {

        long start = System.currentTimeMillis();
        int a = 0;
        for (long i = 0; i < count; i++) {
            a += 5;
        }

        int b = 0;
        for (long i = 0; i < count; i++) {
            b--;
        }

        long time = System.currentTimeMillis() - start;
        System.out.println("serial:" + time + "ms,b=" + b + ",a=" + a);
    }
}
