package JMM;

/**
 * @ClassName VolatileAtomicTest
 * @Description
 * @Author Bruce
 * @Date 2020/8/28 8:05 下午
 */
public class VolatileAtomicTest {

    public static volatile int num = 0;

    public static void increase() {
        num++;
    }

    public static void main(String[] args) throws InterruptedException {

        Thread[] threads = new Thread[10];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < 1000; i++) {
                        increase();
                    }
                }
            });
            threads[i].start();
        }

        for (Thread t : threads) {
            //t.join()方法阻塞调用此方法的线程(calling thread)，直到线程t完成，此线程再继续
            t.join();
        }

        //1000*10=10000
        System.out.println(num);

    }
}
