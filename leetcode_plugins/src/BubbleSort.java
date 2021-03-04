import java.util.Arrays;

/**
 * @ClassName BubbleSort
 * @Description
 * @Author Bruce
 * @Date 2021/1/9 下午8:41
 */
public class BubbleSort {

    //冒泡排序
    //1、小的元素往前调或者把大的元素往后调；
    //2、比较是相邻的两个元素比较，交换也发生在这两个元素之间；
    //3、稳定排序算法。
    public static void main(String[] args) {
        int[] arr = {6, 1, 5, 2, 3, 7, 4, 9, 8};
        new BubbleSort().bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    //Time Complexity:O(n^2)
    //Space Complexity：O(1)
    public void bubbleSort(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }
        int len = arr.length;
        for (int i = 0; i < len - 1; i++) {
            for (int j = 0; j < len - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

}
