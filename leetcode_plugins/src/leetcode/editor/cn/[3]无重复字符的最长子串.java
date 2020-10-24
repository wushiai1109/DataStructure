package leetcode.editor.cn;//给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
//
// 示例 1: 
//
// 输入: "abcabcbb"
//输出: 3 
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
// 
//
// 示例 2: 
//
// 输入: "bbbbb"
//输出: 1
//解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
// 
//
// 示例 3: 
//
// 输入: "pwwkew"
//输出: 3
//解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
// 
// Related Topics 哈希表 双指针 字符串 Sliding Window 
// 👍 4473 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class 无重复字符的最长子串3__滑动窗口 {
    // Sliding Window
// Time Complexity: O(len(s))
// Space Complexity: O(len(charset))
    public int lengthOfLongestSubstring(String s) {

        //使用ASCII码存储频率
        int[] freq = new int[256];

        //先使得滑动窗口s[l...r]里面元素为0，所以我们初始化r=-1
        int l = 0, r = -1;
        int res = 0;

        while (r + 1 < s.length()) {
            if (freq[s.charAt(r + 1)] == 0) {
                freq[s.charAt(++r)]++;
            } else {
                freq[s.charAt(l++)]--;
            }
            res = Math.max(res, r - l + 1);
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
