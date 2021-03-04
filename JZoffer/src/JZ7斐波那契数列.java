/**
 * @ClassName JZ7斐波那契数列
 * @Description 本题知识点： 数组
 * 题目描述
 * 大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0，第1项是1）。
 * n≤39
 * 示例1
 * 输入
 * 4
 * 返回值
 * 3
 * @Author Bruce
 * @Date 2021/2/12 下午11:13
 */
public class JZ7斐波那契数列 {
    public static void main(String[] args) {
        System.out.println(new JZ7斐波那契数列().Fibonacci(50));
    }

    public int Fibonacci(int n) {
        int[] dp = new int[n + 2];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
