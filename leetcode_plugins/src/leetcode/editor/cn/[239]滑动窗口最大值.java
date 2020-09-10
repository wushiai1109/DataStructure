package leetcode.editor.cn;
//给定一个数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
//
//
// 返回滑动窗口中的最大值。 
//
// 
//
// 进阶： 
//
// 你能在线性时间复杂度内解决此题吗？ 
//
// 
//
// 示例: 
//
// 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
//输出: [3,3,5,5,6,7] 
//解释: 
//
//  滑动窗口的位置                最大值
//---------------               -----
//[1  3  -1] -3  5  3  6  7       3
// 1 [3  -1  -3] 5  3  6  7       3
// 1  3 [-1  -3  5] 3  6  7       5
// 1  3  -1 [-3  5  3] 6  7       5
// 1  3  -1  -3 [5  3  6] 7       6
// 1  3  -1  -3  5 [3  6  7]      7 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10^5 
// -10^4 <= nums[i] <= 10^4 
// 1 <= k <= nums.length 
// 
// Related Topics 堆 Sliding Window 
// 👍 512 👎 0


import java.time.Instant;
import java.util.ArrayDeque;
import java.util.Date;

//leetcode submit region begin(Prohibit modification and deletion)
class 滑动窗口最大值 {
    //方法一：暴力法
    //最简单直接的方法是遍历每个滑动窗口，找到每个窗口的最大值。一共有 N - k + 1 个滑动窗口，每个有 k 个元素，
    // 于是算法的时间复杂度为O(Nk)，表现较差。
    //    public int[] maxSlidingWindow(int[] nums, int k) {
    //        int n = nums.length;
    //        if (n * k == 0) return new int[0];
    //
    //        int [] output = new int[n - k + 1];
    //        for (int i = 0; i < n - k + 1; i++) {
    //            int max = Integer.MIN_VALUE;
    //            for(int j = i; j < i + k; j++)
    //                max = Math.max(max, nums[j]);
    //            output[i] = max;
    //        }
    //        return output;
    //    }
    //复杂度分析
    //时间复杂度：{O}(N k)O(Nk)。其中 N 为数组中元素个数。
    //空间复杂度：{O}(N - k + 1)O(N−k+1)，用于输出数组。
//    public int[] maxSlidingWindow(int[] nums, int k) {
//        int n = nums.length;
//        if (n * k == 0) {
//            return new int[0];
//        }
//
//        int[] output = new int[n - k + 1];
//        for (int i = 0; i <= n - k; i++) {
//            int max = Integer.MIN_VALUE;
//            for (int j = i; j < i + k; j++) {
//                max = Math.max(max, nums[j]);
//            }
//            output[i] = max;
//        }
//        return output;
//    }


    //方法二：双向队列
    //如何优化时间复杂度呢？首先想到的是使用堆，因为在最大堆中 heap[0] 永远是最大的元素。
    // 在大小为 k 的堆中插入一个元素消耗log(k) 时间，因此算法的时间复杂度为O(Nlog(k))。
    //能否得到只要O(N) 的算法？
    //我们可以使用双向队列，该数据结构可以从两端以常数时间压入/弹出元素。
    //存储双向队列的索引比存储元素更方便，因为两者都能在数组解析中使用。
    //算法
    //算法非常直截了当：
    //处理前 k 个元素，初始化双向队列。
    //遍历整个数组。在每一步 :
    //清理双向队列 :
    //  - 只保留当前滑动窗口中有的元素的索引。
    //  - 移除比当前元素小的所有元素，它们不可能是最大的。
    //将当前元素添加到双向队列中。
    //将 deque[0] 添加到输出中。
    //返回输出数组。

    ArrayDeque<Integer> deq = new ArrayDeque<Integer>();
    int[] nums;

    //清理双向队列
    public void clean_deque(int i, int k) {
        //只保留当前滑动窗口中有的元素的索引
        if (!deq.isEmpty() && deq.getFirst() == i - k) {
            deq.removeFirst();
        }

        //移除比当前元素小的所有元素，它们不可能是最大的。
        while (!deq.isEmpty() && nums[i] > nums[deq.getLast()]) {
            deq.removeLast();
        }
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        if (n * k == 0) {
            return new int[0];
        }
        if (k == 1) {
            return nums;
        }

        //将当前元素添加到双向队列中
        this.nums = nums;
        int max_idx = 0;
        for (int i = 0; i < k; i++) {
            clean_deque(i, k);
            deq.addLast(i);
            //找到当前最大值的下标
            if (nums[i] > nums[max_idx]) {
                max_idx = i;
            }
        }

        int[] output = new int[n - k + 1];
        //将第一个滑动窗口中最大值赋值给output[0]
        output[0] = nums[max_idx];


        for (int i = k; i < n; i++) {
            clean_deque(i, k);
            deq.addLast(i);
            output[i - k + 1] = nums[deq.getFirst()];
        }
        return output;
    }

}
//leetcode submit region end(Prohibit modification and deletion)
