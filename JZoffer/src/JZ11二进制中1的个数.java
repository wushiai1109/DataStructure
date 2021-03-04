/**
 * @ClassName JZ11二进制中1的个数
 * @Description 本题知识点： 数学
 * 题目描述
 * 输入一个整数，输出该数32位二进制表示中1的个数。其中负数用补码表示。
 * 示例1
 * 输入
 * 10
 * 返回值
 * 2
 * @Author Bruce
 * @Date 2021/2/12 下午10:40
 */
public class JZ11二进制中1的个数 {
    //负数的补码，就用它的原码，减一取反，即可得到补码
    public int NumberOf1(int n) {
        int res = 0;
        while(n != 0){
            res++;
            //X=X&(X-1)清零最低位的1
            n &= (n-1);
        }
        return res;
    }
}
