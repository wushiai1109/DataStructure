/**
 * @ClassName JZ52正则表达式匹配
 * @Description 字符串
 * 题目描述
 * 请实现一个函数用来匹配包括'.'和'*'的正则表达式。模式中的字符'.'表示任意一个字符，而'*'表示它前面的字符可以出现任意次（包含0次）。
 * 在本题中，匹配是指字符串的所有字符匹配整个模式。例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但是与"aa.a"和"ab*a"均不匹配
 * @Author Bruce
 * @Date 2020/7/9 7:03 下午
 */
public class JZ52正则表达式匹配 {
    public static void main(String[] args) {
        char[] str = new char[10];
        char[] pattern = new char[10];
        pattern[0] = '.';
        pattern[1] = '*';
        System.out.println(str);
        System.out.println(pattern);
        System.out.println(new JZ52正则表达式匹配().match(str, pattern));
    }

    public boolean match(char[] str, char[] pattern) {
        if (str == null && pattern == null) {
            return true;
        }
        if (str == null || pattern == null) {
            return false;
        }
        return match(str, 0, pattern, 0);
    }

    private boolean match(char[] str, int i, char[] pattern, int j) {
        //pattern遍历完了
        if (j == pattern.length) {
            //如果str也完了，返回true，不然false
            return str.length == i;
        }
        //注意数组越界问题，一下情况都保证数组不越界
        //下一个是*
        if (j < pattern.length - 1 && pattern[j + 1] == '*') {
            //当前匹配
            if (str.length != i && (str[i] == pattern[j] || pattern[j] == '.')) {
                //当‘*’匹配0个字符时，str当前字符不变，pattern当前字符后移两位，跳过这个‘*’符号
                //当‘*’匹配1个或多个时，str当前字符移向下一个，pattern当前字符不变
                return match(str, i, pattern, j + 2) || match(str, i + 1, pattern, j);
                //当前不匹配
            } else {
                return match(str, i, pattern, j + 2);
            }
        }
        //下一个不是“*”
        if (str.length != i && (str[i] == pattern[j] || pattern[j] == '.')) {
            return match(str, i + 1, pattern, j + 1);
        }
        return false;
    }


    //错误
//    public boolean match(char[] str, char[] pattern) {
//        if (str.length == 0 && pattern.length == 0) {
//            return true;
//        }
//        if (str.length != 0 && pattern.length == 0) {
//            return false;
//        }
//        return match(str, 0, pattern, 0);
//    }
//
//    private boolean match(char[] str, int i, char[] pattern, int j) {
//
//        if (str.length - i == 0 && (pattern.length - j) % 2 != 0) {
//            return false;
//        }
//
//        if (str.length - i == pattern.length - j) {
//            if (str[i] == pattern[j] || pattern[j] == '.') {
//                return true;
//            }
//        }
//
//
//        if (i > str.length - 1 && (j <= pattern.length - 1 && pattern[j + 1] != '*')) {
//            return false;
//        }
//
//        if (i > str.length - 1 && j > pattern.length - 1) {
//            return true;
//        }
//
//        //if the next character in pattern is not '*'
//        if (pattern[j + 1] != '*') {
//            if (str.length == 0) {
//                return false;
//            }
//            if (str[i] == pattern[j] || pattern[j] == '.') {
//                return match(str, i + 1, pattern, j + 1);
//            } else {
//                return false;
//            }
//            //if the next character is '*'
//        } else {
//            if (str.length == 0) {
//                return true;
//            }
//            //当前元素与str对应元素相等或者pattern当前元素为'.'
//            if (pattern[j] == '.' || str[i] == pattern[j]) {
//                if (pattern[j] == '.' && j + 2 > pattern.length - 1) {
//                    return true;
//                }
//                //当‘*’匹配0个字符时，str当前字符不变，pattern当前字符后移两位，跳过这个‘*’符号
//                //当‘*’匹配1个或多个时，str当前字符移向下一个，pattern当前字符不变
//                return match(str, i, pattern, j + 2) || match(str, i + 1, pattern, j);
//            } else {
//                //当前元素既不与str对应元素相等，pattern当前元素也不为'.'，则*为0
//                return match(str, i, pattern, j + 2);
//            }
//        }
//    }
}
