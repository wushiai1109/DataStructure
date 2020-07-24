package SetMap;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Wushiai
 * @date 2020/3/5 15:33
 * @content 给定一个字符串，请将字符串里的字符按照出现的频率降序排列。
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * "tree"
 * <p>
 * 输出:
 * "eert"
 * <p>
 * 解释:
 * 'e'出现两次，'r'和't'都只出现一次。
 * 因此'e'必须出现在'r'和't'之前。此外，"eetr"也是一个有效的答案。
 * 示例 2:
 * <p>
 * 输入:
 * "cccaaa"
 * <p>
 * 输出:
 * "cccaaa"
 * <p>
 * 解释:
 * 'c'和'a'都出现三次。此外，"aaaccc"也是有效的答案。
 * 注意"cacaca"是不正确的，因为相同的字母必须放在一起。
 * 示例 3:
 * <p>
 * 输入:
 * "Aabb"
 * <p>
 * 输出:
 * "bbAa"
 * <p>
 * 解释:
 * 此外，"bbaA"也是一个有效的答案，但"Aabb"是不正确的。
 * 注意'A'和'a'被认为是两种不同的字符。
 */
public class 根据字符出现频率排序451 {
    public static void main(String[] args) {
        System.out.println(new 根据字符出现频率排序451().frequencySort("tree"));
    }

    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }

        StringBuilder res = new StringBuilder();
        Map<Character, Integer> tmp = new HashMap<>(map);
        for (int i = 0; i < s.length(); i++) {
            for (char c : tmp.keySet()) {
                tmp.put(c, tmp.get(c) - 1);
                if (tmp.get(c) == 0) {
                    for (int j = 0; j < map.get(c); j++) {
                        res.append(c);
                    }
                }
            }
        }

        return res.reverse().toString();
    }
}
