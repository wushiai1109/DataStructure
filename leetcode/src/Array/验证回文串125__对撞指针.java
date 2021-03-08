package Array;

/**
 * @author Wushiai
 * @date 2020/2/27 11:04
 * @content 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 * <p>
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "A man, a plan, a canal: Panama"
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: "race a car"
 * 输出: false
 */
public class 验证回文串125__对撞指针 {

    public static void main(String[] args) {
//        String s1 = "A man, a plan, a canal: Panama";
//        System.out.println(new Array.验证回文串125__对撞指针().isPalindrome(s1));
//
//        String s2 = "race a car";
//        System.out.println(new Array.验证回文串125__对撞指针().isPalindrome(s2));
//
        String s3 = ",.";
        System.out.println(new 验证回文串125__对撞指针().isPalindrome(s3));
    }

//    public boolean isPalindrome(String s) {
//        if (s.length() == 1)
//            return true;
//        char[] chars = s.toCharArray();
//        int i = 0, j = chars.length - 1;
//        while (i < j) {
//            //判断是否为字符和数字
//            boolean flag1 = (chars[i] >= '0' && chars[i] <= '9') || (chars[i] >= 'a' && chars[i] <= 'z') || (chars[i] >= 'A' && chars[i] <= 'Z');
//            boolean flag2 = (chars[j] >= '0' && chars[j] <= '9') || (chars[j] >= 'a' && chars[j] <= 'z') || (chars[j] >= 'A' && chars[j] <= 'Z');
//            if (flag1 && flag2) {
//                char temp = chars[j];
//                chars[j] = chars[i];
//                chars[i] = temp;
//                i++;
//                j--;
//            } else if (!flag1)
//                i++;
//            else
//                j--;
//        }
//        return s.equalsIgnoreCase(String.valueOf(chars));
//    }

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

}