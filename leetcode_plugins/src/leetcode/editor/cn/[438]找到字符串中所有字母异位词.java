package leetcode.editor.cn;//给定一个字符串 s 和一个非空字符串 p，找到 s 中所有是 p 的字母异位词的子串，返回这些子串的起始索引。
//
// 字符串只包含小写英文字母，并且字符串 s 和 p 的长度都不超过 20100。 
//
// 说明： 
//
// 
// 字母异位词指字母相同，但排列不同的字符串。 
// 不考虑答案输出的顺序。 
// 
//
// 示例 1: 
//
// 
//输入:
//s: "cbaebabacd" p: "abc"
//
//输出:
//[0, 6]
//
//解释:
//起始索引等于 0 的子串是 "cba", 它是 "abc" 的字母异位词。
//起始索引等于 6 的子串是 "bac", 它是 "abc" 的字母异位词。
// 
//
// 示例 2: 
//
// 
//输入:
//s: "abab" p: "ab"
//
//输出:
//[0, 1, 2]
//
//解释:
//起始索引等于 0 的子串是 "ab", 它是 "ab" 的字母异位词。
//起始索引等于 1 的子串是 "ba", 它是 "ab" 的字母异位词。
//起始索引等于 2 的子串是 "ab", 它是 "ab" 的字母异位词。
// 
// Related Topics 哈希表 
// 👍 403 👎 0


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//leetcode submit region begin(Prohibit modification and deletion)
class 找到字符串中所有字母异位词438 {
    public List<Integer> findAnagrams(String s, String p) {

        List<Integer> res = new ArrayList<>();

        if (s.length() < p.length()) {
            return res;
        }

        //记录p的每个字符和出现的次数，记录在freq_p中
        Map<Character, Integer> freq_p = new HashMap<>();
        for (char c : p.toCharArray()) {
            freq_p.put(c, freq_p.getOrDefault(c, 0) + 1);
        }

        //记录s的每个字符和出现的次数，记录在freq_s中
        Map<Character, Integer> freq_s = new HashMap<>();

        //先使得滑动窗口s[l...r]里面元素为0，所以我们初始化r=-1
        int l = 0, r = -1;

        while (r + 1 < s.length()) {
            r++;
            //记录现在freq_s中的字符
            freq_s.put(s.charAt(r), freq_s.getOrDefault(s.charAt(r), 0) + 1);
            //如果现在freq_s中的字符数量多于p的长度，去除掉l位置的字符
            if (r - l + 1 > p.length()) {
                freq_s.put(s.charAt(l), freq_s.get(s.charAt(l)) - 1);
                l++;
            }
            //先判断此时的freq_s的数量是否等于p的长度，再判断freq_s是否为freq_p的异位词
            if (r - l + 1 == p.length() && isSame(freq_s, freq_p)) {
                res.add(l);
            }
        }
        return res;
    }

    private boolean isSame(Map<Character, Integer> freq_s, Map<Character, Integer> freq_p) {
        for (Character ch : freq_p.keySet()) {
            if (freq_s.get(ch) == null || (int) freq_s.get(ch) != freq_p.get(ch)) {
                return false;
            }
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
