package Array;

/**
 * @author Wushiai
 * @date 2020/2/22 16:27
 * @content 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素最多出现两次，返回移除后数组的新长度。
 * <p>
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 * <p>
 * 示例 1:
 * <p>
 * 给定 nums = [1,1,1,2,2,3],
 * <p>
 * 函数应返回新长度 length = 5, 并且原数组的前五个元素被修改为 1, 1, 2, 2, 3 。
 * <p>
 * 你不需要考虑数组中超出新长度后面的元素。
 * 示例 2:
 * <p>
 * 给定 nums = [0,0,1,1,1,1,2,3,3],
 * <p>
 * 函数应返回新长度 length = 7, 并且原数组的前五个元素被修改为 0, 0, 1, 1, 2, 3, 3 。
 * <p>
 * 你不需要考虑数组中超出新长度后面的元素。
 */
public class 删除排序数组中的重复项II80 {
    public static void main(String[] args) {
        int[] nums = {0, 0, 1, 1, 1, 1, 2, 3, 3};
        System.out.println(new 删除排序数组中的重复项II80().removeDuplicates(nums));
    }

    // Time Complexity:  O(n)
    // Space Complexity: O(1)
    public int removeDuplicates(int[] nums) {

        if (nums.length == 0 || nums.length == 1 || nums.length == 2) {
            return nums.length;
        }
        int i = 0, j = 0, index = 0;
        while (i < nums.length) {
            if (nums[j] == nums[i]) {
                ++index;
                if (index == 2) {
                    j++;
                    nums[j] = nums[i];
                    i++;
                } else {
                    i++;
                }
            } else {
                index = 1;
                j++;
                nums[j] = nums[i];
                i++;
            }
        }
        return ++j;
    }
}
