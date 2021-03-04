import java.util.ArrayList;

/**
 * @ClassName JZ41和为S的连续正数序列
 * @Description 穷举
 * 题目描述
 * 小明很喜欢数学,有一天他在做数学作业时,要求计算出9~16的和,他马上就写出了正确答案是100。
 * 但是他并不满足于此,他在想究竟有多少种连续的正数序列的和为100(至少包括两个数)。没多久,他就得到另一组连续正数和为100的序列:18,19,20,21,22。
 * 现在把问题交给你,你能不能也很快的找出所有和为S的连续正数序列? Good Luck!
 * 输出描述:
 * 输出所有和为S的连续正数序列。序列内按照从小至大的顺序，序列间按照开始数字从小到大的顺序
 * @Author Bruce
 * @Date 2020/7/12 8:51 下午
 */
public class JZ41和为S的连续正数序列 {
    public static void main(String[] args) {
        System.out.println(new JZ41和为S的连续正数序列().FindContinuousSequence(100));
    }

    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
        //滑动窗口，两指针
        int slow = 1, fast = 2;
        while (slow < fast) {
            //等差数列
            //通项 Tn = a + (n – 1)d
            //n项和 = (2a+(n-1)d) * n / 2
            //或
            //n项和 = (首项+尾项)*项数 / 2
            //等比数列
            //通项 Tn = aR^(n – 1)
            //n项和 = a (1 - R^n) / (1 - R)
            //如 -1 < R < 1，可求得"无限项之和"=a / (1-R)
            //由于是连续的，差为1的一个序列，那么求和公式是(a0+an)*n/2
            int cur = (slow + fast) * (fast - slow + 1) / 2;
            if (cur == sum) {
                ArrayList<Integer> list = new ArrayList<>();
                for (int i = slow; i <= fast; i++) {
                    list.add(i);
                }
                lists.add(list);
                slow++;
                //如果当前窗口内的值之和小于sum，那么右边窗口右移一下
            } else if (cur < sum) {
                fast++;
            } else {
                //如果当前窗口内的值之和大于sum，那么左边窗口右移一下
                slow++;
            }
        }
        return lists;
    }
}
