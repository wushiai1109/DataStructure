package leetcode;

/**
 * @author Wushiai
 * @date 2019/8/13 16:12
 * 3
 */
public class 整数反转 {
    /**
     *给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
     *
     * 示例 1:
     * 输入: 123
     * 输出: 321
     *
     * 示例 2:
     * 输入: -123
     * 输出: -321
     *
     * 示例 3:
     * 输入: 120
     * 输出: 21
     *
     * 注意:
     * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231,  231 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
     */

    public static void main(String[] args) {
        System.out.println(reverse(-456));
    }

    public static int reverse(int x) {
        long temp=0;
        while(x!=0){
            temp*=10;
            temp+=x%10;
            x/=10;
        }
        if(temp<Integer.MIN_VALUE || temp>Integer.MAX_VALUE)
            return 0;
        return (int)temp;
    }

}
