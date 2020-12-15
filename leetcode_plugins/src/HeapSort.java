import java.util.Arrays;

/**
 * @ClassName HeapSort
 * @Description
 * @Author Bruce
 * @Date 2020/11/30 11:51 下午
 */
public class HeapSort {

    public static void main(String[] args) {
        int[] array = {1, 5, 2, 3, 7, 4, 9, 8};
        new HeapSort().heapSort(array);
        System.out.println(Arrays.toString(array));
    }

    public void heapSort(int[] array) {
        if (array.length == 0) {
            return;
        }

        int length = array.length;
        for (int i = length / 2 - 1; i >= 0; i--) {
            heapify(array, length, i);
        }

        for (int i = length - 1; i >= 0; i--) {
            swap(array, 0, i);
            heapify(array, i, 0);
        }

    }

    public void heapify(int[] array, int length, int i) {
        int left = 2 * i + 1, right = 2 * i + 2;
        int largest = i;
        if (left < length && array[left] > array[largest]) {
            largest = left;
        }
        if (right < length && array[right] > array[largest]) {
            largest = right;
        }
        if (largest != i) {
            swap(array, i, largest);
            heapify(array, length, largest);
        }
    }

    public static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

}
