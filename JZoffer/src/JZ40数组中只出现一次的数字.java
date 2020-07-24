import java.util.HashMap;

/**
 * @ClassName JZ40数组中只出现一次的数字
 * @Description 一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。
 * 数组
 * @Author Bruce
 * @Date 2020/7/13 8:43 下午
 */
//num1,num2分别为长度为1的数组。传出参数
//将num1[0],num2[0]设置为返回结果
public class JZ40数组中只出现一次的数字 {
    public void FindNumsAppearOnce(int[] array, int num1[], int num2[]) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : array) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        int j = 0;
        for (j = 0; j < array.length; j++) {
            if (map.get(array[j]) == 1) {
                num1[0] = array[j];
                break;
            }
        }
        for (int k = j + 1; k < array.length; k++) {
            if (map.get(array[k]) == 1) {
                num2[0] = array[k];
                break;
            }
        }
    }
}
