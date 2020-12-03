package leetcode.editor.cn;//给定一个整数数组 prices ，它的第 i 个元素 prices[i] 是一支给定的股票在第 i 天的价格。
//
// 设计一个算法来计算你所能获取的最大利润。你最多可以完成 k 笔交易。 
//
// 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。 
//
// 
//
// 示例 1： 
//
// 
//输入：k = 2, prices = [2,4,1]
//输出：2
//解释：在第 1 天 (股票价格 = 2) 的时候买入，在第 2 天 (股票价格 = 4) 的时候卖出，这笔交易所能获得利润 = 4-2 = 2 。 
//
// 示例 2： 
//
// 
//输入：k = 2, prices = [3,2,6,5,0,3]
//输出：7
//解释：在第 2 天 (股票价格 = 2) 的时候买入，在第 3 天 (股票价格 = 6) 的时候卖出, 这笔交易所能获得利润 = 6-2 = 4 。
//     随后，在第 5 天 (股票价格 = 0) 的时候买入，在第 6 天 (股票价格 = 3) 的时候卖出, 这笔交易所能获得利润 = 3-0 = 3 
//。 
//
// 
//
// 提示： 
//
// 
// 0 <= k <= 109 
// 0 <= prices.length <= 1000 
// 0 <= prices[i] <= 1000 
// 
// Related Topics 动态规划 
// 👍 325 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class 买卖股票的最佳时机four188 {
    public static void main(String[] args) {
        int[] arr = {5, 7, 2, 7, 3, 3, 5, 3, 0};
        System.out.println(new 买卖股票的最佳时机four188().maxProfit(4, arr));
    }

    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        if (n <= 1) {
            return 0;
        }
        if (k > n / 2) {
            k = n / 2;
        }
        int[][][] dp = new int[n][k + 1][2];
        dp[0][0][1] = -prices[0];

        for (int K = 1; K < k; K++) {
            for (int j = 1; j <= 1; j++) {
                dp[0][K][j] = -prices[0];
            }
        }
        int res = 0;
        for (int i = 1; i < n; i++) {
            for (int K = 0; K <= k; K++) {
                if (K == 0) {
                    dp[i][0][0] = dp[i - 1][0][0];
                } else {
                    dp[i][K][0] = Math.max(dp[i - 1][K][0], dp[i - 1][K - 1][1] + prices[i]);
                    res = Math.max(res, dp[i][K][0]);
                }
                dp[i][K][1] = Math.max(dp[i - 1][K][1], dp[i - 1][K][0] - prices[i]);
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
