/**
 * @ClassName mergeSort
 * @Description
 * @Author Bruce
 * @Date 2020/10/10 8:45 下午
 */
public class mergeSort {
    public static void mergeSort(int[] array, int left, int right) {
        if (right <= left) {
            return;
        }
        int mid = left + (right - left) >> 1;

        mergeSort(array, left, mid);
        mergeSort(array, mid + 1, right);
        merge(array, left, mid, right);
    }

    private static void merge(int[] array, int left, int mid, int right) {
        //中间数组
        int[] temp = new int[right - left + 1];
        int i = left, j = mid + 1, k = 0;

        while (i <= mid && j <= right) {
            temp[k++] = array[i] <= array[j] ? array[i++] : array[j++];
        }

        while (i <= mid) {
            temp[k++] = array[i++];
        }
        while (j <= right) {
            temp[k++] = array[j++];
        }

//        for (int l = 0; l < temp.length; l++) {
//            array[left + l] = temp[l];
//        }
        //src表示源数组
        //srcPos表示源数组中拷贝元素的起始位置。
        //dest表示目标数组
        //destPos表示拷贝到目标数组的起始位置
        //length表示拷贝元素的个数
        System.arraycopy(temp, 0, array, left, temp.length);
    }
}
