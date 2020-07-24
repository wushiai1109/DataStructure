package leetcode;

/**
 * @author Wushiai
 * @date 2019/8/13 16:09
 * 3
 */
public class 回文数 {
    /**
     * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
     * <p>
     * 示例 1:
     * 输入: 121
     * 输出: true
     * <p>
     * 示例 2:
     * 输入: -121
     * 输出: false
     * 解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
     * <p>
     * 示例 3:
     * 输入: 10
     * 输出: false
     * 解释: 从右向左读, 为 01 。因此它不是一个回文数。
     */
    public static void main(String[] args) {
        System.out.println(isPalindrome(12321));
    }

    public static boolean isPalindrome(int x) {
        if (x < 0)
            return false;
        int y = 0, z = 0, m = x;
        while (m != 0) {
            z = m % 10;
            y = y * 10 + z;
            m = m / 10;
        }
        return y == x;
    }

}
