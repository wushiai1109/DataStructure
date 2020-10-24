package leetcode.editor.cn;//给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
//
// 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。 
//
// 
//
// 示例: 
//
// 输入："23"
//输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
// 
//
// 说明: 
//尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。 
// Related Topics 字符串 回溯算法 
// 👍 914 👎 0


import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
class 电话号码的字母组合17 {

//    private String letterMap[] = {
//            " ",    //0
//            "",     //1
//            "abc",  //2
//            "def",  //3
//            "ghi",  //4
//            "jkl",  //5
//            "mno",  //6
//            "pqrs", //7
//            "tuv",  //8
//            "wxyz"  //9
//    };
//
//    private ArrayList<String> res;
//
//    public List<String> letterCombinations(String digits) {
//
//        res = new ArrayList<>();
//        if (digits.equals(""))
//            return res;
//
//        findCombination(digits, 0, "");
//        return res;
//    }
//
//    private void findCombination(String digits, int index, String s) {
//
//        if (index == digits.length()) {
//            res.add(s);
//            return;
//        }
//
//        Character c = digits.charAt(index);
//
//        String letters = letterMap[c - '0'];
//        for (int i = 0; i < letters.length(); i++)
//            findCombination(digits, index + 1, s + letters.charAt(i));
//    }

    public static void main(String[] args) {
        System.out.println(new 电话号码的字母组合17().letterCombinations("23"));
    }

    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return new ArrayList<>();
        }
        Map<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        List<String> res = new LinkedList<>();
        search("", digits, 0, res, map);
        return res;
    }

    //i:level
    private void search(String s, String digits, int i, List<String> res, Map<Character, String> map) {
        //terminator
        if (i == digits.length()) {
            res.add(s);
            return;
        }

        //process
        String letters = map.get(digits.charAt(i));
        for (int j = 0; j < letters.length(); j++) {
            //dill down
            search(s + letters.charAt(j), digits, i + 1, res, map);
        }

        //reverse

    }


}
//leetcode submit region end(Prohibit modification and deletion)
