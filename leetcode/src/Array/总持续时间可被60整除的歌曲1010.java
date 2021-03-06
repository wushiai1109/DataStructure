package Array;

/**
 * @ClassName 总持续时间可被60整除的歌曲1010
 * @Description 在歌曲列表中，第 i 首歌曲的持续时间为 time[i] 秒。
 *
 * 返回其总持续时间（以秒为单位）可被 60 整除的歌曲对的数量。形式上，我们希望索引的数字 i 和 j 满足  i < j 且有 (time[i] + time[j]) % 60 == 0。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：[30,20,150,100,40]
 * 输出：3
 * 解释：这三对的总持续时间可被 60 整数：
 * (time[0] = 30, time[2] = 150): 总持续时间 180
 * (time[1] = 20, time[3] = 100): 总持续时间 120
 * (time[1] = 20, time[4] = 40): 总持续时间 60
 * 示例 2：
 *
 * 输入：[60,60,60]
 * 输出：3
 * 解释：所有三对的总持续时间都是 120，可以被 60 整数。
 *  
 *
 * 提示：
 *
 * 1 <= time.length <= 60000
 * 1 <= time[i] <= 500
 * @Author Bruce
 * @Date 2020/5/21 8:03 下午
 */
public class 总持续时间可被60整除的歌曲1010 {

    //用一个数组记录每个时间对应的模60结果的总和，如果两个数的模相加为60，则这两个数相加是60的倍数
    public int numPairsDivisibleBy60(int[] time) {
        int[] record = new int[60];
        int count = 0;
        for(int t : time){
            t %= 60;        //求这个时间的余数
            if(t != 0) {
                count += record[60 - t];    //如果时间余数不为0，找出相加为0的余数总和相加
            } else {
                count += record[t];        //如果为0，加其他为0的数
            }
            record[t] ++;
        }
        return count;
    }
}
