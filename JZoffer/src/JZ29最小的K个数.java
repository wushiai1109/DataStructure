import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @ClassName JZ29最小的K个数
 * @Description 数组 高级算法
 * 题目描述
 * 输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4。
 * @Author Bruce
 * @Date 2020/7/27 7:19 下午
 */
public class JZ29最小的K个数 {

    public static void main(String[] args) {
        int [] input = {4,5,1,6,2,7,3,8};
        System.out.println(new JZ29最小的K个数().GetLeastNumbers_Solution(input,4));
    }

    public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        ArrayList<Integer> res = new ArrayList<>();
        int length = input.length;
        if(k > length || k == 0){
            return res;
        }
        //由大到小
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });
//        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(k, (o1, o2) -> o2.compareTo(o1));
        for (int value : input) {
            if (maxHeap.size() != k) {
                maxHeap.offer(value);
            } else if (maxHeap.peek() > value) {
                maxHeap.poll();
                maxHeap.offer(value);
            }
        }
        res.addAll(maxHeap);
        return res;
    }
}