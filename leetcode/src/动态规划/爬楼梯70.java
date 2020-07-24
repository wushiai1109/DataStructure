package 动态规划;

import java.util.Arrays;

/**
 * @author Wushiai
 * @date 2020/4/23 13:19
 * @content 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * <p>
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * <p>
 * 注意：给定 n 是一个正整数。
 * <p>
 * 示例 1：
 * <p>
 * 输入： 2
 * 输出： 2
 * 解释： 有两种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶
 * 2.  2 阶
 * 示例 2：
 * <p>
 * 输入： 3
 * 输出： 3
 * 解释： 有三种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶 + 1 阶
 * 2.  1 阶 + 2 阶
 * 3.  2 阶 + 1 阶
 */
public class 爬楼梯70 {

    private int[] memo;

//    //时间复杂度O(n)
//    //空间复杂度O(n)
//    public int climbStairs(int n) {
//
//        if (n <= 0)
//            throw new IllegalArgumentException("n must be greater than zero");
//
//        memo = new int[n + 1];
//        Arrays.fill(memo, -1);
//        return calcWays(n);
//    }
//
//    private int calcWays(int n) {
//
//        if (n == 0 || n == 1)
//            return 1;
//
//        if (memo[n] == -1)
//            memo[n] = calcWays(n - 1) + calcWays(n - 2);
//
//        return memo[n];
//    }

    public static void main(String[] args) {
        System.out.println(new 爬楼梯70().climbStairs(3));
    }

    //时间复杂度O(n)
    //空间复杂度O(n)
    public int climbStairs(int n) {

        if(n <= 0)
            throw new IllegalArgumentException("n must be greater than zero");

        int[] memo = new int[n + 1];
        memo[0] = 1;
        memo[1] = 1;
        for(int i = 2 ; i <= n ; i ++)
            memo[i] = memo[i - 1] + memo[i - 2];
        return memo[n];
    }

}
