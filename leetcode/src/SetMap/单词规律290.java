package SetMap;

import java.util.HashMap;

/**
 * @author Wushiai
 * @date 2020/3/5 14:48
 * @content 给定一种规律 pattern 和一个字符串 str ，判断 str 是否遵循相同的规律。
 * <p>
 * 这里的 遵循 指完全匹配，例如， pattern 里的每个字母和字符串 str 中的每个非空单词之间存在着双向连接的对应规律。
 * <p>
 * 示例1:
 * <p>
 * 输入: pattern = "abba", str = "dog cat cat dog"
 * 输出: true
 * 示例 2:
 * <p>
 * 输入:pattern = "abba", str = "dog cat cat fish"
 * 输出: false
 * 示例 3:
 * <p>
 * 输入: pattern = "aaaa", str = "dog cat cat dog"
 * 输出: false
 * 示例 4:
 * <p>
 * 输入: pattern = "abba", str = "dog dog dog dog"
 * 输出: false
 * 说明:
 * 你可以假设 pattern 只包含小写字母， str 包含了由单个空格分隔的小写字母。    
 */
public class 单词规律290 {
    public static void main(String[] args) {
        String pattern = "abba", str = "dog dog dog dog";
        System.out.println(new 单词规律290().wordPattern(pattern, str));
    }

    //java+hashMap 这道题说的是对应关系，那首先想到的集合就是Map，将key（a）-value（dog）存在一起，每当遇到一个字母就去查看对应的单词。
    // 失败有两种情况： 1.key存在，经过查找字母对应的单词和这个单词不匹配； 2.key不存在，但是这个单词已经被存了；
    public boolean wordPattern(String pattern, String str) {

        if (pattern == null || str == null)
            return false;

        String[] string = str.split(" ");

        if (pattern.length() != string.length)
            return false;
        HashMap<Character, String> map = new HashMap<>();

        for (int i = 0; i < pattern.length(); i++) {
            char temp = pattern.charAt(i);
            //key已经在
            if (map.containsKey(temp)) {
                //不对应就失败
                if (!map.get(temp).equals(string[i]))
                    return false;
            }
            //key不存在
            else {
                //两个value的值一样 a-dog b-dog->false
                if (map.containsValue(string[i])) return false;
                else
                    //添加k-v值
                    map.put(temp, string[i]);
            }
        }
        return true;
    }
}
