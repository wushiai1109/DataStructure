package Array;

/**
 * @author Wushiai
 * @date 2020/2/27 15:16
 * @contentn 编写一个函数，以字符串作为输入，反转该字符串中的元音字母。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "hello"
 * 输出: "holle"
 * 示例 2:
 * <p>
 * 输入: "leetcode"
 * 输出: "leotcede"
 * 说明:
 * 元音字母不包含字母"y"
 */
public class 反转字符串中的元音字母345 {
    public static void main(String[] args) {
        String s1 = "hello";
        String s2 = "leetcode";
        System.out.println(new 反转字符串中的元音字母345().reverseVowels(s1));
        System.out.println(new 反转字符串中的元音字母345().reverseVowels(s2));
    }

    //时间复杂度O(n)
    //空间复杂度O(1)
    public String reverseVowels(String s) {
        char[] chars = s.toCharArray();
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            char temp;
            Boolean flag1 = (chars[i] == 'a' || chars[i] == 'e' || chars[i] == 'i' || chars[i] == 'o' || chars[i] == 'u' ||
                    chars[i] == 'A' || chars[i] == 'E' || chars[i] == 'I' || chars[i] == 'O' || chars[i] == 'U');
            Boolean flag2 = (chars[j] == 'a' || chars[j] == 'e' || chars[j] == 'i' || chars[j] == 'o' || chars[j] == 'u' ||
                    chars[j] == 'A' || chars[j] == 'E' || chars[j] == 'I' || chars[j] == 'O' || chars[j] == 'U');
//            boolean flag = "a".equalsIgnoreCase(String.valueOf(chars[i])) || "e".equalsIgnoreCase(String.valueOf(chars[i])) || "i".equalsIgnoreCase(String.valueOf(chars[i]))
//                    || "o".equalsIgnoreCase(String.valueOf(chars[i])) || "u".equalsIgnoreCase(String.valueOf(chars[i]));
            if (flag1 && flag2) {
                temp = chars[i];
                chars[i] = chars[j];
                chars[j] = temp;
                i++;
                j--;
            } else if (!flag1) {
                i++;
            } else {
                j--;
            }
        }
        return String.valueOf(chars);
    }
}
