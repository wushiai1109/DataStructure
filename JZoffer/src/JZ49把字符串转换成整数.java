/**
 * @ClassName JZ49把字符串转换成整数
 * @Description 字符串 数学 字符串
 * 题目描述
 * 将一个字符串转换成一个整数，要求不能使用字符串转换整数的库函数。 数值为0或者字符串不是一个合法的数值则返回0
 * 输入描述:
 * 输入一个字符串,包括数字字母符号,可以为空
 * 输出描述:
 * 如果是合法的数值表达则返回该数字，否则返回0
 * 示例1
 * 输入
 * +2147483647
 * 1a33
 * 输出
 * 2147483647
 * 0
 * @Author Bruce
 * @Date 2020/7/11 7:08 下午
 */
public class JZ49把字符串转换成整数 {
    public static void main(String[] args) {
        System.out.println(new JZ49把字符串转换成整数().StrToInt("+2147483647"));
        System.out.println(new JZ49把字符串转换成整数().StrToInt("1563ghgs"));
        System.out.println(new JZ49把字符串转换成整数().StrToInt("123"));
        System.out.println(new JZ49把字符串转换成整数().StrToInt("+"));
        System.out.println(new JZ49把字符串转换成整数().StrToInt(""));
    }

    public int StrToInt(String str) {
        if (str.equals("")) {
            return 0;
        }

        char[] chars = str.toCharArray();
        if (chars[0] != '+' && chars[0] != '-' && (chars[0] < '0' || chars[0] > '9')) {
            return 0;
        }else if ((chars[0] == '+' && chars.length == 1) || (chars[0] == '-' && chars.length == 1)){
            return 0;
        }


        for (int i = 1; i < chars.length; i++) {
            if (chars[i] < '0' || chars[i] > '9') {
                return 0;
            }
        }
        if (chars[0] == '+') {
            return Integer.parseInt(str.substring(1));
        }
        return Integer.parseInt(str);
    }
}
