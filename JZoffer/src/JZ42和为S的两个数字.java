import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;

/**
 * @ClassName JZ42和为S的两个数字
 * @Description 数学 数组 双指针
 * 题目描述
 * 输入一个递增排序的数组和一个数字S，在数组中查找两个数，使得他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的。
 * 输出描述:
 * 对应每个测试案例，输出两个数，小的先输出。
 * @Author Bruce
 * @Date 2020/7/12 8:18 下午
 */
public class JZ42和为S的两个数字 {

    public static void main(String[] args) {
        int[] array = {1, 2, 4, 7, 11, 15};
        System.out.println(new JZ42和为S的两个数字().FindNumbersWithSum(array, 15));
    }

    public ArrayList<Integer> FindNumbersWithSum(int[] array, int sum) {

        //第一组就是乘积最小
        ArrayList<Integer> list = new ArrayList<>();

        if (array == null || array.length < 2) {
            return list;
        }
        int i = 0, j = array.length - 1;

        while (i < j) {
            if (array[i] + array[j] == sum) {
                list.add(array[i]);
                list.add(array[j]);
                return list;
            } else if (array[i] + array[j] > sum) {
                j--;
            } else {
                i++;
            }
        }
        return list;
    }
}
