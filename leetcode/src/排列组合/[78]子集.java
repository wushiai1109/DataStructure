package 排列组合;//给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
//
// 说明：解集不能包含重复的子集。 
//
// 示例: 
//
// 输入: nums = [1,2,3]
//输出:
//[
//  [3],
//  [1],
//  [2],
//  [1,2,3],
//  [1,3],
//  [2,3],
//  [1,2],
//  []
//] 
// Related Topics 位运算 数组 回溯算法 
// 👍 749 👎 0


import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class 子集78 {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println(new 子集78().subsets(nums));
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        backtrack(0, nums, res, new ArrayList<Integer>());
        return res;
    }

    private void backtrack(int index, int[] nums, List<List<Integer>> res, ArrayList<Integer> tmp) {
        //terminator
        if (index == nums.length) {
            res.add(new ArrayList<>(tmp));
            return;
        }

        //no pick the number at this index
        backtrack(index + 1, nums, res, tmp);

        tmp.add(nums[index]);
        //pick the number at this index
        backtrack(index + 1, nums, res, tmp);

        //reverse the current state
        tmp.remove(tmp.size() - 1);
    }

    //方案2
    private void backtrack2(int index, int[] nums, List<List<Integer>> res, ArrayList<Integer> tmp) {
        res.add(new ArrayList<>(tmp));
        for (int j = index; j < nums.length; j++) {
            tmp.add(nums[j]);
            backtrack(j + 1, nums, res, tmp);
            tmp.remove(tmp.size() - 1);
        }
    }


}
//leetcode submit region end(Prohibit modification and deletion)
