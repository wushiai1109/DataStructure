package leetcode.editor.cn;//给定一个字符串 s 和一个字符串 t ，计算在 s 的子序列中 t 出现的个数。
//
// 字符串的一个 子序列 是指，通过删除一些（也可以不删除）字符且不干扰剩余字符相对位置所组成的新字符串。（例如，"ACE" 是 "ABCDE" 的一个子序列
//，而 "AEC" 不是） 
//
// 题目数据保证答案符合 32 位带符号整数范围。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "rabbbit", t = "rabbit"
//输出：3
//解释：
//如下图所示, 有 3 种可以从 s 中得到 "rabbit" 的方案。
//(上箭头符号 ^ 表示选取的字母)
//rabbbit
//^^^^ ^^
//rabbbit
//^^ ^^^^
//rabbbit
//^^^ ^^^
// 
//
// 示例 2： 
//
// 
//输入：s = "babgbag", t = "bag"
//输出：5
//解释：
//如下图所示, 有 5 种可以从 s 中得到 "bag" 的方案。 
//(上箭头符号 ^ 表示选取的字母)
//babgbag
//^^ ^
//babgbag
//^^    ^
//babgbag
//^    ^^
//babgbag
//  ^  ^^
//babgbag
//    ^^^ 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length, t.length <= 1000 
// s 和 t 由英文字母组成 
// 
// Related Topics 字符串 动态规划 
// 👍 277 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class 不同的子序列115 {
    //dp[i][j]代表T前i字符串可以由S前j字符串组成最多个数
    //所以动态方程：
    //当S[j] == T[j], dp[i][j] = dp[i-1][j-1]+ dp[i][j-1]
    //当S[j] != T[i], dp[i][j] = dp[i][j-1]

    public int numDistinct(String s, String t) {
        int tt = t.length();
        int ss = s.length();
        int[][] dp = new int[tt+1][ss+1];
        //只要前者t为空，后者s最多有一个，也就是全部去除为空
        for (int i = 0; i <= ss; i++) {
            dp[0][i] = 1;
        }

        for (int i = 0; i < tt; i++) {
            for (int j = i; j < ss; j++) {
                if (t.charAt(i) == s.charAt(j)) {
                    dp[i + 1][j + 1] = dp[i][j] + dp[i+1][j];
                }else {
                    dp[i + 1][j + 1] = dp[i+1][j];
                }
            }
        }
        return dp[tt][ss];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
