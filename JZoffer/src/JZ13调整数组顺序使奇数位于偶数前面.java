import java.util.Arrays;

/**
 * @ClassName JZ13调整数组顺序使奇数位于偶数前面
 * @Description 本题知识点： 数组
 * 题目描述
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，
 * 所有的偶数位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 * @Author Bruce
 * @Date 2021/2/12 下午6:28
 */
public class JZ13调整数组顺序使奇数位于偶数前面 {

    public static void main(String[] args) {
        int []array = {1,2,3,4,5,6,7,8};
        new JZ13调整数组顺序使奇数位于偶数前面().reOrderArray(array);
        System.out.println(Arrays.toString(array));

        System.out.println(Math.pow(2,3));
    }

    public int[] reOrderArray(int[] array) {
        int index = 0;
        //i用于遍历数组使用，index用于定位
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 1) {
                int temp = array[i];
                if (i - index >= 0) {
                    System.arraycopy(array, index, array, index + 1, i - index);
                }
                array[index] = temp;
                index++;
            }
        }
        return array;
    }

    public void reOrderArray2(int[] array) {
        int length = array.length;
        int index = 0;
        //i用于遍历数组使用，index用于定位
        int i = 0;
        while (i < length) {
            if (array[i] % 2 != 0) {
                int temp = array[i];
                if (i - index >= 0) {
                    System.arraycopy(array, index, array, index + 1, i - index);
                }
                array[index] = temp;
//                swap(array, index, copy);
                index++;
                i++;
            } else {
                i++;
            }
        }
    }

//    public void swap(int[] array, int i, int j) {
//        int temp = array[i];
//        array[i] = array[j];
//        array[j] = temp;
//    }

}
