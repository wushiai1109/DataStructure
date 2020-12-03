import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.TreeSet;
import java.util.concurrent.*;

/**
 * @ClassName Demo
 * @Description
 * @Author Bruce
 * @Date 2020/11/30 8:45 上午
 */
public class Demo {

    public static void main(String[] args) {
//        System.out.println(Math.ceil(12.5));
//        System.out.println(Math.floor(12.5));
//        System.out.println(Math.rint(3.2));
//        //rint() 方法返回最接近参数的整数值。若存在两个这样的数，则返回其中的偶数值
//        System.out.println(Math.rint(101.5));//102
//        System.out.println(Math.rint(100.5));//100
//        System.out.println(Math.round(12.5));
//        System.out.println(Math.round(-12.5));

        HashMap<Integer, Integer> integerIntegerHashMap = new HashMap<>();
        integerIntegerHashMap.put(1,1);
        integerIntegerHashMap.put(3,3);
        integerIntegerHashMap.put(2,2);
        integerIntegerHashMap.put(4,4);
        System.out.println(integerIntegerHashMap);

        TreeSet<Integer> integers = new TreeSet<>();
        integers.add(2);
        integers.add(3);
        integers.add(1);
        integers.add(5);
        integers.add(4);
        System.out.println(integers);

        LinkedHashMap<Integer, Integer> integerIntegerLinkedHashMap = new LinkedHashMap<>();
        integerIntegerLinkedHashMap.put(1,1);
        integerIntegerLinkedHashMap.put(3,3);
        integerIntegerLinkedHashMap.put(2,2);
        integerIntegerLinkedHashMap.put(4,4);
        System.out.println(integerIntegerLinkedHashMap);
    }

    ExecutorService pool = new ThreadPoolExecutor(2,3,60, TimeUnit.MINUTES,new ArrayBlockingQueue<Runnable>(5),Executors.defaultThreadFactory());



    Executor executor = new Executor() {
        @Override
        public void execute(Runnable command) {

        }
    };
}
