package Array;

import java.util.ArrayList;

/**
 * @author Wushiai
 * @date 2020/2/21 20:14
 * @content 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * <p>
 * 示例:
 * <p>
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * 说明:
 * 必须在原数组上操作，不能拷贝额外的数组。
 * 尽量减少操作次数。
 */
public class 移动零283 {

    public static void main(String[] args) {
        int[] arr = {0, 1, 0, 3, 12};
        (new 移动零283()).moveZeroes(arr);
        printArr(arr);
    }

    private static void printArr(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

//    //方法1
//    //时间复杂度：O(n)
//    //时间复杂度：O(n)
//    public void moveZeroes(int[] nums) {
//
//        ArrayList<Integer> nonZeroElements = new ArrayList<>();
//
//        // 将所有不是0的元素移到新的数组
//        for (int i = 0; i < nums.length; i++) {
//            if (nums[i] != 0) {
//                nonZeroElements.add(nums[i]);
//            }
//        }
//
//        // 将所有不是0的元素移到原数组中
//        for (int i = 0; i < nonZeroElements.size(); i++)
//            nums[i] = nonZeroElements.get(i);
//
//        // 将原素组中超过nonZeroElements数组的长度的元素设为0
//        for (int i = nonZeroElements.size(); i < nums.length; i++)
//            nums[i] = 0;
//    }

//    //方法2
//    //时间复杂度：O(n)
//    //时间复杂度：O(1)
//    public void moveZeroes(int[] nums) {
//        //将nums数组中部位非0元素填补到nums中
//        int k = 0;
//        for (int i = 0; i < nums.length; i++)
//            if (nums[i] != 0)
//                nums[k++] = nums[i];
//
//        // 将nums数组中其他空间设为元素0
//        for (int i = k; i < nums.length; i++)
//            nums[i] = 0;
//    }


    //方法3
    //时间复杂度：O(n)
    //时间复杂度：O(1)
    public void moveZeroes(int[] nums) {

        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                swap(nums, k++, i);
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

//    //方法4
//    //时间复杂度：O(n)
//    //时间复杂度：O(1)
//    public void moveZeroes(int[] nums) {
//
//        int k = 0;
//        for (int i = 0; i < nums.length; i++)
//            if (nums[i] != 0)
//                if (k != i)
//                    swap(nums, k++, i);
//                else
//                    k++;
//    }
//
//    private void swap(int[] nums, int i, int j) {
//        int t = nums[i];
//        nums[i] = nums[j];
//        nums[j] = t;
//    }

}
