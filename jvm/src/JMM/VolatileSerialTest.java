package JMM;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @ClassName VolatileSeriaTest
 * @Description
 * @Author Bruce
 * @Date 2020/8/28 8:29 下午
 */
public class VolatileSerialTest {
//    static volatile int x = 0, y = 0;
    static int x = 0, y = 0;

    public static void main(String[] args) throws InterruptedException {
        Set<String> resultSet = new HashSet<>();
        Map<String, Integer> resultMap = new HashMap<>();
        for (int i = 0; i < 1000000; i++) {
            x = 0;
            y = 0;
            resultMap.clear();
            Thread one = new Thread(new Runnable() {
                @Override
                public void run() {
                    int a = y;//3
                    x = 1;//1
                    resultMap.put("a", a);
                }
            });
            Thread other = new Thread(new Runnable() {
                @Override
                public void run() {
                    int b = x;//4
                    y = 1;//2
                    resultMap.put("b", b);
                }
            });
            one.start();
            other.start();
            one.join();
            other.join();
            System.out.println(resultMap);
        }
    }
}
