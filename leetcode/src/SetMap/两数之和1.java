package SetMap;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author Wushiai
 * @date 2019/8/13 17:19
 * 3
 */
public class 两数之和1 {
    /**
     * 给定一个整数数组nums和一个目标值target，请你在该数组中找出和为目标值的那两个整数，并返回他们的数组下标。
     * <p>
     * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
     * <p>
     * 示例:
     * <p>
     * 给定 nums = [2, 7, 11, 15], target = 9
     * <p>
     * 因为 nums[0] + nums[1] = 2 + 7 = 9
     * 所以返回 [0, 1]
     */

    public static void main(String[] args) {
        int nums[] = {2, 7, 11, 15};
        //Arrays.toString(twoSum(indexs))
        System.out.println(Arrays.toString(new 两数之和1().twoSum(nums, 9)));
    }

//    public int[] twoSum(int[] nums, int target) {
//        int[] indexs = new int[2];
//        //一一对应哈希表
//        HashMap<Integer, Integer> hash = new HashMap<>();
//        for (int i = 0; i < nums.length; i++) {
//            //containsKey() 方法来检测数据（value）是否存在
//            if (hash.containsKey(nums[i])) {
//                //get()方法，获取key，返回value
//                indexs[0] = hash.get(nums[i]);
//                indexs[1] = i;
//                return indexs;
//            }
//            //值为key ，value为下标
//            hash.put(target - nums[i], i);
//        }
//        return indexs;
//    }

    /// One-Pass Hash Table
/// Time Complexity: O(n)
/// Space Complexity: O(n)
    public int[] twoSum(int[] nums, int target) {

        HashMap<Integer, Integer> record = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {

            int complement = target - nums[i];
            if (record.containsKey(complement)) {
                return new int[]{i, record.get(complement)};
            }

            record.put(nums[i], i);
        }

        throw new IllegalStateException("the input has no solution");
    }

}
