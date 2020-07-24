package graph;

import java.util.Arrays;

/**
 * @author Wushiai
 * @date 2020/3/27 13:54
 * @content 给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。
 * <p>
 * 示例 1:
 * <p>
 * 输入: n = 12
 * 输出: 3
 * 解释: 12 = 4 + 4 + 4.
 * 示例 2:
 * <p>
 * 输入: n = 13
 * 输出: 2
 * 解释: 13 = 4 + 9.
 */
public class 完全平方数279 {

//    public int numSquares(int n) {
//
//        int[] mem = new int[n+1];
//        Arrays.fill(mem, -1);
//
//        return numSquares(n, mem);
//    }
//
//    private int numSquares(int n, int[] mem){
//
//        if(n == 0)
//            return 0;
//
//        int res = Integer.MAX_VALUE;
//        for(int i = 1; n - i * i >= 0; i ++ )
//            res = Math.min(res, 1 + numSquares(n - i * i, mem));
//        return mem[n] = res;
//    }

    public int numSquares(int n) {

        int[] mem = new int[n + 1];
        Arrays.fill(mem, Integer.MAX_VALUE);
        mem[0] = 0;
        for (int i = 1; i <= n; i++)
            for (int j = 1; i - j * j >= 0; j++)
                mem[i] = Math.min(mem[i], mem[i - j * j] + 1);

        return mem[n];
    }

    public static void main(String[] args) {
        System.out.println((new 完全平方数279()).numSquares(12));
    }


}
