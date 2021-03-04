/**
 * @ClassName JZ6旋转数组的最小数字
 * @Description 本题知识点： 二分
 * 题目描述
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
 * NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 * 示例1
 * 输入
 * [3,4,5,1,2]
 * 返回值
 * 1
 * @Author Bruce
 * @Date 2021/2/12 下午11:32
 */
public class JZ6旋转数组的最小数字 {
    public int minNumberInRotateArray(int[] array) {
        if (array.length == 0) {
            return 0;
        }
        int start = 0;
        int end = array.length - 1;
        while (start <= end) {
            if (end - start == 1) {
                return array[end];
            }
            int mid = start + ((end - start) >> 1);
            if (array[mid] >= array[start]) {
                start = mid;
            }
            if (array[mid] <= array[end]) {
                end = mid;
            }
        }
        return array[start];
    }
}
