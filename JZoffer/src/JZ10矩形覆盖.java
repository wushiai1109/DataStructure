/**
 * @ClassName JZ10矩形覆盖
 * @Description 本题知识点： 递归
 * 题目描述
 * 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
 * 比如n=3时，2*3的矩形块有3种覆盖方法
 * 示例1
 * 输入
 * 4
 * 返回值
 * 5
 * @Author Bruce
 * @Date 2021/2/12 下午10:53
 */
public class JZ10矩形覆盖 {
    public int rectCover(int target) {
        if (target == 0 || target == 1 || target == 2) {
            return target;
        }
        int[] dp = new int[target + 1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= target; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[target];
    }
}
