/**
 * @ClassName JZ35数组中的逆序对
 * @Description 数组
 * 题目描述
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。
 * 输入一个数组,求出这个数组中的逆序对的总数P。并将P对1000000007取模的结果输出。 即输出P%1000000007
 * 输入描述:
 * 题目保证输入的数组中没有的相同的数字
 * <p>
 * 数据范围：
 * <p>
 * 对于%50的数据,size<=10^4
 * <p>
 * 对于%75的数据,size<=10^5
 * <p>
 * 对于%100的数据,size<=2*10^5
 * <p>
 * 示例1
 * 输入
 * 1,2,3,4,5,6,7,0
 * 输出
 * 7
 * <p>
 * <p>
 * 解题：
 * <p>
 * 看到这个题目，我们的第一反应是顺序扫描整个数组。每扫描到一个数组的时候，逐个比较该数字和它后面的数字的大小。
 * 如果后面的数字比它小，则这两个数字就组成了一个逆序对。假设数组中含有n个数字。由于每个数字都要和O(n)这个数字比较，因此这个算法的时间复杂度为O(n^2)。
 * 我们以数组{7,5,6,4}为例来分析统计逆序对的过程。每次扫描到一个数字的时候，我们不拿ta和后面的每一个数字作比较，
 * 否则时间复杂度就是O(n^2)，因此我们可以考虑先比较两个相邻的数字。
 *
 * 7,5,6,4
 * 7,5-----6,4   (a)
 * 7--5-----6--4   (b)
 * 5,7-----4,6   (c)
 * 4,5,6,7   (d)
 *
 * (a) 把长度为4的数组分解成两个长度为2的子数组；
 * (b) 把长度为2的数组分解成两个成都为1的子数组；
 * (c) 把长度为1的子数组 合并、排序并统计逆序对；
 * (d) 把长度为2的子数组合并、排序，并统计逆序对；
 * 在上图（a）和（b）中，我们先把数组分解成两个长度为2的子数组，再把这两个子数组分别拆成两个长度为1的子数组。接下来一边合并相邻的子数组，一边统计逆序对的数目。
 * 在第一对长度为1的子数组{7}、{5}中7大于5，因此（7,5）组成一个逆序对。同样在第二对长度为1的子数组{6}、{4}中也有逆序对（6,4）。
 * 由于我们已经统计了这两对子数组内部的逆序对，因此需要把这两对子数组 排序 如上图（c）所示， 以免在以后的统计过程中再重复统计。
 * 接下来我们统计两个长度为2的子数组子数组之间的逆序对。合并子数组并统计逆序对的过程如下图如下图所示。
 *
 *
 * 我们先用两个指针分别指向两个子数组的末尾，并每次比较两个指针指向的数字。如果第一个子数组中的数字大于第二个数组中的数字，则构成逆序对，
 * 并且逆序对的数目等于第二个子数组中剩余数字的个数。如果第一个数组的数字小于或等于第二个数组中的数字，则不构成逆序对。
 * 每一次比较的时候，我们都把较大的数字从后面往前复制到一个辅助数组中，确保 辅助数组（记为copy） 中的数字是递增排序的。
 * 在把较大的数字复制到辅助数组之后，把对应的指针向前移动一位，接下来进行下一轮比较。
 *
 * @Author Bruce
 * @Date 2020/7/23 11:40 上午
 */
public class JZ35数组中的逆序对 {

    public int InversePairs(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int[] copy = new int[array.length];

        for (int i = 0; i < array.length; i++) {
            copy[i] = array[i];
        }
        int count = InversePairsCore(array, copy, 0, array.length - 1);
        return count;
    }

    private static int InversePairsCore(int[] array, int[] copy, int low, int high) {
        if (low == high) {
            return 0;
        }
        int mid = (low + high) >> 1;
        int leftCount = InversePairsCore(array, copy, low, mid) % 1000000007;
        int rightCount = InversePairsCore(array, copy, mid + 1, high) % 1000000007;
        int count = 0;
        int i = mid;
        int j = high;
        int locCopy = high;
        while (i >= low && j > mid) {
            if (array[i] > array[j]) {
                count += j - mid;
                copy[locCopy--] = array[i--];
                //数值过大求余
                if (count >= 1000000007) {
                    count %= 1000000007;
                }
            } else {
                copy[locCopy--] = array[j--];
            }
        }
        for (; i >= low; i--) {
            copy[locCopy--] = array[i];
        }
        for (; j > mid; j--) {
            copy[locCopy--] = array[j];
        }
        for (int s = low; s <= high; s++) {
            array[s] = copy[s];
        }
        return (leftCount + rightCount + count) % 1000000007;
    }
}
