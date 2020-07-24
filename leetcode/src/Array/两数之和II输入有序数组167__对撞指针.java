package Array;

import java.util.Arrays;

/**
 * @author Wushiai
 * @date 2020/2/25 9:32
 * @content 给定一个已按照升序排列 的有序数组，找到两个数使得它们相加之和等于目标数。
 * <p>
 * 函数应该返回这两个下标值 index1 和 index2，其中 index1 必须小于 index2。
 * <p>
 * 说明:
 * <p>
 * 返回的下标值（index1 和 index2）不是从零开始的。
 * 你可以假设每个输入只对应唯一的答案，而且你不可以重复使用相同的元素。
 * 示例:
 * <p>
 * 输入: numbers = [2, 7, 11, 15], target = 9
 * 输出: [1,2]
 * 解释: 2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。
 */
public class 两数之和II输入有序数组167__对撞指针 {

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        System.out.println(Arrays.toString(new 两数之和II输入有序数组167__对撞指针().twoSum(nums, target)));
    }

//    //1.暴力解法，双层遍历O(n^2)
//    // Time Complexity: O(n^2)
//    // Space Complexity: O(1)
//    public int[] twoSum(int[] numbers, int target) {
//
//        if (numbers.length < 2)
//            throw new IllegalArgumentException("Illegal argument numbers");
//        for (int i = 0; i < numbers.length - 1; i++)
//            for (int j = i + 1; j < numbers.length; j++)
//                if (numbers[i] + numbers[j] == target) {
//                    return new int[]{i + 1, j + 1};
//                }
//        throw new IllegalStateException("The input has no solution");
//    }


//    //方法2，二分搜索
//    // Binary Search
//    // Time Complexity: O(nlogn)
//    // Space Complexity: O(1)
//    public int[] twoSum(int[] numbers, int target) {
//
//        if (numbers.length < 2)
//            throw new IllegalArgumentException("Illegal argument numbers");
//
//        for (int i = 0; i < numbers.length - 1; i++) {
//            int j = binarySearch(numbers, i + 1, numbers.length - 1, target - numbers[i]);
//            if (j != -1) {
//                int[] res = {i + 1, j + 1};
//                return res;
//            }
//        }
//        throw new IllegalStateException("The input has no solution");
//    }
//
//    private int binarySearch(int[] nums, int l, int r, int target) {
//        if (l < 0 || l > nums.length)
//            throw new IllegalArgumentException("l is out of bound");
//        if (r < 0 || r > nums.length)
//            throw new IllegalArgumentException("r is out of bound");
//        while (l <= r) {
//            int mid = l + (r - l) / 2;
//            if (nums[mid] == target)
//                return mid;
//            if (target > nums[mid])
//                l = mid + 1;
//            else
//                r = mid - 1;
//        }
//        return -1;
//    }


    // Two Pointers
    // Time Complexity: O(n)
    // Space Complexity: O(1)
    public int[] twoSum(int[] numbers, int target) {
        if (numbers.length < 2)
            throw new IllegalArgumentException("Illegal argument numbers");
        int l = 0, r = numbers.length - 1;
        while (l < r) {
            if (numbers[l] + numbers[r] == target) {
                int[] res = {l + 1, r + 1};
                return res;
            } else if (numbers[l] + numbers[r] < target) {
                l++;
            } else {// numbers[l] + numbers[r] > target
                r--;
            }
        }

        throw new IllegalStateException("The input has no solution");
    }

}
