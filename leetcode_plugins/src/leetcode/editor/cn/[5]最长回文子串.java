package leetcode.editor.cn;//给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
//
// 示例 1： 
//
// 输入: "babad"
//输出: "bab"
//注意: "aba" 也是一个有效答案。
// 
//
// 示例 2： 
//
// 输入: "cbbd"
//输出: "bb"
// 
// Related Topics 字符串 动态规划 
// 👍 2883 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class 最长回文子串5 {
    public static void main(String[] args) {
        System.out.println(new 最长回文子串5().longestPalindrome("babad"));
    }

//    public String longestPalindrome(String s) {
//        int n = s.length();
//        String res = "";
//        boolean[][] dp = new boolean[n][n];
//        for (int i = n - 1; i >= 0; i--) {
//            for (int j = i; j < n; j++) {
////                j-i<2表明 j和i是相等的或者j=i+1，说明子串长度为0或者长度为1，就一定是回文串
//                dp[i][j] = s.charAt(i) == s.charAt(j) && (j - i < 2 || dp[i + 1][j - 1]);
//                if (dp[i][j] && j - i + 1 > res.length()) {
//                    res = s.substring(i, j + 1);
//                }
//            }
//        }
//        return res;
//    }


    private int left = 0, right = 0;

    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        for (int i = 0; i < s.length(); i++) {
            //设定每位数都作为中间点向两端扩展，相同点过滤
            i = findLongest(s, i);
        }
        //substring(int beginIndex, int endIndex)左闭右开
        return s.substring(left, right + 1);
    }

    public int findLongest(String s, int low) {
        //查找中间部分
        int high = low;
        //查找相同的字符，相同的字符一定是回文子串
        while ((high + 1) < s.length() && s.charAt(high + 1) == s.charAt(low)) {
            high++;
        }
        //定位已经确定的回文串的最后一个字符
        int res = high;
        //从中间向左右扩散
        while (low > 0 && high < s.length() - 1 && s.charAt(low - 1) == s.charAt(high + 1)) {
            low--;
            high++;
        }
        //录最大长度
        if (high - low > right - left) {
            left = low;
            right = high;
        }
        return res;
    }

//    public String longestPalindrome(String s) {
//        if (s == null || s.length() < 1) {
//            return "";
//        }
//        int left = 0, right = 0;
//        int len=0;
//        int start=0,end=0;
//        for (int i = 0; i < s.length(); i++) {
//            left=i;
//            right=i;
//            while (left > 0 && right +1< s.length()&&s.charAt(left) == s.charAt(right+1)){
//                right++;
//            }
//            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
//                left--;
//                right++;
//            }
//            if(right-left>len){
//                len=right-left;
//                start=left;
//                end=right;
//            }
//        }
//        return s.substring(start+1, end);
//    }

}
//leetcode submit region end(Prohibit modification and deletion)
