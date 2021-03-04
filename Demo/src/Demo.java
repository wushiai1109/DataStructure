import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.concurrent.*;

/**
 * @ClassName Demo
 * @Description
 * @Author Bruce
 * @Date 2020/11/30 8:45 上午
 */
public class Demo {

    private static final ThreadLocal<DateFormat> df = new ThreadLocal<DateFormat>() {
        @Override
        protected DateFormat initialValue() {
            return new SimpleDateFormat("yyyy-MM-dd");
        }
    };

    public static void main(String[] args) {


        Map<String,String> map1 = new HashMap<>();
        for (int i = 0; i < 100; i++) {
            map1.put("" + Math.round(Math.random()*10000), ""+Math.random()*10000+1);
        }
        map1.put("1","1");
        map1.put("key",null);
        map1.put(null,"value");
        map1.put("2","2");
        map1.put("3","3");
        System.out.println(map1);


        Date date = new Date();
        DateFormat dateFormat = df.get();
        System.out.println(dateFormat.format(date));


        System.out.println((6-4)>>1);


        List<Integer> list = Collections.synchronizedList(new ArrayList<>());
        //必须对list进行加锁
        synchronized (list) {
            list.add(1);
            list.add(2);
            System.out.println(list);
        }

        CopyOnWriteArrayList<Integer> list1 = new CopyOnWriteArrayList<>(list);
        System.out.println(list1);
        list1.remove(1);
        System.out.println(list);
        System.out.println(list1);

        HashMap<Integer, Integer> map = new HashMap<>();
        Set<String> set = new HashSet<>();
        CopyOnWriteArraySet<String> stringCopyOnWriteArraySet = new CopyOnWriteArraySet<>(set);
        stringCopyOnWriteArraySet.add("hhh");
        System.out.println(stringCopyOnWriteArraySet);

        //这个地方要注意两个地方：
        //迭代操作必须加锁，可以使用synchronized关键字修饰;
        //synchronized持有的监视器对象必须是synchronized (list),即包装后的list,使用其他对象如synchronized (new Object())会使add,remove等方法与迭代方法使用的锁不一致，无法实现完全的线程安全性。
        //通过源码可知Collections.synchronizedList生成了特定同步的SynchronizedCollection，生成的集合每个同步操作都是持有mutex这个锁，所以再进行操作时就是线程安全的集合了。关键地方已经加了注释：
//        public static <T> List<T> synchronizedList(List<T> list) {
//            return (list instanceof RandomAccess ?
//                    //ArrayList使用了SynchronizedRandomAccessList类
//                    new SynchronizedRandomAccessList<>(list) :
//                    new SynchronizedList<>(list));
//        }
////SynchronizedRandomAccessList继承自SynchronizedList
//        static class SynchronizedRandomAccessList<E> extends SynchronizedList<E> implements RandomAccess {
//        }
//
////SynchronizedList对代码块进行了synchronized修饰来实现线程安全性
//        static class SynchronizedList<E> extends SynchronizedCollection<E> implements List<E> {
//            public E get(int index) {
//                synchronized (mutex) {return list.get(index);}
//            }
//            public E set(int index, E element) {
//                synchronized (mutex) {return list.set(index, element);}
//            }
//            public void add(int index, E element) {
//                synchronized (mutex) {list.add(index, element);}
//            }
//            public E remove(int index) {
//                synchronized (mutex) {return list.remove(index);}
//            }
//
//            //迭代操作并未加锁，所以需要手动同步
//            public ListIterator<E> listIterator() {
//                return list.listIterator();
//            }
//        }


//        System.out.println(Math.ceil(12.5));
//        System.out.println(Math.floor(12.5));
//        System.out.println(Math.rint(3.2));
//        //rint() 方法返回最接近参数的整数值。若存在两个这样的数，则返回其中的偶数值
//        System.out.println(Math.rint(101.5));//102
//        System.out.println(Math.rint(100.5));//100
//        System.out.println(Math.round(12.5));
//        System.out.println(Math.round(-12.5));

        HashMap<Integer, Integer> integerIntegerHashMap = new HashMap<>();
        integerIntegerHashMap.put(1, 1);
        integerIntegerHashMap.put(3, 3);
        integerIntegerHashMap.put(2, 2);
        integerIntegerHashMap.put(4, 4);
        System.out.println(integerIntegerHashMap);

        TreeSet<Integer> integers = new TreeSet<>();
        integers.add(2);
        integers.add(3);
        integers.add(1);
        integers.add(5);
        integers.add(4);
        System.out.println(integers);

        LinkedHashMap<Integer, Integer> integerIntegerLinkedHashMap = new LinkedHashMap<>();
        integerIntegerLinkedHashMap.put(1, 1);
        integerIntegerLinkedHashMap.put(3, 3);
        integerIntegerLinkedHashMap.put(2, 2);
        integerIntegerLinkedHashMap.put(4, 4);
        System.out.println(integerIntegerLinkedHashMap);
    }

//    ExecutorService pool = new ThreadPoolExecutor(2,3,60, TimeUnit.MINUTES,new ArrayBlockingQueue<Runnable>(5),Executors.defaultThreadFactory());


//    Executor executor = new Executor() {
//        @Override
//        public void execute(Runnable command) {
//
//        }
//    };
}
