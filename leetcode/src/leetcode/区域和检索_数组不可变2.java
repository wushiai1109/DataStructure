package leetcode;

/**
 * @author Wushiai
 * @date 2020/2/8 10:17
 * @content 给定一个整数数组  nums，求出数组从索引 i 到 j  (i ≤ j) 范围内元素的总和，包含 i,  j 两点。
 * <p>
 * 示例：
 * <p>
 * 给定 nums = [-2, 0, 3, -5, 2, -1]，求和函数为 sumRange()
 * <p>
 * sumRange(0, 2) -> 1
 * sumRange(2, 5) -> -1
 * sumRange(0, 5) -> -3
 * 说明:
 * <p>
 * 你可以假设数组不可变。
 * 会多次调用 sumRange 方法。
 */
public class 区域和检索_数组不可变2 {

    class NumArray {
        //sum[i]存储前i个元素和，sum[0]=0,sum[i]存储nums[0...i-1]的和
        private int[] sum;

        public NumArray(int[] nums) {
            sum = new int[nums.length + 1];
            sum[0] = 0;
            for (int i = 0; i < sum.length; i++) {
                sum[i] = sum[i] + nums[i];
            }
        }

        public int sumRange(int i, int j) {
            return sum[j + 1] - sum[i];
        }
    }

}
