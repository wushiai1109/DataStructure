package leetcode.editor.cn;//给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。
//
// 相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。 
//
// 
//
// 例如，给定三角形： 
//
// [
//     [2],
//    [3,4],
//   [6,5,7],
//  [4,1,8,3]
//]
// 
//
// 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。 
//
// 
//
// 说明： 
//
// 如果你可以只使用 O(n) 的额外空间（n 为三角形的总行数）来解决这个问题，那么你的算法会很加分。 
// Related Topics 数组 动态规划 
// 👍 644 👎 0


import java.util.List;

class 三角形最小路径和120 {
//    //O(n*n/2) space
//    public int minimumTotal(List<List<Integer>> triangle) {
//        if (triangle == null || triangle.size() == 0) {
//            return 0;
//        }
//        // 加1可以不用初始化最后一层
//        int[][] dp = new int[triangle.size() + 1][triangle.size() + 1];
//
//        for (int i = triangle.size() - 1; i >= 0; i--) {
//            List<Integer> curList = triangle.get(i);
//            for (int j = 0; j < curList.size(); j++) {
//                dp[i][j] = curList.get(j) + Math.min(dp[i + 1][j], dp[i + 1][j + 1]);
//            }
//        }
//        return dp[0][0];
//    }

//    O(n) space
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0) {
            return 0;
        }

        int[] dp = new int[triangle.size() + 1];
        for (int i = triangle.size() - 1; i >= 0; i--) {
            List<Integer> curList = triangle.get(i);
            for (int j = 0; j < curList.size(); j++) {
                dp[j] = curList.get(j) + Math.min(dp[j], dp[j + 1]);
            }
        }
        return dp[0];
    }

}
//leetcode submit region begin(Prohibit modification and deletion)
//leetcode submit region end(Prohibit modification and deletion)
