/**
 * @ClassName QuickSort
 * @Description
 * @Author Bruce
 * @Date 2020/10/9 6:28 下午
 */
public class QuickSort {
    public static void quickSort(int[] array, int begin, int end) {
        if (end <= begin) {
            return;
        }
        int pivot = partition(array, begin, end);
    }

    //partition就是x选到pivot标杆的位置，且把所有小于pivot的元素都挪到pivot左边，大于pivot都挪到pivot右边
    private static int partition(int[] array, int begin, int end) {
        //pivot: 标杆位置, counter: 小于pivot的元素的个数
        int pivot = end, counter = begin;
        for (int i = begin; i < end; i++) {
            if (array[i] < array[pivot]) {
                int temp = array[counter];
                array[counter] = array[i];
                array[i] = temp;
                counter++;
            }
        }
        int temp = array[pivot];
        array[pivot] = array[counter];
        array[counter] = temp;
        return counter;
    }
}
