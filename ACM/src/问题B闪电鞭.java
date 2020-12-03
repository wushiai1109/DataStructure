/**
 * @ClassName 问题B闪电鞭
 * @Description 题目描述
 * 马老师的独家功夫闪电鞭闻名天下(B站)，为了增强功法，马老师来到了树林里练习闪电鞭。
 * n棵松树从左到右排成一行，每棵树上有a[i]个松果，马老师每打一鞭，树林就会前后反转，即a[1],a[2]...a[n] --> a[n], a[n-1]....a[1]。
 * 马老师为了考验你，提出了一个问题，马老师打了x鞭后，从左到右数第L棵树到第R棵树上的松果数量和为多少
 * 简化题意 : 求原数组经过x次反转后a[L] + a[L+1] + ... +a[R]的和
 * 为了成为马老师的真传弟子，你必须回答对每个询问。
 * 输入
 * 第一行两个整数n(1<=n<=100000)，m(1<=m<=1000)，分别表示数组长度和询问个数.
 * 接下来一行n个整数，第i个数表示第i棵树上的松果数量，即a[i] (1<=a[i]<=1000000000).
 * 接下来m行，每行三个整数x(0<=x<=100000)，L(1<=L<=n)，R(1<=R<=n)，表示反转次数和询问的左右区间，数据保证L<=R。
 * 输出
 * m行，每行一个整数表示反转x次后，a[L] + a[L+1] + ... +a[R]的和
 * 样例输入
 * 5 3
 * 1 2 3 4 5
 * 0 1 5
 * 1 1 2
 * 2 2 5
 * 样例输出
 * 15
 * 9
 * 14
 * 提示
 * 样例解释
 * 1. 0次反转，数组不变，a[1] + a[2] + a[3] + a[4] + a[5] = 15
 * 2. 1次反转，数组变为 5 4 3 2 1，a[1] + a[2] = 9
 * 3. 2次反转，数组变为 1 2 3 4 5，a[2] + a[3] + a[4] + a[5] = 14
 * 注意数据范围
 * @Author Bruce
 * @Date 2020/11/14 6:05 下午
 */

import java.util.Scanner;

public class 问题B闪电鞭 {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int n = input.nextInt();
        int m = input.nextInt();

        if (n >= 1 && n <= 100000 && m >= 1 && m <= 1000) {

            int[] a = new int[n];
            long[] sum = new long[n + 1];//反转前各前n项的和
            long[] sum2 = new long[n + 1];//反转后各前n项的和

            for (int i = 0; i < n; i++) {
                a[i] = input.nextInt();
                sum[i + 1] = a[i] + sum[i];
            }

            for (int i = a.length - 1; i >= 0; i--) {
                sum2[n - i] = sum2[n - i - 1] + a[i];
            }

            int[][] q = new int[m][3];

            for (int i = 0; i < m; i++) {

                int p = input.nextInt();
                int left = input.nextInt() - 1;
                int right = input.nextInt();

                if (left >= 0 && left <= right && right <= n) {
                    q[i][0] = p;
                    q[i][1] = left;
                    q[i][2] = right;
                }

            }

            for (int j = 0; j < m; j++) {

                if (q[j][0] % 2 == 0) {
                    System.out.println(sum[q[j][2]] - sum[q[j][1]]);
                } else {
                    System.out.println(sum2[q[j][2]] - sum2[q[j][1]]);
                }

            }

        }
    }
}
