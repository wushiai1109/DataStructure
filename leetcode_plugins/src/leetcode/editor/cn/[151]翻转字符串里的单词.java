package leetcode.editor.cn;//给定一个字符串，逐个翻转字符串中的每个单词。
//
// 说明： 
//
// 
// 无空格字符构成一个 单词 。 
// 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。 
// 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
// 
//
// 
//
// 示例 1： 
//
// 输入："the sky is blue"
//输出："blue is sky the"
// 
//
// 示例 2： 
//
// 输入："  hello world!  "
//输出："world! hello"
//解释：输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
// 
//
// 示例 3： 
//
// 输入："a good   example"
//输出："example good a"
//解释：如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
// 
//
// 示例 4： 
//
// 输入：s = "  Bob    Loves  Alice   "
//输出："Alice Loves Bob"
// 
//
// 示例 5： 
//
// 输入：s = "Alice does not even like bob"
//输出："bob like even not does Alice"
// 提示：
// 1 <= s.length <= 104 
// s 包含英文大小写字母、数字和空格 ' ' 
// s 中 至少存在一个 单词
//
// 进阶： 
//
// 
// 请尝试使用 O(1) 额外空间复杂度的原地解法。 
// 
// Related Topics 字符串 
// 👍 234 👎 0


import java.util.Arrays;
import java.util.Collections;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class 翻转字符串里的单词151 {
//    //在指定 String 数组B的每个元素之间串联指定的分隔符 A，从而产生单个串联的字符串
//    //string [] tmpStr={abc,def,ghi};
//    //string jn = string.Join(“-“, tmpStr);
//    //此时jn=”abc-def-ghi”;
//
//
//    //O(n) N为输入字符串的长度
//    //O(n)
//
//    public String reverseWords(String s) {
////        // 除去开头和末尾的空白字符
////        s = s.trim();
////        // 正则匹配连续的空白字符作为分隔符分割
////        List<String> wordList = Arrays.asList(s.split("\\s+"));
////        Collections.reverse(wordList);
////        return String.join(" ", wordList);
//
//        // 除去开头和末尾的空白字符
//        s = s.trim();
//        // 将字符串间多余的空白字符去除
//        int left = 0, right = s.length() - 1;
//        StringBuilder sb = new StringBuilder();
//        while (left <= right) {
//            char c = s.charAt(left);
//            if (c != ' ') {
//                sb.append(c);
//            } else if (sb.charAt(sb.length() - 1) != ' ') {
//                sb.append(c);
//            }
//            ++left;
//        }
//
////        List<String> wordList = Arrays.asList(sb.toString().split(" "));
////        Collections.reverse(wordList);
////        return String.join(" ", wordList);
//
//        // 翻转字符串
//        reverse(sb, 0, sb.length() - 1);
//        // 翻转每个单词
//        reverseEachWord(sb);
//        return sb.toString();
//    }
//
//    public void reverse(StringBuilder sb, int left, int right) {
//        while (left < right) {
//            char temp = sb.charAt(left);
//            sb.setCharAt(left++, sb.charAt(right));
//            sb.setCharAt(right--, temp);
//        }
//    }
//
//    public void reverseEachWord(StringBuilder sb) {
//        int n = sb.length();
//        int start = 0, end = 0;
//
//        while (start < n) {
//            // 循环至单词的末尾
//            while (end < n && sb.charAt(end) != ' ') {
//                ++end;
//            }
//            // 翻转单词
//            reverse(sb, start, end - 1);
//            // 更新start，去找下一个单词
//            start = end + 1;
//            ++end;
//        }
//    }

    //String.Join 方法 (A (String), B (String[]));
    //在指定 String 数组B的每个元素之间串联指定的分隔符 A，从而产生单个串联的字符串
    // public String reverseWords(String s) {
    //    String [] worlds = s.trim().split(" ");
    //     Collections.reverse(Arrays.asList(worlds));
    //     return String.join(" ", worlds);
    // }

    public String reverseWords(String s) {
        s = s.trim();
        StringBuilder ret = new StringBuilder();
        int l = s.length() - 1;
        while (l >= 0) {
            int word = l;
            while (l >= 0 && s.charAt(l) != ' ') {
                l--;
            }
//            for (int p = 0; p < word - l; p++) {
//                ret.append(s.charAt(l + p + 1));
//            }
            ret.append(s.substring(l+1,word+1));
            while (l >= 0 && s.charAt(l) == ' ') {
                l--;
            }
            s = s.trim();
            ret.append(" ");
        }
        return ret.toString().trim();
    }

}
//leetcode submit region end(Prohibit modification and deletion)
