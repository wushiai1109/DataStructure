/**
 * @ClassName JZ47求1加到n
 * @Description 进制转化 数学
 * 题目描述
 * 求1+2+3+...+n，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 * @Author Bruce
 * @Date 2020/7/11 8:00 下午
 */
public class JZ47求1加到n {

    public static void main(String[] args) {
        System.out.println(new JZ47求1加到n().Sum_Solution(4));
    }

    public int Sum_Solution(int n) {
        int sum = n;
        boolean flag = (n != 0) && ((sum += Sum_Solution(n - 1)) > 0);
        return sum;
    }
}
