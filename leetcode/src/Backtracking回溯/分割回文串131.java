package Backtracking回溯;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Wushiai
 * @date 2020/4/9 20:25
 * @content 给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。
 * <p>
 * 返回 s 所有可能的分割方案。
 * <p>
 * 示例:
 * <p>
 * 输入: "aab"
 * 输出:
 * [
 * ["aa","b"],
 * ["a","a","b"]
 * ]
 */
public class 分割回文串131 {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();

        dfs(s, 0, new ArrayList<String>(), res);
        return res;
    }

    private void dfs(String s, int start, ArrayList<String> path, List<List<String>> res) {
        if (start == s.length()) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = start; i < s.length(); i++) {
            String s1 = s.substring(start, i + 1);
            if (!isPalindrome(s1))
                continue;

            path.add(s1);
            dfs(s, i + 1, path, res);
            path.remove(path.size() - 1);
        }
    }

    private boolean isPalindrome(String s) {
        if (s == null || s.length() <= 1)
            return true;

        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right))
                return false;
            left++;
            right--;
        }
        return true;
    }
}
