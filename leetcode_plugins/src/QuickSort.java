import java.util.Arrays;

/**
 * @ClassName QuickSort
 * @Description
 * @Author Bruce
 * @Date 2020/10/9 6:28 下午
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] nums = {1, 5, 2, 3, 7, 4, 9, 8};
        new QuickSort().quickSort(nums, 0, nums.length - 1);
//        new QuickSort().quickSort1(nums,0,nums.length-1);
        System.out.println(Arrays.toString(nums));
    }

    //Time Complexity:O(nlogn)
    //Space Complexity：O(logn)
    public void quickSort(int[] array, int begin, int end) {
        if (end <= begin) {
            return;
        }
        int pivot = partition(array, begin, end);
        quickSort(array, begin, pivot - 1);
        quickSort(array, pivot + 1, end);
    }

    //partition就是x选到pivot标杆的位置，且把所有小于pivot的元素都挪到pivot左边，大于pivot都挪到pivot右边
    private int partition(int[] array, int begin, int end) {
        //pivot: 标杆位置, counter: 小于pivot的元素的个数
        int pivot = end, counter = begin;
        for (int i = begin; i < end; i++) {
            if (array[i] < array[pivot]) {
                swap(array, i, counter);
                counter++;
            }
        }
        swap(array, pivot, counter);
        return counter;
    }

    public void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

}
