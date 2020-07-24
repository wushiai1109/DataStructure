package Backtracking回溯;

import java.util.*;

/**
 * @author Wushiai
 * @date 2020/4/9 22:05
 * @content 给定一个可包含重复数字的序列，返回所有不重复的全排列。
 * <p>
 * 示例:
 * <p>
 * 输入: [1,1,2]
 * 输出:
 * [
 * [1,1,2],
 * [1,2,1],
 * [2,1,1]
 * ]
 */
public class 全排列II47 {

    //暴力全排列set去重
//    private Set<List<Integer>> set = new HashSet<>();
//
//    public List<List<Integer>> permuteUnique(int[] nums) {
//        dfs(nums, 0);
//        List<List<Integer>> res = new ArrayList<>(set);
//        return res;
//    }
//
//    private void dfs(int[] nums, int cur) {
//        if (cur == nums.length) {
//            List<Integer> line = new ArrayList<>();
//            for (int i : nums)
//                line.add(i);
//            set.add(line);
//        }
//
//        for (int i = cur; i < nums.length; i++) {
//            swap(nums, cur, i);
//            dfs(nums, cur + 1);
//            swap(nums, cur, i);
//        }
//    }
//
//    private void swap(int nums[], int i, int j) {
//        int temp = nums[i];
//        nums[i] = nums[j];
//        nums[j] = temp;
//    }


    private List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        dfs(nums, 0);
        return res;
    }

    private void dfs(int[] nums, int index) {
        if (index == nums.length) {
            List<Integer> line = new ArrayList<>();
            for (int i : nums)
                line.add(i);
            res.add(line);
        }

        for (int i = index; i < nums.length; i++) {
            if (canSwap(nums, index, i)) {
                swap(nums, index, i);
                dfs(nums, index + 1);
                swap(nums, index, i);
            }
        }
    }

    private boolean canSwap(int nums[], int begin, int end) {
        for (int i = begin; i < end; i++)
            if (nums[i] == nums[end])
                return false;
        return true;
    }

    private void swap(int nums[], int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {

        int[] nums = {1, 1, 2};
        List<List<Integer>> res = (new 全排列II47()).permuteUnique(nums);
        for (List<Integer> list : res)
            System.out.println(list);
    }
}
