package leetcode;

/**
 * @author Wushiai
 * @date 2019/8/13 10:11
 * 2
 */
public class 最长回文子串 {

    /**
     * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
     *
     * 示例 1：
     * 输入: "babad"
     * 输出: "bab"
     * 注意: "aba" 也是一个有效答案。
     *
     * 示例 2：
     * 输入: "cbbd"
     * 输出: "bb"
     */

    public static void main(String[] args) {
        System.out.println(longestPalindrome("babad"));
    }

    public static String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        char[] str = s.toCharArray();
        int[] range = new int[2];
        for (int i = 0; i < s.length(); i++) {
            //把回文看成中间的部分全是同一字符，左右部分相对称
            //找到下一个与当前字符不同的字符
            i = findLongest(str, i, range);
        }
        //public String substring(int beginIndex, int endIndex)
        //beginIndex -- 起始索引（包括）, 索引从 0 开始
        //endIndex -- 结束索引（不包括)
        return s.substring(range[0], range[1] + 1);
    }

    public static int findLongest(char[] str, int low, int[] range) {
        //查找中间部分
        int high = low;
        while (high < (str.length - 1) && str[high + 1] == str[low]) {
            high++;
        }
        //定位中间部分的最后一个字符
        int ans = high;
        //从中间向左右扩散
        while (low > 0 && high < str.length - 1 && str[low - 1] == str[high + 1]) {
            low--;
            high++;
        }
        //录最大长度
        if (high - low > range[1] - range[0]) {
            range[0] = low;
            range[1] = high;
        }
        return ans;
    }

}