/**
 * @ClassName 字符串的中文数字转化为阿拉伯数字
 * @Description 中文字符串转成数字。例：“五百三十万六千零三” -> 5306003。约束：输入金额在一亿以内
 * @Author Bruce
 * @Date 2020/11/20 12:08 上午
 */
public class 字符串的中文数字转化为阿拉伯数字 {

    public static void main(String[] args) {
        System.out.println(new 字符串的中文数字转化为阿拉伯数字());
    }

//    private static Pattern numPattern = Pattern.compile("\\d+");

    /**
     * 把“火影第二部第三百二十回”转化为“火影第2部第320回”
     *
     * @param s
     * @return 对应字符串的阿拉伯数字形式
     * @author chow 2010-8-19 上午11:04:35
     */
    private static String cnNumToInt(String s) {
        StringBuffer result = new StringBuffer();
        int sum = 0;
        boolean cnInterupt = false; // 转化过程被中文间断

        int yi = 1;// 记录高级单位
        int wan = 1;// 记录高级单位
        int ge = 1;// 记录单位

        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            int temp = 0;// 记录数值
            switch (c) {
                // 数值
                case '〇':
                case '零':
                    temp = 0;
                    break;
                case '一':
                    temp = 1 * ge * wan * yi;
                    ge = 1;
                    break;
                case '二':
                    temp = 2 * ge * wan * yi;
                    ge = 1;
                    break;
                case '三':
                    temp = 3 * ge * wan * yi;
                    ge = 1;
                    break;
                case '四':
                    temp = 4 * ge * wan * yi;
                    ge = 1;
                    break;
                case '五':
                    temp = 5 * ge * wan * yi;
                    ge = 1;
                    break;
                case '六':
                    temp = 6 * ge * wan * yi;
                    ge = 1;
                    break;
                case '七':
                    temp = 7 * ge * wan * yi;
                    ge = 1;
                    break;
                case '八':
                    temp = 8 * ge * wan * yi;
                    ge = 1;
                    break;
                case '九':
                    temp = 9 * ge * wan * yi;
                    ge = 1;
                    break;
                // 单位，前缀是单数字
                case '十':
                    ge = 10;
                    break;
                case '百':
                    ge = 100;
                    break;
                case '千':
                    ge = 1000;
                    break;
                // 高级单位，前缀可以是多个数字
                case '万':
                    wan = 10000;
                    ge = 1;
                    break;
                case '亿':
                    yi = 100000000;
                    wan = 1;
                    ge = 1;
                    break;
                default:
                    cnInterupt = true;
            }
            // 先把当前累加的sum拼到原字符串，再把非中文数字 字符拼回原字符串
            if (cnInterupt) {
                if (sum != 0) {
                    result.insert(0, sum);
                }
                result.insert(0, c);
                cnInterupt = false;
                sum = temp = 0;
                ge = wan = yi = 1;
            }
//            if (ge == 10 && (i==0||numPattern.matcher(s.substring(i-1,i)).find())) { // 对第十集，第十二，十五的特殊处理
//                temp = 10;
//            }
            sum += temp;
        }
        if (sum != 0) {
            result.insert(0, sum);
        }
        return result.toString();
    }
}
