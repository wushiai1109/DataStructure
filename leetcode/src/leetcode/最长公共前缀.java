package leetcode;

/**
 * @author Wushiai
 * @date 2019/8/14 10:38
 * 3
 */
public class 最长公共前缀 {
    /**
     * 编写一个函数来查找字符串数组中的最长公共前缀。
     * 如果不存在公共前缀，返回空字符串 ""。
     * 示例 1:
     * <p>
     * 输入: ["flower","flow","flight"]
     * 输出: "fl"
     * 示例 2:
     * <p>
     * 输入: ["dog","racecar","car"]
     * 输出: ""
     * 解释: 输入不存在公共前缀。
     * 说明:
     * <p>
     * 所有输入只包含小写字母 a-z 。
     */

    public static void main(String[] args) {
        String[] strs = {"aa", "a"};
//        String[] strs = {"flower","flow","flight"};
        System.out.println(longestCommonPrefix(strs));
    }

    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0)
            return "";
        if (strs.length == 1)
            return strs[0];
        char[] chars = strs[0].toCharArray();
        if (chars == null || chars.length == 0)
            return "";
        StringBuilder sb = new StringBuilder("");
        for (int i = 0; i < chars.length; i++) {
            for (int j = 1; j < strs.length; j++) {
                char[] chars1 = strs[j].toCharArray();
                if (i >= chars1.length || chars1[i] != chars[i])
                    return sb.toString();
            }
            sb.append(chars[i]);
        }
        return sb.toString();
    }
}
