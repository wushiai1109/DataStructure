package leetcode.editor.cn;//实现 pow(x, n) ，即计算 x 的 n 次幂函数。
//
// 示例 1: 
//
// 输入: 2.00000, 10
//输出: 1024.00000
// 
//
// 示例 2: 
//
// 输入: 2.10000, 3
//输出: 9.26100
// 
//
// 示例 3: 
//
// 输入: 2.00000, -2
//输出: 0.25000
//解释: 2-2 = 1/22 = 1/4 = 0.25 
//
// 说明: 
//
// 
// -100.0 < x < 100.0 
// n 是 32 位有符号整数，其数值范围是 [−231, 231 − 1] 。 
// 
// Related Topics 数学 二分查找 
// 👍 490 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Pow_计算x的n次方50 {
    public double myPow(double x, int n) {
        //1.暴力O(n)
//        int result = 1;
//        for (int i = 0; i < n - 1; i++) {
//            result *= x;
//        }


        //2.分治   快速幂算法
//        template:1.terminator 2.process(split your big problem) 3.drill down(subproblems),merge(subresult) 4.reverse states
//        x^n 2^10 --> 2^5 --> (2^2)*2
//        pow(x,n) :
//          subproblem : subresult = pow(x,n/2)
//        merge:
//        if n % 2 == 1 {
//            result = subresult * subresult * x;
//        }else{
//            result = subresult * subresult;
//        }
//
//        时间复杂度log(n)
//        如果是1024次方，只需要10次


//        if(x == 0.0f) {
//            return 0.0d;
//        }
//        long b = n;
//        double res = 1.0;
//        if(b < 0) {
//            x = 1 / x;
//            b = -b;
//        }
//        while(b > 0) {
//            //按位与& 同1为1
//            if((b & 1) == 1) {
//                res *= x;
//            }
//            x *= x;
//            //b/2:将一个数的各二进制位全部右移若干位，正数左补0，负数左补1，右边丢弃。
//            b >>= 1;
//        }
//        return res;


        long N = n;
        return N >= 0 ? quickMul(x, N) : 1.0 / quickMul(x, -N);


        //3.牛顿迭代法


    }

    public double quickMul(double x, long N) {
        if (N == 0) {
            return 1.0;
        }
        double y = quickMul(x, N / 2);
        return N % 2 == 0 ? y * y : y * y * x;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
