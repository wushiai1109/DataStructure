import java.util.HashMap;

/**
 * @ClassName JZ28数组中出现次数超过一半的数字
 * @Description数组
 * 题目描述
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。
 * 由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
 * @Author Bruce
 * @Date 2020/7/27 7:42 下午
 */
public class JZ28数组中出现次数超过一半的数字 {
    public static void main(String[] args) {
        int[] array = {1,2,3,2,2,2,5,4,2};
        System.out.println(new JZ28数组中出现次数超过一半的数字().MoreThanHalfNum_Solution(array));
    }
    public int MoreThanHalfNum_Solution(int [] array) {
        HashMap<Integer, Integer>map = new HashMap<>();
        for (int i:array) {
            map.put(i,map.getOrDefault(i,0)+1);
            if (map.get(i)>array.length/2){
                return i;
            }
        }
        return 0;
    }
}
