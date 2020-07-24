package SetMap;

import java.util.HashSet;

/**
 * @author Wushiai
 * @date 2020/3/9 17:06
 * @content 给定一个整数数组，判断是否存在重复元素。
 *
 * 如果任何值在数组中出现至少两次，函数返回 true。如果数组中每个元素都不相同，则返回 false。
 *
 * 示例 1:
 *
 * 输入: [1,2,3,1]
 * 输出: true
 * 示例 2:
 *
 * 输入: [1,2,3,4]
 * 输出: false
 * 示例 3:
 *
 * 输入: [1,1,1,3,3,4,3,2,4,2]
 * 输出: true
 */
public class 存在重复元素217 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};
        System.out.println(new 存在重复元素217().containsDuplicate(nums));
    }

    public boolean containsDuplicate(int[] nums) {
        if (nums == null || nums.length <= 1)
            return false;

        HashSet<Integer> record = new HashSet<Integer>();
        for(int i=0; i<nums.length;i++){
            if(record.contains(nums[i]))
                return true;
            record.add(nums[i]);
        }
        return false;
    }
}
