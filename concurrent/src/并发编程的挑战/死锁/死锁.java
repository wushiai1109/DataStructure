package 并发编程的挑战.死锁;

/**
 * @ClassName 死锁
 * @Description
 * @Author Bruce
 * @Date 2020/7/13 4:59 下午
 */
public class 死锁 {
    private static String A = "A";
    private static String B = "B";

    public static void main(String[] args) {
        new 死锁().deadLock();
    }

    private void deadLock() {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (A) {
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (B) {
                        System.out.println("1");
                    }
                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (B) {
                    synchronized (A) {
                        System.out.println("2");
                    }
                }
            }
        });
        t1.start();
        t2.start();
    }
}
