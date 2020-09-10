package leetcode.editor.cn;
//给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
//
// 说明：本题中，我们将空字符串定义为有效的回文串。 
//
// 示例 1: 
//
// 输入: "A man, a plan, a canal: Panama"
//输出: true
// 
//
// 示例 2: 
//
// 输入: "race a car"
//输出: false
// 
// Related Topics 双指针 字符串 
// 👍 259 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class 验证回文串 {

    public static void main(String[] args) {
        System.out.println(new 验证回文串().isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(new 验证回文串().isPalindrome("race a car"));
    }

    public boolean isPalindrome(String s) {
        if (s.length() == 1) {
            return true;
        }
        char[] chars = s.toCharArray();
        int i = 0, j = chars.length - 1;
        while (i < j) {
            //判断是否为字符和数字
            boolean flag1 = (chars[i] >= '0' && chars[i] <= '9') || (chars[i] >= 'a' && chars[i] <= 'z') || (chars[i] >= 'A' && chars[i] <= 'Z');
            boolean flag2 = (chars[j] >= '0' && chars[j] <= '9') || (chars[j] >= 'a' && chars[j] <= 'z') || (chars[j] >= 'A' && chars[j] <= 'Z');
            if (flag1 && flag2) {
                if (String.valueOf(chars[i]).equalsIgnoreCase(String.valueOf(chars[j]))) {
                    i++;
                    j--;
                } else {
                    return false;
                }
            } else if (!flag1) {
                i++;
            } else {
                j--;
            }
        }
        return true;
    }

//    public boolean isPalindrome(String s) {
//
//        String filteredS = filterNonNumberAndChar(s);
//        System.out.println(filteredS);
//
//        String reversedS = reverseString(filteredS);
//        System.out.println(reversedS);
//
//        return reversedS.equalsIgnoreCase(filteredS);
//
//    }
//
//    private String reverseString(String filteredS) {
//        return new StringBuilder(filteredS).reverse().toString();
//    }
//
//    private String filterNonNumberAndChar(String s) {
//        return s.replaceAll("[^A-Za-z0-9]","");
//    }
}
//leetcode submit region end(Prohibit modification and deletion)
