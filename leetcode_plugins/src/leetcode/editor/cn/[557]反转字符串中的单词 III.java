package leetcode.editor.cn;//给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
//
// 
//
// 示例： 
//
// 输入："Let's take LeetCode contest"
//输出："s'teL ekat edoCteeL tsetnoc"
// 
//
// 
//
// 提示： 
//
// 
// 在字符串中，每个单词由单个空格分隔，并且字符串中不会有任何额外的空格。 
// 
// Related Topics 字符串 
// 👍 251 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class 反转字符串中的单词III557 {

    public String reverseWords(String s) {
        String[] strs = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (String str : strs) {
            sb.append(new StringBuilder(str).reverse().toString());
            sb.append(" ");
        }
        return sb.toString().trim();
    }

    //如果有多个空格在两边和单词中间
//    public String reverseWords(String s) {
//        int n = s.length();
//        int start = 0, end = 0;
//
//        while (start < n) {
//            //循环至单词的开始
//            while (start < n && s.charAt(start) == ' ') {
//                start++;
//            }
//            end = start;
//            //循环至单词的末尾
//            while (end < n && s.charAt(end) != ' ') {
//                end++;
//            }
//            // 翻转单词
//            s = reverse(s, start, end - 1);
//            // 更新start，去找下一个单词
//            start = end + 1;
//            end++;
//        }
//        return s;
//    }
//
//    private String reverse(String s, int start, int end) {
//        StringBuilder sb = new StringBuilder(s);
//        while (start < end) {
//            char temp = sb.charAt(start);
//            sb.setCharAt(start++, sb.charAt(end));
//            sb.setCharAt(end--, temp);
//        }
//        return sb.toString();
//    }
}
//leetcode submit region end(Prohibit modification and deletion)
