package leetcode.editor.cn;//统计所有小于非负整数 n 的质数的数量。
//
// 
//
// 示例 1： 
//
// 输入：n = 10
//输出：4
//解释：小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7 。
// 
//
// 示例 2： 
//
// 输入：n = 0
//输出：0
// 
//
// 示例 3： 
//
// 输入：n = 1
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 0 <= n <= 5 * 106 
// 
// Related Topics 哈希表 数学 
// 👍 573 👎 0


import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class 计数质数204 {
    public int countPrimes(int n) {
        if (n <= 1) {
            return 0;
        }
        int[] isPrime = new int[n];
        //把里面所有的值赋值为1
        Arrays.fill(isPrime, 1);
        //计算质数的数量
        int res = 0;
        for (int i = 2; i < n; ++i) {
            //2肯定为质数
            if (isPrime[i] == 1) {
                //为质数
                res++;
                //判断是j是否是i的倍数
                if ((long) i * i < n) {
                    for (int j = i * i; j < n; j += i) {
                        //如果是倍数，那么一定不是质数
                        isPrime[j] = 0;
                    }
                }
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
