package Array;

/**
 * @author Wushiai
 * @date 2020/2/23 9:25
 * @content 给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 * <p>
 * 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 * <p>
 * 注意:
 * 不能使用代码库中的排序函数来解决这道题。
 * <p>
 * 示例:
 * <p>
 * 输入: [2,0,2,1,1,0]
 * 输出: [0,0,1,1,2,2]
 */
public class 颜色分类75__三路快排 {

    public static void main(String[] args) {

        int[] nums = {2, 2, 2, 1, 1, 0};
        (new 颜色分类75__三路快排()).sortColors(nums);
        printArr(nums);
    }

    public static void printArr(int[] nums) {
        for (int num : nums)
            System.out.print(num + " ");
        System.out.println();
    }

//    //方法1
//    //时间复杂度O(n)
//    //空间复杂度O(k),k为元素的取值范围，因为是常数，所以可以直接说成是O（1）
//    public void sortColors(int[] nums) {
//        int[] count = {0, 0, 0};
//        for (int i = 0; i < nums.length; i++) {
//            assert (nums[i] >= 0 && nums[i] <= 2);
//            count[nums[i]]++;
//        }
//
//        int index = 0;
//        for (int i = 0; i < count[0]; i++)
//            nums[index++] = 0;
//        for (int i = 0; i < count[1]; i++)
//            nums[index++] = 1;
//        for (int i = 0; i < count[2]; i++)
//            nums[index++] = 2;
//    }

    //方法2:三路快速排序
    //时间复杂度O(n)
    //空间复杂度O(1)
    //遍历一遍
    public void sortColors(int[] nums) {
        int zero = -1;          // [0...zero] == 0
        int two = nums.length;  // [two...n-1] == 2
        for (int i = 0; i < two; ) {
            if (nums[i] == 1)
                i++;
            else if (nums[i] == 2)
                swap(nums, i, --two);
            else { // nums[i] == 0
                assert nums[i] == 0;
                swap(nums, ++zero, i++);
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}
