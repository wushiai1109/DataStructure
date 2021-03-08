package leetcode.editor.cn;//数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
//
// 
//
// 示例 1： 
//
// 
//输入：n = 3
//输出：["((()))","(()())","(())()","()(())","()()()"]
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：["()"]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 8 
// 
// Related Topics 字符串 回溯算法 
// 👍 1596 👎 0


import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class 括号生成22 {
    public static List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        generate(res, "", 0, 0, n);
        return res;
    }

    public static void generate(List<String> res, String str, int left, int right, int n) {
        if (left > n || right > n) {
            return;
        }
        if (left == n && right == n) {
            res.add(str);
        }
        if (left >= right) {
            generate(res, str + "(", left + 1, right, n);
            generate(res, str + ")", left, right + 1, n);
        }
    }

    //方案2
    public static void generate2(List<String> res, String str, int left, int right, int n) {
        //terminator
        if (left == n && right == n) {
            res.add(str);
            return;
        }
        if (left < n) {
            generate2(res, str + "(", left + 1, right, n);
        }
        if (left > right) {
            generate2(res, str + ")", left, right + 1, n);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
