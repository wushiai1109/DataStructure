package Array;

/**
 * @author Wushiai
 * @date 2019/8/13 17:14
 */
public class 无重复字符的最长子串3__滑动窗口 {
    /**
     * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
     * <p>
     * 示例 1:
     * <p>
     * 输入: "abcabcbb"
     * 输出: 3
     * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
     * 示例 2:
     * <p>
     * 输入: "bbbbb"
     * 输出: 1
     * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
     * 示例 3:
     * <p>
     * 输入: "pwwkew"
     * 输出: 3
     * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
     *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
     */

    public static void main(String[] args) {
        System.out.println(new 无重复字符的最长子串3__滑动窗口().lengthOfLongestSubstring("pwwkew"));
    }

//    public int lengthOfLongestSubstring(String s) {
//        int max = 0, k = 0;
//        for(int i=0; i<s.length(); i++){
//            char c = s.charAt(i);//charAt() 方法用于返回指定索引处的字符。索引范围为从 0 到 length() - 1
//            for(int j=k; j<i; j++)
//                if(s.charAt(j) == c){
//                    k = j+1;
//                    break;
//                }
//            if(i+1-k>max)
//                max = i+1-k;
//        }
//        return max;
//    }


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


//    public int lengthOfLongestSubstring(String s) {
//
//        int[] freq = new int[256];
//
//        int l = 0, r = -1; // sliding window: s[l...r]
//        int res = 0;
//
//        while (r + 1 < s.length()) {
//
//            while (r + 1 < s.length() && freq[s.charAt(r + 1)] == 0)
//                freq[s.charAt(++r)]++;
//
//            res = Math.max(res, r - l + 1);
//
//            if (r + 1 < s.length()) {
//                freq[s.charAt(++r)]++;
//                while (l <= r && freq[s.charAt(r)] == 2)
//                    freq[s.charAt(l++)]--;
//            }
//        }
//
//        return res;
//    }

//    public int lengthOfLongestSubstring(String s) {
//
//        int[] freq = new int[256];
//        //给freq数组的所有元素初始化为-1
//        Arrays.fill(freq, -1);
//
//        int l = 0, r = -1; // sliding window: s[l...r]
//        int res = 0;
//        while (r + 1 < s.length()) {
//
//            r++;
//            if (freq[s.charAt(r)] != -1)
//                l = Math.max(l, freq[s.charAt(r)] + 1);
//
//            res = Math.max(res, r - l + 1);
//            freq[s.charAt(r)] = r;
//        }
//
//        return res;
//    }
}
