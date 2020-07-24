package SetMap;

import java.util.TreeSet;

/**
 * @author Wushiai
 * @date 2020/3/9 17:25
 * @content 给定一个整数数组，判断数组中是否有两个不同的索引 i 和 j，使得 nums [i] 和 nums [j] 的差的绝对值最大为 t，并且 i 和 j 之间的差的绝对值最大为 ķ。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [1,2,3,1], k = 3, t = 0
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: nums = [1,0,1,1], k = 1, t = 2
 * 输出: true
 * 示例 3:
 * <p>
 * 输入: nums = [1,5,9,1,5,9], k = 2, t = 3
 * 输出: false
 */
public class 存在重复元素III_滑动窗口220 {
    public static void main(String[] args) {
//        int[] nums = {1, 2, 3, 1};
//        int k = 3;
//        int t = 0;
//        int[] nums = {2, 1};
//        int k = 1;
//        int t = 1;
        int[] nums = {0, 2147483647};
        int k = 1;
        int t = 2147483647;
        System.out.println(new 存在重复元素III_滑动窗口220().containsNearbyAlmostDuplicate(nums, k, t));
    }

    //时间复杂度O(nlogn)
    //空间复杂度O(k)
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (t < 0)
            return false;

        TreeSet<Long> record = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            //ceiling(E e) 方法返回在这个集合中大于或者等于给定元素的最小元素，如果不存在这样的元素,返回null
            //查找表中是否有大于等于 nums[i] - t 且小于等于 nums[i] + t 的值
            if (record.ceiling((long)nums[i] - (long)t) != null && record.ceiling((long)nums[i] - (long)t) <= (long)nums[i] + (long)t)
                return true;

            record.add((long) nums[i]);

            //我们确保数据不超过k+1，使得两数的差的绝对值不超过 k
            if (record.size() == k + 1)
                record.remove((long) nums[i - k]);
        }

        return false;
    }
}
