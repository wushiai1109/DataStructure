import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @ClassName JZ63
 * @Description 如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。
 * 如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。我们使用Insert()方法读取数据流，使用GetMedian()方法获取当前读取数据的中位数。
 * 进制转化 排序 堆
 * @Author Bruce
 * @Date 2020/6/23 10:33 上午
 */
//Java的PriorityQueue 是从JDK1.5开始提供的新的数据结构接口，默认内部是自然排序，结果为小顶堆，也可以自定义排序器，比如下面反转比较，完成大顶堆。
//思路：
//为了保证插入新数据和取中位数的时间效率都高效，这里使用大顶堆+小顶堆的容器，并且满足：
//1、两个堆中的数据数目差不能超过1，这样可以使中位数只会出现在两个堆的交接处；
//2、大顶堆的所有数据都小于小顶堆，这样就满足了排序要求。
public class JZ63数据流中的中位数 {
    int count;
    PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
    //PriorityQueue默认是小顶堆，实现大顶堆，需要反转默认排序器
    PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2.compareTo(o1);
        }
    });

//    PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>((o1, o2) -> o2.compareTo(o1));


    public void Insert(Integer num) {
        count++;
        if ((count & 1) == 0) { // 判断偶数的高效写法
            if (!maxHeap.isEmpty() && num < maxHeap.peek()) {
                maxHeap.offer(num);
                num = maxHeap.poll();
            }
            minHeap.offer(num);
        } else {
            if (!minHeap.isEmpty() && num > minHeap.peek()) {
                minHeap.offer(num);
                num = minHeap.poll();
            }
            maxHeap.offer(num);
        }
    }

    public Double GetMedian() {
        if (count == 0)
            throw new RuntimeException("no available number!");
        double result;
        //总数为奇数时，大顶堆堆顶就是中位数
        if ((count & 1) == 1)
            result = maxHeap.peek();
        else
            result = (minHeap.peek() + maxHeap.peek()) / 2.0;
        return result;
    }
}
