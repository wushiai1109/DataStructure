package PriorityQueue;

import java.util.*;

/**
 * @author Wushiai
 * @date 2020/2/7 18:38
 * @content 给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [1,1,1,2,2,3], k = 2
 * 输出: [1,2]
 * 示例 2:
 * <p>
 * 输入: nums = [1], k = 1
 * 输出: [1]
 * 说明：
 * <p>
 * 你可以假设给定的 k 总是合理的，且 1 ≤ k ≤ 数组中不相同的元素的个数。
 * 你的算法的时间复杂度必须优于 O(n log n) , n 是数组的大小。
 */
public class 前K个高频元素347 {

    //普通的队列是一种先进先出的数据结构，元素在队列尾追加，而从队列头删除。在优先队列中，元素被赋予优先级。当访问元素时，具有最高优先级的元素最先删除。
    // 优先队列具有最高级先出 （first in, largest out）的行为特征。通常采用堆数据结构来实现。
    public List<Integer> topKFrequent(int[] nums, int k) {

        //TreeMap的基本操作 containsKey、get、put 和 remove 的时间复杂度是 log(n)
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int num : nums) {
            map.put(num,map.getOrDefault(num,0)+1);
        }

//        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
//            @Override
//            public int compare(Integer a, Integer b) {
//                return map.get(a) - map.get(b);
//            }
//        });

        PriorityQueue<Integer> pq = new PriorityQueue<>(
                (a, b) -> {
                    return map.get(a) - map.get(b);
                }
        );

        for (int key : map.keySet()) {
            if (pq.size() < k) {
                pq.add(key);
            } else if (map.get(key) > map.get(pq.peek())) {
                pq.remove();
                pq.add(key);
            }
        }

        ArrayList<Integer> res = new ArrayList<>();
        while (!pq.isEmpty()) {
            res.add(pq.remove());
        }
        return res;
    }

    private static void printList(List<Integer> nums) {
        for (Integer num : nums) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {

        int[] nums = {1, 1, 1, 2, 2, 3};
        int k = 2;
        printList((new 前K个高频元素347()).topKFrequent(nums, k));
        System.out.println(Arrays.toString(nums));
    }


    /*
     /// Sorting
/// Time Complexity: O(nlogn)
/// Space Complexity: O(n)
    public List<Integer> topKFrequent(int[] nums, int k) {

        if(k <= 0)
            throw new IllegalArgumentException("k should be greater than 0");

        HashMap<Integer, Integer> freq = new HashMap<Integer, Integer>();
        for(int i = 0 ; i < nums.length ; i ++)
            if(freq.containsKey(nums[i]))
                freq.put(nums[i], freq.get(nums[i]) + 1);
            else
                freq.put(nums[i], 1);

        if(k > freq.size())
            throw new IllegalArgumentException("k should be less than the number of unique numbers in nums");

        ArrayList<Integer> res = new ArrayList<Integer>();
        for(Integer key: freq.keySet())
            res.add(key);

        Collections.sort(res, (a, b) -> {
            if(freq.get(a) != freq.get(b))
                return freq.get(b) - freq.get(a);
            return a - b;
        });

        return res.subList(0, k);
    }

    private static void printList(List<Integer> nums){
        for(Integer num: nums)
            System.out.print(num + " ");
        System.out.println();
    }

    public static void main(String[] args) {

        int[] nums = {1, 1, 1, 2, 2, 3};
        int k = 2;
        printList((new Solution3()).topKFrequent(nums, k));
    }
    */


}
