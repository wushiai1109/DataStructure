/**
 * @ClassName 问题D拆弹专家
 * @Description 题目描述
 * 枪在手，跟我走，杀四郎，抢碉楼！
 * 黄四郎在大战中被击败，逃跑前在鹅城埋下了大量炸弹，张麻子请来了拆弹专家马老师。
 * 鹅城有n座建筑排成一排，某些建筑下被埋了炸弹，马老师拆炸弹很快啊，啪的一下拆掉一个炸弹后相邻的建筑中的炸弹都会被拆除(如果有n个相连的建筑都有炸弹，那么马老师随便拆除一个，这n个建筑的炸弹都会被拆除)。
 * 除了拆炸弹外，马老师还可以在建筑下埋炸弹，这样就可以让一些有炸弹的建筑连起来，一起拆弹。
 * 马老师开价不菲，每个拆弹操作需要A元，每埋一个炸弹需要B元，为了节省经费，张麻子想花最少的钱拆掉所有炸弹。
 * 输入
 * 第一行一个整数T(1<=T<=1000)，表示数据组数.
 * 每组数据第一行三个整数n(1<=n<=100000)，A(1<=A<=1000)，B(1<=B<=1000)分别表示建筑个数，拆一个炸弹的价格，埋一个炸弹的价钱.
 * 接下来一行，一个长度为n的字符串，字符串中只包含“0”和“1”，“1”表示建筑下有炸弹，“0”表示没有炸弹.
 * 保证所有T组数据的n加起来不超过100000.
 * 输出
 * 对于每组数据输出一行，一个整数，表示拆除所有炸弹需要的最小花费
 * 样例输入 Copy
 * 2
 * 8 1 1
 * 01000010
 * 8 5 1
 * 01101110
 * 样例输出 Copy
 * 2
 * 6
 * 提示
 * 样例解释
 * 第一个样例，直接拆除两个炸弹花费最小，为2元
 * 第二个样例，先花费1元在第四个建筑下埋一个炸弹，然后花费5元拆除这六个连续的炸弹，总共花费6元
 * @Author Bruce
 * @Date 2020/11/14 11:56 下午
 */

import java.util.Scanner;

public class 问题D拆弹专家 {

    public static int sub(int len, String str, int a, int b, int min, int left, int right, boolean dp[]) {
        for (int j = 0; j < len; j++) {
            if (str.charAt(j) == '1') {

                if (str.charAt(left) != '1') {
                    left = j;
                    while (str.charAt(left + 1) == '1') {
                        left++;
                    }

                    if (left != j) {
                        min += a;
                        dp[j] = true;

                        j = left;
                        right = left + 1;
                    } else {
                        right = left + 1;
                    }

                } else if (str.charAt(left) == '1' && str.charAt(right) != '1') {
                    right = j;

                    //前面为连续，装的费用也更少，则选择装炸弹
                    if ((right - left - 1) * b <= a && dp[left]) {
                        min += (right - left - 1) * b;
                        left = j;
                        //后面仍有炸弹
                        while (str.charAt(left + 1) == '1') {
                            left++;
                        }
                        j = left;
                        right = left + 1;
                    } else if ((right - left - 1) * b > a && dp[left]) {
                        //前面为连续，装的费用更多，则跳过
                        left = j;
                        min += sub(len, str.substring(j), a, b, min, 0, -1, dp);
                    } else if ((right - left - 1) * b <= a) {
                        //前面为不连续，装的费用更少

                    }

                } else if (str.charAt(right) == '1') {
                    //若存有连续的1 （存在连续的炸弹一定是花费a元进行拆解）
                    if (right == left + 1) {
                        while (str.charAt(right + 1) == '1' && right + 1 < len) {
                            right++;
                        }

                        left = right++;
                        j = left;


                    }

                }
            }
        }
        return 0;
    }


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int groupNum = scanner.nextInt();
        int[] group = new int[groupNum];

        for (int i = 0; i < groupNum; i++) {

            int len = scanner.nextInt();
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            String str = scanner.next();

            boolean[] dp = new boolean[len];

            int min = 0;

            int left = 0, right = -1;

            sub(len, str, a, b, min, left, right, dp);

        }

        for (int res : group) {
            System.out.println(res);
        }

    }

//    static boolean flag = false;
//
//    public static void main(String[] args) {
//
//        Scanner scanner = new Scanner(System.in);
//
//        int groupNum = scanner.nextInt();
//        int[] group = new int[groupNum];
//
//        for (int i = 0; i < groupNum; i++) {
//
//            int len = scanner.nextInt();
//            int a = scanner.nextInt();
//            int b = scanner.nextInt();
//            String str = scanner.next();
//
//            int min = 0;
//
//            int left = 0, right = -1;
//
//            for (int j = 0; j < len; j++) {
//                if (str.charAt(j) == '1') {
//
//                    if (str.charAt(left) != '1') {
//                        left = j;
//                        while (str.charAt(left + 1) == '1') {
//                            left++;
//                        }
//
//                        if (left != j) {
//                            min += a;
//                            flag = true;
//
//                            j = left;
//                            right = left + 1;
//                        } else {
//                            right = left + 1;
//                        }
//
//                    } else if (str.charAt(left) == '1' && str.charAt(right) != '1') {
//                        right = j;
//
//                        if ((right - left - 1) * b >= a) {
//                            min += (right - left - 1) * b;
//
//                            left = j;
//                            if (str.charAt(left + 1) == '1') {
//                                while (str.charAt(left + 1) == '1') {
//                                    left++;
//                                }
//                            }
//                            flag = true;
//
//
//                        } else {
//
//                        }
//
//                        min += Math.min((right - left - 1) * b, a);
//
//                        left = j;
//
//                    } else if (str.charAt(right) == '1') {
//                        //若存有连续的1 （存在连续的炸弹一定是花费a元进行拆解）
//                        if (right == left + 1) {
//                            while (str.charAt(right + 1) == '1' && right + 1 < len) {
//                                right++;
//                            }
//
//                            left = right++;
//                            j = left;
//
//                            flag = true;
//
//                        }
//
//                    }
//                }
//            }
//            group[i] = flag ? min : min + a;
//        }
//
//        for (int res : group) {
//            System.out.println(res);
//        }
//
//    }
}
