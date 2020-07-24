import java.util.HashMap;

/**
 * @ClassName JZ45扑克牌顺子
 * @Description 字符串
 * 题目描述
 * LL今天心情特别好,因为他去买了一副扑克牌,发现里面居然有2个大王,2个小王(一副牌原本是54张^_^)...他随机从中抽出了5张牌,想测测自己的手气,看看能不能抽到顺子,
 * 如果抽到的话,他决定去买体育彩票,嘿嘿！！“红心A,黑桃3,小王,大王,方片5”,“Oh My God!”不是顺子.....LL不高兴了,他想了想,决定大\小 王可以看成任何数字,
 * 并且A看作1,J为11,Q为12,K为13。上面的5张牌就可以变成“1,2,3,4,5”(大小王分别看作2和4),“So Lucky!”。LL决定去买体育彩票啦。
 * 现在,要求你使用这幅牌模拟上面的过程,然后告诉我们LL的运气如何， 如果牌能组成顺子就输出true，否则就输出false。为了方便起见,你可以认为大小王是0。
 * @Author Bruce
 * @Date 2020/7/12 8:51 上午
 */
public class JZ45扑克牌顺子 {
    public static void main(String[] args) {
        int[] numbers = {1, 3, 2, 5, 4};
        int[] numbers1 = {};

        System.out.println(new JZ45扑克牌顺子().isContinuous(numbers));
        System.out.println(new JZ45扑克牌顺子().isContinuous(numbers1));
    }

    public boolean isContinuous(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            return false;
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        int max = -1, min = 14;
        for (int i : numbers) {
            if (i == 0) {
                continue;
            }
            map.put(i, map.getOrDefault(i, 0) + 1);
            if (map.get(i) > 1) {
                return false;
            }
            if (i >= max) {
                max = i;
            }
            if (i <= min) {
                min = i;
            }
        }
        return max - min < 5;
    }
}
