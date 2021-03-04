import java.util.Arrays;

/**
 * @ClassName ShellSort
 * @Description
 * @Author Bruce
 * @Date 2021/1/9 下午9:24
 */
public class ShellSort {

    //希尔排序(shell)
    //1、按照不同步长对元素进行插入排序；
    //2、当刚开始元素很无序的时候，步长最大，所以插入排序的元素个数很少，速度很快；
    //3、当元素基本有序了，步长很小， 插入排序对于有序的序列效率很高；
    //4、所以，希尔排序的时间复杂度会比o(n^2)好一些
    //由于多次插入排序，我们知道一次插入排序是稳定的，不会改变相同元素的相对顺序，但在不同的插入排序过程中，相同的元素可能在各自的插入排序中移动，最后其稳定性就会被打乱；
    //5、不稳定的排序算法。
    public static void main(String[] args) {
        int[] arr = {6, 1, 5, 2, 3, 7, 4, 9, 8};
        new ShellSort().shellSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public void shellSort(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }
        int len = arr.length;
        int gap = len / 2;

        while (gap > 0) {
            for (int i = gap; i < len; i++) {
                int target = arr[i];
                int curIndex = i;
                while (curIndex >= gap && target < arr[curIndex - gap]) {
                    arr[curIndex] = arr[curIndex - gap];
                    curIndex -= gap;
                }
                arr[curIndex] = target;
            }
            System.out.println("增量为" + gap + "排序之后：" + Arrays.toString(arr));
            gap /= 2;
        }
    }


}
