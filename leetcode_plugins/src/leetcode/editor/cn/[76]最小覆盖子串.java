package leetcode.editor.cn;//给你一个字符串 S、一个字符串 T 。请你设计一种算法，可以在 O(n) 的时间复杂度内，从字符串 S 里面找出：包含 T 所有字符的最小子串。
//
// 
//
// 示例： 
//
// 输入：S = "ADOBECODEBANC", T = "ABC"
//输出："BANC" 
//
// 
//
// 提示： 
//
// 
// 如果 S 中不存这样的子串，则返回空字符串 ""。 
// 如果 S 中存在这样的子串，我们保证它是唯一的答案。 
// 
// Related Topics 哈希表 双指针 字符串 Sliding Window 
// 👍 808 👎 0


import java.util.HashMap;
import java.util.Map;

//leetcode submit region begin(Prohibit modification and deletion)
class 最小覆盖子串76 {
    public String minWindow(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray())
            map.put(c, 0); //初始化s的字符，全部为key-0
        for (char c : t.toCharArray()) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1); //t中出现的字符数 key-int
            } else {
                return "";
            }
        }
        String result = "";
        //记录需要被匹配的次数
        int count = t.length();
        int right = 0;
        int left = 0;
        while (right < s.length()) {
            char c = s.charAt(right);
            //将字符进行匹配
            if (map.get(c) > 0) {
                count--;
            }
            map.put(c, map.get(c) - 1);
            right++;
            while (count == 0) {
                //替换最小结果
                if (result.length() == 0) {
                    result = s.substring(left, right);
                } else if (result.length() > (right - left)) {
                    result = s.substring(left, right);
                }
                //移动左指针
                char c1 = s.charAt(left);
                map.put(c1, map.get(c1) + 1);
                left++;
                if (map.get(c1) == 0) {
                    count++;
                }
            }
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
