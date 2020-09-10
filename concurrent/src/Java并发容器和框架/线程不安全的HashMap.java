package Java并发容器和框架;

import java.util.HashMap;
import java.util.UUID;

/**
 * @ClassName 线程不安全的HashMap
 * @Description
 * @Author Bruce
 * @Date 2020/7/29 12:20 下午
 */
public class 线程不安全的HashMap {

    public static void main(String[] args) throws InterruptedException {

        final HashMap<String, String> map = new HashMap<String, String>(2);
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            map.put(UUID.randomUUID().toString(), "");
                        }
                    }, "ftf" + i).start();
                }
            }
        }, "ftf");

        t.start();
        t.join();
    }
}