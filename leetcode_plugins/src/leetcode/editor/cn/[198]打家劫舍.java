package leetcode.editor.cn;//你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上
//被小偷闯入，系统会自动报警。 
//
// 给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。 
//
// 
//
// 示例 1： 
//
// 输入：[1,2,3,1]
//输出：4
//解释：偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
//     偷窃到的最高金额 = 1 + 3 = 4 。 
//
// 示例 2： 
//
// 输入：[2,7,9,3,1]
//输出：12
//解释：偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
//     偷窃到的最高金额 = 2 + 9 + 1 = 12 。
// 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 100 
// 0 <= nums[i] <= 400 
// 
// Related Topics 动态规划 
// 👍 1165 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class 打家劫舍198 {

    //a[i]:0...i 能偷到max value : a[n-1]

    //a[i][0,1] : 0:偷 1:不偷
    //a[i][0] = Math.max(a[i-1][0],a[i-1][1])
    //a[i][1] = a[i-1][0] + nums[i]

    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        int[][] a = new int[n][2];

        a[0][0] = 0;
        a[0][1] = nums[0];

        for (int i = 1; i < n; i++) {
            a[i][0] = Math.max(a[i - 1][0], a[i - 1][1]);
            a[i][1] = a[i - 1][0] + nums[i];
        }
        return Math.max(a[n - 1][0], a[n - 1][1]);
    }

//    public int rob(int[] nums) {
//        if (nums == null || nums.length == 0) {
//            return 0;
//        }
//        int n = nums.length;
//        if (n == 1) {
//            return nums[0];
//        }
//
//        int[] dp = new int[n];
//        dp[0] = nums[0];
//        dp[1] = Math.max(nums[0], nums[1]);
//        for (int i = 2; i < n; i++) {
//            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
//        }
//        return dp[n - 1];
//    }

//    //Time Complexity O(n)
//    //Space Complexity O(1)
//    public int rob(int[] nums) {
//        if (nums == null || nums.length == 0) {
//            return 0;
//        }
//        int n = nums.length;
//        if (n == 1) {
//            return nums[0];
//        }
//
//        int first = nums[0], second = Math.max(nums[0], nums[1]);
//        for (int i = 2; i < n; i++) {
//            int temp = second;
//            second = Math.max(first + nums[i], second);
//            first = temp;
//        }
//        return second;
//    }
}
//leetcode submit region end(Prohibit modification and deletion)
