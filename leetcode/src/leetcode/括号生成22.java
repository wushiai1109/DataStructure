package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Wushiai
 * @date 2019/8/13 16:16
 * 2
 */
public class 括号生成22 {
    /**
     * 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
     * <p>
     * 例如，给出 n = 3，生成结果为：
     * [
     * "((()))",
     * "(()())",
     * "(())()",
     * "()(())",
     * "()()()"
     * ]
     */

    public static void main(String[] args) {
        System.out.println(generateParenthesis(3));
    }

    public static List<String> generateParenthesis(int n) {
        List<String> brackets = new ArrayList<String>();
        generate(brackets, "", 0, 0, n);
        return brackets;
    }

    public static void generate(List<String> brackets, String str, int left, int right, int n) {
        if (left > n || right > n) {
            return;
        }
        if (left == n && right == n) {
            brackets.add(str);
        }
        if (left >= right) {
            generate(brackets, str + "(", left + 1, right, n);
            generate(brackets, str + ")", left, right + 1, n);
        }
    }

}