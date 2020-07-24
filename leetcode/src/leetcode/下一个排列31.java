package leetcode;

import java.util.Arrays;

/**
 * @ClassName leetcode.下一个排列31
 * @Description 实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。比n大
 * <p>
 * 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
 * <p>
 * 必须原地修改，只允许使用额外常数空间。
 * <p>
 * 以下是一些例子，输入位于左侧列，其相应输出位于右侧列。
 * 1,2,3 → 1,3,2
 * 3,2,1 → 1,2,3
 * 1,1,5 → 1,5,1
 * <p>
 * （给出一个整数n，要找重新组合后比n小，同时是组合后最大的数 例如 11，找不到 not  found， 132 为123）
 * @Author Bruce
 * @Date 2020/7/17 8:21 下午
 */
public class 下一个排列31 {
    public static void main(String[] args) {
        int [] nums = {1, 3, 2};
        new 下一个排列31().nextPermutation(nums);
    }
//    时间复杂度：O(n)，在最坏的情况下，只需要对整个数组进行两次扫描。
//    空间复杂度：O(1)，没有使用额外的空间，原地替换足以做到。

    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        //从后遍历，找到index为i的值，此值比下一 index=i+1 的值小 或者 i=0（此数组为升序数组）
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        if (i >= 0) {
            int j = nums.length - 1;
            //从后找到第一个小于等于nums[i]的值--nums[j]
            while (j >= 0 && nums[j] <= nums[i]) {
                j--;
            }
            swap(nums, i, j);
        }
        reverse(nums, i + 1);
        System.out.println(Arrays.toString(nums));
    }

    private void reverse(int[] nums, int start) {
        int i = start, j = nums.length - 1;
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}