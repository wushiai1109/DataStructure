package SetMap;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Wushiai
 * @date 2020/3/5 13:39
 * @content 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 * <p>
 * 示例 1:
 * <p>
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: s = "rat", t = "car"
 * 输出: false
 * 说明:
 * 你可以假设字符串只包含小写字母。
 * <p>
 * 进阶:
 * 如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
 */
public class 有效的字母异位词242 {
    public static void main(String[] args) {
        String s = "anagram", t = "nagaram";
        System.out.println(new 有效的字母异位词242().isAnagram(s, t));
    }

    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        for (char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        for (char ch : t.toCharArray()) {
            Integer count = map.get(ch);
            if (count == null) {
                return false;
            } else if (count > 1) {
                map.put(ch, count - 1);
            } else {
                map.remove(ch);
            }
        }
        return map.isEmpty();
    }

//    public boolean isAnagram(String s, String t) {
//        if ((s != null) && (t != null) && (s.length() == t.length())) {
//            final int len = 26;
//            int[] num1 = new int[len];
//            int[] num2 = new int[len];
//            for (int i = 0; i < t.length(); i++) {
//                num1[s.charAt(i) - 'a']++;
//                num2[t.charAt(i) - 'a']++;
//            }
//            for (int i = 0; i < len; i++) {
//                if (num1[i] != num2[i]) {
//                    return false;
//                }
//            }
//            return true;
//        }
//        return false;
//    }
}
