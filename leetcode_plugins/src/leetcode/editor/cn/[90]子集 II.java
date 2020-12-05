package leetcode.editor.cn;//给定一个可能包含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
//
// 说明：解集不能包含重复的子集。 
//
// 示例: 
//
// 输入: [1,2,2]
//输出:
//[
//  [2],
//  [1],
//  [1,2,2],
//  [2,2],
//  [1,2],
//  []
//] 
// Related Topics 数组 回溯算法 
// 👍 349 👎 0


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class 子集two {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null) {
            return res;
        }
        Arrays.sort(nums);
        backtrack(0, nums, res, new ArrayList<Integer>());
        return res;
    }

    private void backtrack(int index, int[] nums, List<List<Integer>> res, ArrayList<Integer> tmp) {

        if (index == nums.length) {
            res.add(new ArrayList<>(tmp));
            return;
        }

        for (int i = index; i < nums.length; i++) {
            //和上个数字相等就跳过
            if (i > index && nums[i] == nums[i - 1]) {
                continue;
            }

            tmp.add(nums[i]);
            backtrack(i + 1, nums, res, tmp);

            tmp.remove(tmp.size() - 1);
        }

//        //terminator
//        if (index == nums.length) {
//            res.add(new ArrayList<>(tmp));
//            return;
//        }
//
//        //no pick the number at this index
//        backtrack(index + 1, nums, res, tmp);
//
//        tmp.add(nums[index]);
//        //pick the number at this index
//        backtrack(index + 1, nums, res, tmp);
//
//        //reverse the current state
//        tmp.remove(tmp.size() - 1);
//
////        res.add(new ArrayList<>(tmp));
////        for (int j = index; j < nums.length; j++) {
////            tmp.add(nums[j]);
////            backtrack(j + 1, nums, res, tmp);
////            tmp.remove(tmp.size() - 1);
////        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
