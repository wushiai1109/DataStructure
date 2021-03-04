/**
 * @ClassName JZ12数值的整数次方
 * @Description 本题知识点： 数学
 * 题目描述
 * 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
 * 保证base和exponent不同时为0
 * 示例1
 * 输入
 * 2,3
 * 返回值
 * 8.00000
 * @Author Bruce
 * @Date 2021/2/12 下午6:47
 */
public class JZ12数值的整数次方 {
    public double Power(double base, int exponent) {
        if (exponent < 0) {
            base = 1 / base;
            exponent = -exponent;
        }
        double res = 1.0;
        if (exponent > 0) {
            for (; exponent >= 1; exponent--) {
                res *= base;
            }
        }
        return res;
    }
}
