package SetMap;

import java.util.Arrays;

/**
 * @author Wushiai
 * @date 2020/1/24 10:48
 * @content
 */
public class 最接近的三数之和16 {
    /**
     * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
     * 例如，给定数组 nums = [-1，2，1，-4], 和 target = 1.
     * 与 target 最接近的三个数的和为 2. (-1 + 2 + 1 = 2).
     */
    public static void main(String[] args) {
        int[] nums = {-1, 2, 1, -4};
        System.out.println(new 最接近的三数之和16().threeSumClosest(nums, 1));
    }

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int sunNum = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length - 2; i++) {
            int l = i + 1, r = nums.length - 1;
            while (l < r) {
                int threeSum = nums[i] + nums[l] + nums[r];
                //Math.abs为绝对值
                if (Math.abs(threeSum - target) < Math.abs(sunNum - target))
                    sunNum = threeSum;
                if (threeSum > target)
                    r--;
                else if (threeSum < target)
                    l++;
                else
                    //等于target
                    return target;
            }
        }
        return sunNum;
    }
}
