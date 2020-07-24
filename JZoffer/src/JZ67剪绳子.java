/**
 * @ClassName 剪绳子
 * @Description 时间限制：C/C++ 1秒，其他语言2秒 空间限制：C/C++ 64M，其他语言128M 热度指数：116999
 * 本题知识点： 贪心
 * 题目描述
 * 给你一根长度为n的绳子，请把绳子剪成整数长的m段（m、n都是整数，n>1并且m>1），每段绳子的长度记为k[1],...,k[m]。
 * 请问k[1]x...xk[m]可能的最大乘积是多少？例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
 * 输入描述:
 * 输入一个数n，意义见题面。（2 <= n <= 60）
 * 输出描述:
 * 输出答案。
 * 示例1
 * 输入
 * 8
 * 输出
 * 18
 * 贪心
 * @Author Bruce
 * @Date 2020/6/22 1:25 下午
 */
public class JZ67剪绳子 {
    public int cutRope(int target) {
        // n<=3的情况，m>1必须要分段，例如：3必须分成1、2；1、1、1 ，n=3最大分段乘积是2
        if(target == 2) {
            return 1;
        }
        if (target == 3) {
            return 2;
        }
        //下面3行是n>=4的情况，跟n<=3不同，4可以分很多段，比如分成1、3，
        //这里的3可以不需要再分了，因为3分段最大才2，不分就是3。记录最大的。
        int[] dp = new int[target+1];
        dp[1] =1;
        dp[2] =2;
        dp[3] =3;
        int res = 0;
        for (int i = 4; i <= target; i++) {
            for (int j = 1; j <= i/2; j++) {
                res = Math.max(res,dp[j]*dp[i-j]);
            }
            dp[i] = res;
        }
        return dp[target];
    }
}
