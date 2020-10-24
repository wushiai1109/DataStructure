package leetcode.editor.cn;
//给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回
// -1。 
//
// 
//
// 示例 1: 
//
// 输入: coins = [1, 2, 5], amount = 11
//输出: 3 
//解释: 11 = 5 + 5 + 1 
//
// 示例 2: 
//
// 输入: coins = [2], amount = 3
//输出: -1 
//
// 
//
// 说明: 
//你可以认为每种硬币的数量是无限的。 
// Related Topics 动态规划 
// 👍 827 👎 0


import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class 零钱兑换322 {
    //时间复杂度：O(Sn)，其中S是金额，n是面额数。我们一共需要计算O(S)个状态，S为题目所给的总金额。对于每个状态，每次需要枚举n个面额来转移状态，所以一共需要O(Sn)的时间复杂度。
    //空间复杂度：O(S)。DP 数组需要开长度为总金额S的空间。
    public int coinChange(int[] coins, int amount) {
        int max = amount + 1;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, max);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
