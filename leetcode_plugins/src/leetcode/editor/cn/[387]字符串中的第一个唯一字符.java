package leetcode.editor.cn;//给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
//
// 
//
// 示例： 
//
// s = "leetcode"
//返回 0
//
//s = "loveleetcode"
//返回 2
// 
//
// 
//
// 提示：你可以假定该字符串只包含小写字母。 
// Related Topics 哈希表 字符串 
// 👍 274 👎 0


import java.util.HashMap;

//leetcode submit region begin(Prohibit modification and deletion)
class 字符串中的第一个唯一字符387 {
    //1. brute- force:
    //i枚举所有字符
    //j枚举i后面的所有字符//找重复
    //0(n^2)

    //2. map (hashmap 0(1)，treemap 0(logN))
    //0(N) or 0(NlogN)

    //3. hash table
    public int firstUniqChar(String s) {
        //ASCII  int[] freq = new int[256];
        int[] freq = new int[26];
        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
        }

        for (int i = 0; i < s.length(); i++) {
            if (freq[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }

//    public int firstUniqChar(String s) {
//        HashMap<Character, Integer> map = new HashMap<>();
//        for (int i = 0; i < s.length(); i++) {
//            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
//        }
//        for (int i = 0; i < s.length(); i++) {
//            if (map.get(s.charAt(i)) == 1) {
//                return i;
//            }
//        }
//        return -1;
//    }
}
//leetcode submit region end(Prohibit modification and deletion)
