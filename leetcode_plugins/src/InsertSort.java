import java.util.Arrays;

/**
 * @ClassName InsertSort
 * @Description
 * @Author Bruce
 * @Date 2021/1/9 下午9:14
 */
public class InsertSort {

    //插入排序
    //1、已经有序的小序列的基础上，一次插入一个元素；
    //2、想要插入的元素和已经有序的最大者开始比起，如果比它大则直接插入在其后面，否则一直往前找直到找到它该插入的位置；
    //3、如果碰见一个和插入元素相等的，那么插入元素把想插入的元素放在相等元素的后面；
    //4、相等元素的前后顺序没有改变；
    //5、稳定排序算法。
    public static void main(String[] args) {
        int[] arr = {6, 1, 5, 2, 3, 7, 4, 9, 8};
        new InsertSort().insertSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    //Time Complexity:O(n^2)
    //Space Complexity：O(1)
    public void insertSort(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }
        int len = arr.length;

        for (int i = 1; i < len; i++) {
            int target = arr[i];

            int curIndex = i;
            while (curIndex > 0 && target < arr[curIndex - 1]) {
                arr[curIndex] = arr[curIndex - 1];
                curIndex--;
            }

            arr[curIndex] = target;
        }
    }


}
