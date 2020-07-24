package leetcode;

/**
 * @author Wushiai
 * @date 2020/1/30 10:43
 * @content 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。
 * 输入一个数组,求出这个数组中的逆序对的总数P
 * 输入描述:
 * 题目保证输入的数组中没有的相同的数字
 * 示例1
 * 输入
 * 1,2,3,4,5,6,7,0
 * 输出
 * 7
 */
public class 数组中的逆序对 {

    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5, 6, 7, 0};
        System.out.println(new 数组中的逆序对().countReversePairs(arr));
    }

    //合并排序逆序
    public int countReversePairs(int[] arr) {
        if (arr == null || arr.length < 2)
            return 0;
        return mergeSort(arr, 0, arr.length - 1);
    }

    //合并排序
    public int mergeSort(int[] arr, int left, int right) {
        if (left == right)
            return 0;
        int mid = left + ((right - left) >> 1);
        int leftNum = mergeSort(arr, left, mid);
        int rightNum = mergeSort(arr, mid + 1, right);
        int curNum = merge(arr, left, mid, right);
        return leftNum + rightNum + curNum;
    }

    //合并
    public int merge(int[] arr, int left, int mid, int right) {
        int[] array = new int[right - left + 1];
        int i = 0, p1 = left, p2 = mid + 1, count = 0;
        while (p1 <= mid && p2 <= right) {
            if (arr[p1] > arr[p2]) {
                count += right - p2 + 1;
                array[i++] = arr[p1++];
            } else
                array[i++] = arr[p2++];
        }
        while (p1 <= mid)
            array[i++] = arr[p1++];
        while (p2 <= right)
            array[i++] = arr[p2++];
        for (int anArray : array)
            arr[left++] = anArray;
        return count;
    }


    //暴力解法
    public int countReversePairs1(int[] array) {
        if (array == null || array.length < 2) {
            return 0;
        }
        int count = 0;
        for (int i = 0; i < array.length - 1; i++)
            for (int j = i + 1; j < array.length; j++)
                if (array[i] > array[j])
                    count++;
        return count;
    }

}
