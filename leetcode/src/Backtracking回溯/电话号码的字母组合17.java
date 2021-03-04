package Backtracking回溯;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Wushiai
 * @date 2020/1/24 11:26
 * @content
 */
public class 电话号码的字母组合17 {

    /**
     * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
     * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
     * 示例:
     * 输入："23"
     * 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"]
     */

    public static void main(String[] args) {
//        System.out.println(new Backtracking回溯.电话号码的字母组合17().letterCombinations("23"));
        List<String> list = new 电话号码的字母组合17().letterCombinations("23");
        for (String s : list) {
            System.out.println(s);
        }
    }

//    public List<String> letterCombinations(String digits) {
//
//        List<String> list = new ArrayList<>();
//        if (digits.length() == 0)
//            return list;
//        String[] strs = new String[digits.length()];
//        for (int i = 0; i < digits.length(); i++)
//            switch (digits.charAt(i)) {
//                case '2':
//                    strs[i] = "abc";
//                    break;
//                case '3':
//                    strs[i] = "def";
//                    break;
//                case '4':
//                    strs[i] = "ghi";
//                    break;
//                case '5':
//                    strs[i] = "jkl";
//                    break;
//                case '6':
//                    strs[i] = "mno";
//                    break;
//                case '7':
//                    strs[i] = "pqrs";
//                    break;
//                case '8':
//                    strs[i] = "tuv";
//                    break;
//                case '9':
//                    strs[i] = "wxyz";
//                    break;
//            }
//        list = getStringWithFor(strs, 0, list, "");
//        return list;
//    }
//
//    private static List<String> getStringWithFor(String[] strs, int i, List<String> list, String stemp) {
//        if (i < strs.length - 1) {
//            for (int j = 0; j < strs[i].length(); j++) {
//                list = getStringWithFor(strs, i + 1, list, stemp + strs[i].charAt(j));
//            }
//        } else {
//            for (int j = 0; j < strs[i].length(); j++) {
//                list.add(stemp + strs[i].charAt(j));
//            }
//        }
//        return list;
//    }

    /// Backtracking回溯:回溯法是暴力解法的一个主要实现手段
/// Time Complexity: O(2^len(s))
/// Space Complexity: O(len(s))
    private String letterMap[] = {
            " ",    //0
            "",     //1
            "abc",  //2
            "def",  //3
            "ghi",  //4
            "jkl",  //5
            "mno",  //6
            "pqrs", //7
            "tuv",  //8
            "wxyz"  //9
    };

    private ArrayList<String> res;

    public List<String> letterCombinations(String digits) {

        res = new ArrayList<>();
        if ("".equals(digits)) {
            return res;
        }

        findCombination(digits, 0, "");
        return res;
    }

    private void findCombination(String digits, int index, String s) {

        if (index == digits.length()) {
            res.add(s);
            System.out.println(s);
            return;
        }

        char c = digits.charAt(index);

        String letters = letterMap[c - '0'];
        for (int i = 0; i < letters.length(); i++) {
            findCombination(digits, index + 1, s + letters.charAt(i));
        }
    }

}
