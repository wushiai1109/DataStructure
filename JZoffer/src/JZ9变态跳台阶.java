/**
 * @ClassName JZ9变态跳台阶
 * @Description 本题知识点： 贪心
 * 题目描述
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
 * 示例1
 * 输入
 * 3
 * 返回值
 * 4
 * @Author Bruce
 * @Date 2021/2/12 下午10:59
 */
public class JZ9变态跳台阶 {
    //因为n级台阶，第一步有n种跳法：跳1级、跳2级、到跳n级
    //跳1级，剩下n-1级，则剩下跳法是f(n-1)
    //跳2级，剩下n-2级，则剩下跳法是f(n-2)
    //所以f(n)=f(n-1)+f(n-2)+...+f(1)
    //因为f(n-1)=f(n-2)+f(n-3)+...+f(1)
    //所以f(n)=2*f(n-1)
    public int jumpFloorII(int target) {
//        if (target == 1) {
//            return target;
//        }
//        int[] dp = new int[target + 1];
//        int sum = 1;
//        for (int i = 2; i <= target; i++) {
//            dp[i] = sum + 1;
//            sum += dp[i];
//        }
//        return dp[target];

        if (target == 1) {
            return target;
        }
        int[] dp = new int[target + 1];
        dp[1] = 1;
        for (int i = 2; i <= target; i++) {
            dp[i] = 2 * dp[i - 1];
        }
        return dp[target];
    }
}
