package leetcode.editor.cn;//给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。
//
// 设计一个算法来计算你所能获取的最大利润。你最多可以完成 两笔 交易。 
//
// 注意: 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。 
//
// 示例 1: 
//
// 输入: [3,3,5,0,0,3,1,4]
//输出: 6
//解释: 在第 4 天（股票价格 = 0）的时候买入，在第 6 天（股票价格 = 3）的时候卖出，这笔交易所能获得利润 = 3-0 = 3 。
//     随后，在第 7 天（股票价格 = 1）的时候买入，在第 8 天 （股票价格 = 4）的时候卖出，这笔交易所能获得利润 = 4-1 = 3 。 
//
// 示例 2: 
//
// 输入: [1,2,3,4,5]
//输出: 4
//解释: 在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。   
//     注意你不能在第 1 天和第 2 天接连购买股票，之后再将它们卖出。   
//     因为这样属于同时参与了多笔交易，你必须在再次购买前出售掉之前的股票。
// 
//
// 示例 3: 
//
// 输入: [7,6,4,3,1] 
//输出: 0 
//解释: 在这个情况下, 没有交易完成, 所以最大利润为 0。 
// Related Topics 数组 动态规划 
// 👍 553 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class 买卖股票的最佳时机three123 {
//    public int maxProfit(int[] prices) {
    //1.DP DP[i]表示到i天的max profit --- dp[i] = dp[i-1] + (-a[i]买股票) + (a[i]卖股票) --- 状态不过，需要改进
    //2.增加一维dp[i][j] i：0~n-1 j:0(未持股票),1(持有股票)
    //dp[i,0] = Math.max(dp[i-1,0],dp[i-1,1]+a[i]);
    //dp[i,1] = Math.max(dp[i-1,0]-a[i],dp[i-1,1]);
    //3.再增加一维dp[i][j][k],k表示之前交易了多少次 k:0~2次
    //dp[i][k][j]
    //for(int i = 0->n-1){for(int k = 0->k)}
    //dp[i,k,0] = Math.max(dp[i-1,k,0],  dp[i-1,k-1,1] + a[i]);
    //dp[i,k,1] = Math.max(dp[i-1,k,1],  dp[i-1,k-1,0] - a[i]);
    //max:dp[n-1][0...k][0]

    //leetcode309cool down可以将k令为0和1表示是否可以购买

    //如果可以购买多次股票
    //j的范围就是0->x
    //算法就是for(int i = 0->n-1){for(int k = 0->k){for(int j = 0->x)}}
    //dp[i,k,j] = Math.max(dp[i-1,k,j],  dp[i-1,k-1,j+1] + a[i], dp[i-1,k-1,j-1] - a[i]);

    //以k次交易为例，时间复杂度O(nkx) 空间复杂度O()


//        return 0;
//
//    }

    public static void main(String[] args) {
        int[] arr = {3, 3, 5, 0, 0, 3, 1, 4};
        System.out.println(new 买卖股票的最佳时机three123().maxProfit(arr));
    }


    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n <= 1) {
            return 0;
        }
        int[][][] dp = new int[n][3][2];
        dp[0][0][1] = -prices[0];
        dp[0][1][1] = -prices[0];
        for (int i = 1; i < n; i++) {
            for (int k = 0; k <= 2; k++) {
                if (k == 0) {
                    dp[i][0][0] = dp[i - 1][0][0];
                } else {
                    dp[i][k][0] = Math.max(dp[i - 1][k][0], dp[i - 1][k - 1][1] + prices[i]);
                }
                dp[i][k][1] = Math.max(dp[i - 1][k][1], dp[i - 1][k][0] - prices[i]);
            }
        }
        return Math.max(dp[n - 1][0][0], Math.max(dp[n - 1][1][0], dp[n - 1][2][0]));
    }

    // //k取值范围比较小，所以可以不用for循环，直接把k的情况全部列举出来也可以
    // public int maxProfit(int[] prices) {
    //     int n = prices.length;
    //     if (n <= 1) {
    //         return 0;
    //     }

    //     int[][][] dp = new int[n][3][2];
    //     dp[0][0][1] = -prices[0];
    //     dp[0][1][0] = -prices[0];
    //     dp[0][1][1] = -prices[0];
    //     dp[0][2][0] = -prices[0];

    //     for (int i = 1; i < n; i++) {
    //         dp[i][0][0] = dp[i - 1][0][0];
    //         dp[i][0][1] = Math.max(dp[i - 1][0][1], dp[i - 1][0][0] - prices[i]);
    //         dp[i][1][0] = Math.max(dp[i - 1][1][0], dp[i - 1][0][1] + prices[i]);
    //         dp[i][1][1] = Math.max(dp[i - 1][1][1], dp[i - 1][1][0] - prices[i]);
    //         dp[i][2][0] = Math.max(dp[i - 1][2][0], dp[i - 1][1][1] + prices[i]);
    //     }
    //     return Math.max(dp[n - 1][0][0], Math.max(dp[n - 1][1][0], dp[n - 1][2][0]));
    // }

}
//leetcode submit region end(Prohibit modification and deletion)
