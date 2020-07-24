package 加减计算符计算;

/**
 * @author Wushiai
 * @date 2019/10/20 20:11
 */
public class ExpressionToDouble {

    private static boolean isNumber(char ch) {
        return ch == '.' || (ch >= '0' && ch <= '9');
    }

    private static double run(String str) {
        double sum = 0.0;
        int j = 0;
        char[] chars = str.toCharArray();
        char[] newChars = new char[100];

        for (int i = 0; i < chars.length; i++) {
            if (isNumber(chars[i]))
                newChars[j++] = chars[i];
            else if (chars[i] == '-') {
                if (chars[i + 1] == '+') {
                    newChars[j++] = chars[i];
                    ++i;
                } else if (chars[i + 1] == '-') {
                    newChars[j++] = '+';
                    ++i;
                } else
                    newChars[j++] = chars[i];
            } else if (chars[i] == '+') {
                if (chars[i + 1] == '+') {
                    newChars[j++] = chars[i];
                    ++i;
                } else if (chars[i + 1] == '-') {
                    newChars[j++] = chars[i + 1];
                    ++i;
                } else
                    newChars[j++] = chars[i];
            }
        }
        StringBuilder str1 = new StringBuilder();
        int x = 0, y = 1, i = 0;
        char z = '+';
        for (i = 0; i < newChars.length; i++) {
            if ((newChars[i] == '+' || newChars[i] == '-') && y == 1) {
                sum += Double.parseDouble(str1.substring(0, i));
                ++y;
                z = newChars[i];
                x = i + 1;
            } else if (newChars[i] == '+' && z == '+') {
                sum += Double.parseDouble(str1.substring(x, i));
                z = '+';
                x = i + 1;
            } else if (newChars[i] == '+' && z == '-') {
                sum -= Double.parseDouble(str1.substring(x, i));
                z = '+';
                x = i + 1;
            } else if (newChars[i] == '-' && z == '+') {
                sum += Double.parseDouble(str1.substring(x, i));
                z = '-';
                x = i + 1;
            } else if (newChars[i] == '-' && z == '-') {
                sum -= Double.parseDouble(str1.substring(x, i));
                z = '-';
                x = i + 1;
            }
            str1.append(newChars[i]);
        }
        if (z == '-')
            sum -= Double.parseDouble(str1.substring(x));
        else if (z == '+')
            sum += Double.parseDouble(str1.substring(x));
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(run("76.453-24.212"));
//        BigDecimal保存小数
    }

}