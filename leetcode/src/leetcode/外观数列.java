package leetcode;

/**
 * @author Wushiai
 * @date 2020/1/20 11:07
 * @content 「leetcode.外观数列」是一个整数序列，从数字 1 开始，序列中的每一项都是对前一项的描述。前五项如下：
 *
 * 1.     1
 * 2.     11
 * 3.     21
 * 4.     1211
 * 5.     111221
 * 1 被读作  "one 1"  ("一个一") , 即 11。
 * 11 被读作 "two 1s" ("两个一"）, 即 21。
 * 21 被读作 "one 2",  "one 1" （"一个二" ,  "一个一") , 即 1211。
 *
 * 给定一个正整数 n（1 ≤ n ≤ 30），输出外观数列的第 n 项。
 *
 * 注意：整数序列中的每一项将表示为一个字符串。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: 1
 * 输出: "1"
 * 解释：这是一个基本样例。
 * 示例 2:
 *
 * 输入: 4
 * 输出: "1211"
 * 解释：当 n = 3 时，序列是 "21"，其中我们有 "2" 和 "1" 两组，"2" 可以读作 "12"，也就是出现频次 = 1 而 值 = 2；类似 "1" 可以读作 "11"。所以答案是 "12" 和 "11" 组合在一起，也就是 "1211"。
 */
public class 外观数列 {

    public static void main(String[] args) {
        System.out.println(new 外观数列().countAndSay(6));
    }

    public String countAndSay(int n) {
        if (n == 1)
            return "1";
        StringBuilder sb = new StringBuilder();
        sb.append("1");
        for (int i = 2; i <= n; i++) {
            String str = new String(sb);
            sb.delete(0, sb.length());
            int num = 0;
            char currentChar = str.charAt(0);
            for (char c : str.toCharArray()) {
                if (c == currentChar) {
                    num++;
                } else {
                    sb.append((char) ('0' + num));
                    sb.append(currentChar);
                    currentChar = c;
                    num = 1;
                }
            }
            sb.append((char) ('0' + num));
            sb.append(currentChar);
        }
        return sb.toString();
    }
}
