package leetcode;

/**
 * @author Wushiai
 * @date 2019/8/12 21:26
 * 2
 */
public class 字符串转换整数 {
    /**
     * 请你来实现一个 atoi 函数，使其能将字符串转换成整数。
     * 首先，该函数会根据需要丢弃无用的开头空格字符，直到寻找到第一个非空格的字符为止。
     * 当我们寻找到的第一个非空字符为正或者负号时，则将该符号与之后面尽可能多的连续数字组合起来，作为该整数的正负号；假如第一个非空字符是数字，则直接将其与之后连续的数字字符组合起来，形成整数。
     * 该字符串除了有效的整数部分之后也可能会存在多余的字符，这些字符可以被忽略，它们对于函数不应该造成影响。
     * 注意：假如该字符串中的第一个非空格字符不是一个有效整数字符、字符串为空或字符串仅包含空白字符时，则你的函数不需要进行转换。
     * 在任何情况下，若函数不能进行有效的转换时，请返回 0。
     * 说明：
     * 假设我们的环境只能存储 32 位大小的有符号整数，那么其数值范围为 [−231,  231 − 1]。如果数值超过这个范围，qing返回  INT_MAX (231 − 1) 或 INT_MIN (−231) 。
     *
     * 示例 1:
     * 输入: "42"
     * 输出: 42
     *
     * 示例 2:
     * 输入: "   -42"
     * 输出: -42
     * 解释: 第一个非空白字符为 '-', 它是一个负号。
     *      我们尽可能将负号与后面所有连续出现的数字组合起来，最后得到 -42 。
     *
     * 示例 3:
     * 输入: "4193 with words"
     * 输出: 4193
     * 解释: 转换截止于数字 '3' ，因为它的下一个字符不为数字。
     *
     * 示例 4:
     * 输入: "words and 987"
     * 输出: 0
     * 解释: 第一个非空字符是 'w', 但它不是数字或正、负号。
     *      因此无法执行有效的转换。
     *
     * 示例 5:
     * 输入: "-91283472332"
     * 输出: -2147483648
     * 解释: 数字 "-91283472332" 超过 32 位有符号整数范围。
     *      因此返回 INT_MIN (−231) 。
     */

    public static void main(String[] args) {
//        System.out.println(myAtoi("-91283472332"));
        System.out.println(myAtoi("2147483648"));
    }

    private static int myAtoi(String str) {
        //trim()方法实际上并不是"去掉两端的空白字符"，而是"截取中间的非空白字符"
        if (str.equals("") || str.trim().equals(""))
            return 0;
        char[] chars = str.trim().toCharArray();
        if((chars[0] != '-') && (chars[0] != '+') && (chars[0] < '0' || chars[0] > '9'))
            return 0;
        boolean isPos = true;
        int res = 0;
        int res_1 = 0;
        int i = 0;
        if(chars[0] == '+')
            i = 1;
        else if(chars[0] == '-'){
            isPos = false;
            i = 1;
        }else if(chars[0] == '0')
            i = 1;
        while (i < chars.length) {
            if(chars[i] >= '0' && chars[i] <= '9')
                res_1 = chars[i] - '0';
            else
                return isPos ? res : -res;
            if (res > (Integer.MAX_VALUE-res_1)/10) {
                return isPos ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            res = res * 10 + res_1;
            i++;
        }
        return isPos ? res : -res;
    }

}
