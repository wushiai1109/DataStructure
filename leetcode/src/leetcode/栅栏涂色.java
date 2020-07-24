package leetcode;

/**
 * @author Wushiai
 * @date 2020/2/3 20:04
 * @content 有 k 种颜色的涂料和一个包含 n 个栅栏柱的栅栏，每个栅栏柱可以用其中一种颜色进行上色。
 * <p>
 * 你需要给所有栅栏柱上色，并且保证其中相邻的栅栏柱 最多连续两个 颜色相同。然后，返回所有有效涂色的方案数。
 * <p>
 * 注意:
 * n 和 k 均为非负的整数。
 * <p>
 * 示例:
 * <p>
 * 输入: n = 3，k = 2
 * 输出: 6
 * 解析: 用 c1 表示颜色 1，c2 表示颜色 2，所有可能的涂色方案有:
 * <p>
 *             柱 1    柱 2   柱 3     
 *  -----      -----  -----  -----       
 *    1         c1     c1     c2 
 *    2         c1     c2     c1 
 *    3         c1     c2     c2 
 *    4         c2     c1     c1  
 *    5         c2     c1     c2
 *    6         c2     c2     c1
 * <p>
 * 思路：动态规划。
 * <p>
 * n=1,k钟
 * <p>
 * n=2,k*k种。
 * <p>
 * n>2:
 * <p>
 * n可以和n-1位置颜色相同，这时这两个位置可选项有k-1种颜色可用，再乘n-2位置方案总数。
 * <p>
 * n可以和n-1位置颜色不同，这时这个位置有k-1种颜色可用，再乘n-1位置的方案总数。
 */
public class 栅栏涂色 {

    public static void main(String[] args) {
        System.out.println(new 栅栏涂色().numWays(3, 2));
    }

    public int numWays(int n, int k) {
        if (n == 0) return 0;
        if (n == 1) return k;
        int[] arr = new int[n];
        arr[0] = k;
        arr[1] = k * k;
        for (int i = 2; i < n; i++) {
            arr[i] = arr[i - 2] * (k - 1) + arr[i - 1] * (k - 1);
            //arr[i]=(arr[i-1]+arr[i-2])*(k-1);
        }
        return arr[n - 1];
    }


}
