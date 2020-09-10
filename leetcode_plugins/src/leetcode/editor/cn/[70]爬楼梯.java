package leetcode.editor.cn;//假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
//
// 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？ 
//
// 注意：给定 n 是一个正整数。 
//
// 示例 1： 
//
// 输入： 2
//输出： 2
//解释： 有两种方法可以爬到楼顶。
//1.  1 阶 + 1 阶
//2.  2 阶 
//
// 示例 2： 
//
// 输入： 3
//输出： 3
//解释： 有三种方法可以爬到楼顶。
//1.  1 阶 + 1 阶 + 1 阶
//2.  1 阶 + 2 阶
//3.  2 阶 + 1 阶
// 
// Related Topics 动态规划 
// 👍 1181 👎 0


import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class 爬楼梯 {

    private int[] memo;

    public static void main(String[] args) {
        System.out.println(new 爬楼梯().climbStairs(1));
        System.out.println(new 爬楼梯().climbStairs(2));
        System.out.println(new 爬楼梯().climbStairs(3));
    }

    //时间复杂度O(n)
    //空间复杂度O(n)
    public int climbStairs(int n) {

        if (n <= 0) {
            throw new IllegalArgumentException("It is an error number!");
        }

        memo = new int[n + 1];
        Arrays.fill(memo, -1);
        return climbStairsWay(n);
    }

    private int climbStairsWay(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }

        if (memo[n] == -1) {
            memo[n] = climbStairsWay(n - 1) + climbStairsWay(n - 2);
        }

        return memo[n];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
