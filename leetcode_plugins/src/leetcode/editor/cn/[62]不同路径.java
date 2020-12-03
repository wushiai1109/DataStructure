package leetcode.editor.cn;
//一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
//
// 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。 
//
// 问总共有多少条不同的路径？ 
//
// 
//
// 例如，上图是一个7 x 3 的网格。有多少可能的路径？ 
//
// 
//
// 示例 1: 
//
// 输入: m = 3, n = 2
//输出: 3
//解释:
//从左上角开始，总共有 3 条路径可以到达右下角。
//1. 向右 -> 向右 -> 向下
//2. 向右 -> 向下 -> 向右
//3. 向下 -> 向右 -> 向右
// 
//
// 示例 2: 
//
// 输入: m = 7, n = 3
//输出: 28 
//
// 
//
// 提示： 
//
// 
// 1 <= m, n <= 100 
// 题目数据保证答案小于等于 2 * 10 ^ 9 
// 
// Related Topics 数组 动态规划 
// 👍 688 👎 0


import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class 不同路径62 {

    public static void main(String[] args) {
        System.out.println(Math.log(2147483647) / Math.log(2));
        System.out.println(Math.log1p(8));
        System.out.println(Integer.MAX_VALUE);
        System.out.println(test(23, 12));
        System.out.println(new 不同路径62().uniquePaths(7, 3));
        System.out.println(new 不同路径62().uniquePaths(23, 12));
    }

    public static int test(int m, int n) {
        long a1 = 1, a2 = 1;
        for (int i = 1; i < m; i++) {
            //18……10
            a1 = a1 * (m + n - i - 1);
            //9……1
            a2 = a2 * (m - i);
        }
        return (int) (a1 / a2);
    }

    //时间复杂度：O(mn)
    //空间复杂度：O(n)
    //dp[i]表示在当前位置的条数

    public int uniquePaths(int m, int n) {
        int[] dp = new int[n];

        //第一行、第一列
        Arrays.fill(dp, 1);

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[j] += dp[j - 1];
            }
        }
        return dp[n - 1];
    }

    // public int uniquePaths(int m, int n) {
    //     int[][] dp = new int[m][n];
    //     for (int i = 0; i < n; i++) dp[0][i] = 1;
    //     for (int i = 0; i < m; i++) dp[i][0] = 1;
    //     for (int i = 1; i < m; i++) {
    //         for (int j = 1; j < n; j++) {
    //             dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
    //         }
    //     }
    //     return dp[m - 1][n - 1];
    // }

}
//leetcode submit region end(Prohibit modification and deletion)
