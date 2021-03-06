package leetcode.editor.cn;//给你一个整数数组 nums ，请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。
//
// 
//
// 示例 1: 
//
// 输入: [2,3,-2,4]
//输出: 6
//解释: 子数组 [2,3] 有最大乘积 6。
// 
//
// 示例 2: 
//
// 输入: [-2,0,-1]
//输出: 0
//解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。 
// Related Topics 数组 动态规划 
// 👍 837 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class 乘积最大子数组152 {
//    public int maxProduct(int[] nums) {
//        //令imax为当前最大值,因为存在负数，那么会导致最大的变最小的，最小的变最大的。因此还需要维护当前最小值imin
//        //负数出现时则imax与imin进行交换再进行下一步计算
//        //时间复杂度：O(n)
//        int max = Integer.MIN_VALUE, imax = 1, imin = 1;
//
//        for (int num : nums) {
//            if (num < 0) {
//                int tmp = imax;
//                imax = imin;
//                imin = tmp;
//            }
//            imax = Math.max(imax * num, num);
//            imin = Math.min(imin * num, num);
//
//            max = Math.max(max, imax);
//        }
//
//        return max;
//    }

    public int maxProduct(int[] nums) {
        int res = nums[0];
        int[] dp = nums.clone();
        int min = nums[0];

        for (int i = 1; i < nums.length; ++i) {
            dp[i] = Math.max(dp[i - 1] * nums[i], Math.max(min * nums[i], nums[i]));
            if (res < dp[i]) {
                res = dp[i];
            }
            min = Math.min(min * nums[i], Math.min(dp[i - 1] * nums[i], nums[i]));
        }

        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
