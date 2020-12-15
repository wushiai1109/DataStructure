import java.util.HashMap;

/**
 * @ClassName JZ34第一个只出现一次的字符
 * @Description 字符串
 * 题目描述
 * 在一个字符串(0<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,并返回它的位置, 如果没有则返回 -1（需要区分大小写）.（从0开始计数）
 * @Author Bruce
 * @Date 2020/7/23 7:05 下午
 */
public class JZ34第一个只出现一次的字符 {

    public int FirstNotRepeatingChar(String str) {

        HashMap<Character, Integer> map = new HashMap<>();
        HashMap<Character, Integer> countMap = new HashMap<>();
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            map.put(chars[i], i);
            countMap.put(chars[i], countMap.getOrDefault(chars[i], 0) + 1);
        }
        for (int i = 0; i < chars.length; i++) {
            if (countMap.get(chars[i]) == 1) {
                return map.get(chars[i]);
            }
        }

        return -1;
    }
}
