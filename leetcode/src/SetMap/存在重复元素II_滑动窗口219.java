package SetMap;

import java.util.HashSet;

/**
 * @author Wushiai
 * @date 2020/3/9 16:32
 * @content 给定一个整数数组和一个整数 k，判断数组中是否存在两个不同的索引 i 和 j，使得 nums [i] = nums [j]，并且 i 和 j 的差的绝对值最大为 k。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [1,2,3,1], k = 3
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: nums = [1,0,1,1], k = 1
 * 输出: true
 * 示例 3:
 * <p>
 * 输入: nums = [1,2,3,1,2,3], k = 2
 * 输出: false
 */
public class 存在重复元素II_滑动窗口219 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};
        int k = 3;
        System.out.println(new 存在重复元素II_滑动窗口219().containsNearbyDuplicate(nums, k));
    }

    // 使用HashSet
    // 时间复杂度: O(n)
    // 空间复杂度: O(k)
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (nums == null || nums.length <= 1)
            return false;

        if (k <= 0)
            return false;

        HashSet<Integer> record = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (record.contains(nums[i]))
                return true;

            record.add(nums[i]);
            //我们确保数据不超过k+1，使得两数的差的绝对值不超过 k
            if (record.size() == k + 1)
                record.remove(nums[i - k]);
        }

        return false;
    }


//    // 使用HashMap
//    // 时间复杂度: O(n)
//    // 空间复杂度: O(n)
//    public boolean containsNearbyDuplicate(int[] nums, int k) {
//
//        if (nums == null || nums.length <= 1)
//            return false;
//
//        if (k <= 0)
//            return false;
//
//        HashMap<Integer, Integer> record = new HashMap<>();
//        record.put(nums[0], 0);
//        for (int i = 1; i < nums.length; i++) {
//            if (record.containsKey(nums[i]) && i - record.get(nums[i]) <= k)
//                return true;
//            record.put(nums[i], i);
//        }
//
//        return false;
//    }

}