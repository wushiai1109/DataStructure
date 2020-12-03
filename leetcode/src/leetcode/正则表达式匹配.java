package leetcode;

/**
 * @author Wushiai
 * @date 2019/12/6 17:40
 * 1
 */
public class 正则表达式匹配 {
    /**
     * 给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。
     * <p>
     * '.' 匹配任意单个字符
     * '*' 匹配零个或多个前面的那一个元素
     * 所谓匹配，是要涵盖 整个 字符串 s的，而不是部分字符串。
     * <p>
     * 说明:
     * s 可能为空，且只包含从 a-z 的小写字母。
     * p 可能为空，且只包含从 a-z 的小写字母，以及字符 . 和 *。
     * 示例 1:
     * <p>
     * 输入:
     * s = "aa"
     * p = "a"
     * 输出: false
     * 解释: "a" 无法匹配 "aa" 整个字符串。
     * 示例 2:
     * <p>
     * 输入:
     * s = "aa"
     * p = "a*"
     * 输出: true
     * 解释: 因为 '*' 代表可以匹配零个或多个前面的那一个元素, 在这里前面的元素就是 'a'。因此，字符串 "aa" 可被视为 'a' 重复了一次。
     * 示例 3:
     * <p>
     * 输入:
     * s = "ab"
     * p = ".*"
     * 输出: true
     * 解释: ".*" 表示可匹配零个或多个（'*'）任意字符（'.'）。
     * 示例 4:
     * <p>
     * 输入:
     * s = "aab"
     * p = "c*a*b"
     * 输出: true
     * 解释: 因为 '*' 表示零个或多个，这里 'c' 为 0 个, 'a' 被重复一次。因此可以匹配字符串 "aab"。
     * 示例 5:
     * <p>
     * 输入:
     * s = "mississippi"
     * p = "mis*is*p*."
     * 输出: false
     *
     * @param p
     * @return
     */
    public boolean isMatch(String s, String p) {

        boolean[][] sp;
        int i, j, ss, pp;
        char c;
        ss = s.length();
        pp = p.length();
        sp = new boolean[pp + 1][ss + 1];
        //对空字符串的匹配
        sp[0][0] = true;

        //第一位不能是*，如果pp的当前元素是*，则到这个*的后一位（i+1）是否匹配与（i-1）的匹配信息一致
        for (i = 0; i < pp; i++) {
            if (p.charAt(i) == '*') {
                sp[i + 1][0] = sp[i - 1][0];
            }
        }

        for (i = 0; i < pp; i++) {
            c = p.charAt(i);
            for (j = 0; j < ss; j++) {
                if (c == '*') {
                    //匹配    0个前字符   1个前字符   多个前字符   (s当前字符和p中*前字符一样 或者  *前是.  )
                    sp[i + 1][j + 1] = sp[i - 1][j + 1] || sp[i][j + 1] || sp[i + 1][j] && (s.charAt(j) == p.charAt(i - 1) || p.charAt(i - 1) == '.');
                } else if (c == '.' || c == s.charAt(j)) {
                    sp[i + 1][j + 1] = sp[i][j];
                } else {
                    sp[i + 1][j + 1] = false;
                }
            }
        }
        return sp[pp][ss];
    }

    public static void main(String[] args) {
        System.out.println(new 正则表达式匹配().isMatch("aa", "a*"));
    }

}
