import java.util.Arrays;

/**
 * @ClassName JZ46孩子们的游戏_圆圈中最后剩下的数
 * @Description 链表 数学
 * 题目描述
 * 每年六一儿童节,牛客都会准备一些小礼物去看望孤儿院的小朋友,今年亦是如此。HF作为牛客的资深元老,自然也准备了一些小游戏。
 * 其中,有个游戏是这样的:首先,让小朋友们围成一个大圈。然后,他随机指定一个数m,让编号为0的小朋友开始报数。每次喊到m-1的那个小朋友要出列唱首歌,
 * 然后可以在礼品箱中任意的挑选礼物,并且不再回到圈中,从他的下一个小朋友开始,继续0...m-1报数....这样下去....直到剩下最后一个小朋友,可以不用表演,
 * 并且拿到牛客名贵的“名侦探柯南”典藏版(名额有限哦!!^_^)。请你试着想下,哪个小朋友会得到这份礼品呢？(注：小朋友的编号是从0到n-1)
 * <p>
 * 如果没有小朋友，请返回-1
 * @Author Bruce
 * @Date 2020/7/11 8:23 下午
 */
public class JZ46孩子们的游戏_圆圈中最后剩下的数 {

    /**
     * @return int
     * @Description 这道题使用来模拟环，思路简单，下标要明确
     * @Param [n, m]
     **/
    public static int findLastNumber(int n, int m) {
        if (n < 1 || m < 1) {
            return -1;
        }
        int[] array = new int[n];
//        Arrays.fill(array,-1);
        int i = -1, step = 0, count = n;
        //跳出循环时将最后一个元素也设置为了-1
        while (count > 0) {
            //指向上一个被删除对象的下一个元素。
            i++;
            //模拟环
            if (i == n) {
                i = 0;
            }
            //跳过被删除的对象
            if (array[i] == -1) {
                continue;
            }
            //记录已走过的
            step++;
            //找到待删除的对象
            if (step == m) {
                array[i] = -1;
                step = 0;
                count--;
            }
        }
        //返回跳出循环时的i,即最后一个被设置为-1的元素
        return i;
    }
}
