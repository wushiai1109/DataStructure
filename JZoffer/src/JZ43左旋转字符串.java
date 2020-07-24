/**
 * @ClassName JZ43左旋转字符串
 * @Description 字符串
 * 汇编语言中有一种移位指令叫做循环左移（ROL），现在有个简单的任务，就是用字符串模拟这个指令的运算结果。
 * 对于一个给定的字符序列S，请你把其循环左移K位后的序列输出。例如，字符序列S=”abcXYZdef”,要求输出循环左移3位后的结果，即“XYZdefabc”。
 * 是不是很简单？OK，搞定它！
 * @Author Bruce
 * @Date 2020/7/12 8:05 下午
 */
public class JZ43左旋转字符串 {

    public static void main(String[] args) {
        System.out.println(new JZ43左旋转字符串().LeftRotateString("abcXYZdef",3));
    }

    public String LeftRotateString(String str,int n) {
        if ("".equals(str)){
            return str;
        }

//        String str1 = str.substring(0,n);
//        String str2 = str.substring(n);
        StringBuilder sb = new StringBuilder();
//        sb.append(str2).append(str1);

        sb.append(str.substring(n)).append(str.substring(0,n));

        return sb.toString();
    }
}
