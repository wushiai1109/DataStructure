package leetcode.editor.cn;//给定一个非空字符串 s，最多删除一个字符。判断是否能成为回文字符串。
//
// 示例 1: 
//
// 
//输入: "aba"
//输出: True
// 
//
// 示例 2: 
//
// 
//输入: "abca"
//输出: True
//解释: 你可以删除c字符。
// 
//
// 注意: 
//
// 
// 字符串只包含从 a-z 的小写字母。字符串的最大长度是50000。 
// 
// Related Topics 字符串 
// 👍 282 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class 验证回文字符串two680 {
    public static void main(String[] args) {
        System.out.println(new 验证回文字符串two680().validPalindrome("aguokepatgbnvfqmgmlcupuufxoohdfpgjdmysgvhmvffcnqxjjxqncffvmhvgsymdjgpfdhooxfuupuculmgmqfvnbgtapekouga"));
    }

//    public boolean validPalindrome(String s) {
//        if (s.length() == 1 || s.length() == 2) {
//            return true;
//        }
//        //记录是否已经修改一次
//        boolean flag = true;
//        char[] chars = s.toCharArray();
//        int i = 0, j = chars.length - 1;
//        while (i < j) {
//            //判断是否为字符和数字
//            boolean flag1 = (chars[i] >= '0' && chars[i] <= '9') || (chars[i] >= 'a' && chars[i] <= 'z') || (chars[i] >= 'A' && chars[i] <= 'Z');
//            boolean flag2 = (chars[j] >= '0' && chars[j] <= '9') || (chars[j] >= 'a' && chars[j] <= 'z') || (chars[j] >= 'A' && chars[j] <= 'Z');
//            if (flag1 && flag2) {
//                if (String.valueOf(chars[i]).equalsIgnoreCase(String.valueOf(chars[j]))) {
//                    i++;
//                    j--;
//                } else {
//                    if (String.valueOf(chars[i + 1]).equalsIgnoreCase(String.valueOf(chars[j])) && flag) {
//                        i += 2;
//                        j--;
//                        flag = false;
//                    } else if (String.valueOf(chars[i]).equalsIgnoreCase(String.valueOf(chars[j - 1])) && flag) {
//                        i++;
//                        j -= 2;
//                        flag = false;
//                    } else {
//                        return false;
//                    }
//                }
//            } else if (!flag1) {
//                i++;
//            } else {
//                j--;
//            }
//        }
//        return true;
//    }
//
//    public boolean validPalindrome(String s, char i, char j, boolean flag) {
//
//    }


    public boolean validPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        // < 符号，中间一个字符不影响回文与否
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return validPalindromeHelper(s, left + 1, right) || validPalindromeHelper(s, left, right - 1);
            }
            left++;
            right--;
        }
        return true;
    }

    public boolean validPalindromeHelper(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
