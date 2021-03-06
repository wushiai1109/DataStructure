package leetcode.editor.cn;
//给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
//
// 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。 
//
// 
//
// 示例: 
//
// 给定 nums = [2, 7, 11, 15], target = 9
//
//因为 nums[0] + nums[1] = 2 + 7 = 9
//所以返回 [0, 1]
// 
// Related Topics 数组 哈希表 
// 👍 8835 👎 0


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//leetcode submit region begin(Prohibit modification and deletion)
class 两数之和 {
    public static void main(String[] args) {
        int[] arr = {2, 7, 11, 15};
        System.out.println(Arrays.toString(new 两数之和().twoSum(arr, 9)));
    }
//    public int[] twoSum(int[] nums, int target) {
//        int numsSize = nums.length;
//        for (int i = 0; i < numsSize - 1; i++) {
//            for (int j = i + 1; j < numsSize; j++) {
//                if (nums[i] + nums[j] == target) {
//                    return new int[]{i,j};
//                }
//            }
//        }
//        return new int[0];
//    }


    //用哈希表
    //a,b --> a+b == target --> for each a : check(target - a) exists in nums.

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }

}
//leetcode submit region end(Prohibit modification and deletion)
