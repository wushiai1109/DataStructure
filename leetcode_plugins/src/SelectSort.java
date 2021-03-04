import java.util.Arrays;

/**
 * @ClassName SelectSort
 * @Description
 * @Author Bruce
 * @Date 2021/1/9 下午9:00
 */
public class SelectSort {

    //选择排序
    //1、每个位置选择当前元素最小的；
    //2、在一趟选择中，如果当前元素比一个元素小，而该小的元素又出现在一个和当前元素相等的元素后面，那么交换后稳定性就被破坏了；
    //3、举个例子，序列5 8 5 2 9， 我们知道第一遍选择第1个元素5会和2交换，那么原序列中2个5的相对前后顺序就被破坏了；
    //4、不稳定的排序算法。
    public static void main(String[] args) {
        int[] arr = {6, 1, 5, 2, 3, 7, 4, 9, 8};
        new SelectSort().selectSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    //Time Complexity:O(n^2)
    //Space Complexity：O(1)
    public void selectSort(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }
        int len = arr.length;
        for (int i = 0; i < len - 1; i++) {
            //minIndex 用来保存每次比较后较小数的下标。
            int minIndex = i;
            for (int j = i + 1; j < len; j++) {
                //每比较一次都需要将较小数的下标记录下来
                if (arr[minIndex] > arr[j]) {
                    minIndex = j;
                }
            }
            //当完成一次循环时，就需要将本次循环选取的最小数移动到本次循环开始的位置。
            if (minIndex != i) {
                int temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;
            }
        }
    }

}
