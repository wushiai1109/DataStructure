package Stack;

import java.util.Stack;

/**
 * @author Wushiai
 * @date 2019/8/13 17:03
 * 3
 */
public class 有效的括号20 {
    /**
     * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
     * 有效字符串需满足：
     * 左括号必须用相同类型的右括号闭合。
     * 左括号必须以正确的顺序闭合。
     * 注意空字符串可被认为是有效字符串。
     * <p>
     * 示例 1:
     * <p>
     * 输入: "()"
     * 输出: true
     * 示例 2:
     * <p>
     * 输入: "()[]{}"
     * 输出: true
     * 示例 3:
     * <p>
     * 输入: "(]"
     * 输出: false
     * 示例 4:
     * <p>
     * 输入: "([)]"
     * 输出: false
     * 示例 5:
     * <p>
     * 输入: "{[]}"
     * 输出: true
     */

    public static void main(String[] args) {
        System.out.println(new 有效的括号20().isValid("{[]}"));
    }

//    public boolean isValid(String s) {
//        Stack<Character> stack = new Stack<>();
//        char[] chars = s.toCharArray();
//        for (char c : chars) {
//            if (stack.size() == 0) {
//                stack.push(c);
//            } else if (isSame(stack.peek(), c)) {
//                stack.pop();
//            } else {
//                stack.push(c);
//            }
//        }
//        return stack.size() == 0;
//    }
//
//    private static boolean isSame(char c1, char c2) {
//        return (c1 == '(' && c2 == ')') || (c1 == '[' && c2 == ']') || (c1 == '{' && c2 == '}');
//    }


    //时间复杂度O(n)
    //空间复杂度O(n)
    public boolean isValid(String s) {

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++)
            if (s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[')
                stack.push(s.charAt(i));
            else {
                if (stack.size() == 0)
                    return false;
                Character c = stack.pop();
                Character match;
                if (s.charAt(i) == ')')
                    match = '(';
                else if (s.charAt(i) == ']')
                    match = '[';
                else {
                    assert s.charAt(i) == '}';
                    match = '{';
                }

                if (c != match)
                    return false;
            }

        return stack.size() == 0;
    }

}
