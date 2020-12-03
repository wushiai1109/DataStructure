package 贪心算法;

import java.util.Arrays;

/**
 * @author Wushiai
 * @date 2020/4/27 16:11
 * @content 假设你是一位很棒的家长，想要给你的孩子们一些小饼干。但是，每个孩子最多只能给一块饼干。对每个孩子 i ，都有一个胃口值 gi ，这是能让孩子们满足胃口的饼干的最小尺寸；并且每块饼干 j ，都有一个尺寸 sj 。如果 sj >= gi ，我们可以将这个饼干 j 分配给孩子 i ，这个孩子会得到满足。你的目标是尽可能满足越多数量的孩子，并输出这个最大数值。
 * <p>
 * 注意：
 * <p>
 * 你可以假设胃口值为正。
 * 一个小朋友最多只能拥有一块饼干。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,2,3], [1,1]
 * <p>
 * 输出: 1
 * <p>
 * 解释:
 * 你有三个孩子和两块小饼干，3个孩子的胃口值分别是：1,2,3。
 * 虽然你有两块小饼干，由于他们的尺寸都是1，你只能让胃口值是1的孩子满足。
 * 所以你应该输出1。
 * 示例 2:
 * <p>
 * 输入: [1,2], [1,2,3]
 * <p>
 * 输出: 2
 * <p>
 * 解释:
 * 你有两个孩子和三块小饼干，2个孩子的胃口值分别是1,2。
 * 你拥有的饼干数量和尺寸都足以让所有孩子满足。
 * 所以你应该输出2.
 */
public class 分发饼干455 {

    /// Greedy Algorithm
/// Serve most greedy children first
/// Time Complexity: O(nlogn)
/// Space Complexity: O(1)
    public int findContentChildren(int[] g, int[] s) {

        Arrays.sort(g);
        Arrays.sort(s);

        int gi = g.length - 1, si = s.length - 1;
        int res = 0;
        while (gi >= 0 && si >= 0) {
            if (s[si] >= g[gi]) {
                res++;
                si--;
            }
            gi--;
        }

        return res;
    }

//    public int findContentChildren(int[] g, int[] s) {
//
//        Arrays.sort(g);
//        Arrays.sort(s);
//
//        int gi = 0, si = 0;
//        int res = 0;
//        while (gi <= g.length - 1 && si <= s.length - 1) {
//            if (s[si] >= g[gi]) {
//                res++;
//                gi++;
//            }
//            si++;
//        }
//
//        return res;
//    }

    public static void main(String[] args) {

        int g1[] = {1, 2, 3};
        int s1[] = {1, 1};
        System.out.println((new 分发饼干455()).findContentChildren(g1, s1));

        int g2[] = {1, 2};
        int s2[] = {1, 2, 3};
        System.out.println((new 分发饼干455()).findContentChildren(g2, s2));
    }
}
