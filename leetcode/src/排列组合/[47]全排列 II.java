package 排列组合;//给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,1,2]
//输出：
//[[1,1,2],
// [1,2,1],
// [2,1,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3]
//输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 8 
// -10 <= nums[i] <= 10 
// 
// Related Topics 回溯算法 
// 👍 614 👎 0

import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class 全排列two47 {
    private List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        dfs(nums, 0);
        return res;
    }

    private void dfs(int[] nums, int index) {
        if (index == nums.length) {
            List<Integer> list = new ArrayList<>();
            for (int i : nums) {
                list.add(i);
            }
            res.add(list);
        } else {
            for (int i = index; i < nums.length; i++) {
                if (canSwap(nums, index, i)) {
                    swap(nums, index, i);
                    dfs(nums, index + 1);
                    swap(nums, index, i);
                }
            }
        }
    }

    private boolean canSwap(int[] nums, int begin, int end) {
        for (int i = begin; i < end; i++) {
            if (nums[i] == nums[end]) {
                return false;
            }
        }
        return true;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

//方案2
//    public List<List<Integer>> permuteUnique(int[] nums) {
//        if(nums == null || nums.length == 0){
//            return new ArrayList<>();
//        }
//        Set<List<Integer>> set = new HashSet<>();
//        generatePermuteUnique(set,nums,0);
//        return new ArrayList<>(set);
//    }
//    private void generatePermuteUnique(Set<List<Integer>> set,int []nums,int index){
//        if(index == nums.length){
//            List<Integer> list = new ArrayList<>();
//            for(int i : nums){
//                list.add(i);
//            }
//            set.add(list);
//            return;
//        }
//        for (int i = index; i < nums.length; i++) {
//            swap(nums, i, index);
//            generatePermuteUnique(set, nums, index + 1);
//            swap(nums, i, index);
//        }
//    }
//    private void swap(int[] nums, int i, int j) {
//        int t = nums[i];
//        nums[i] = nums[j];
//        nums[j] = t;
//    }
}
//leetcode submit region end(Prohibit modification and deletion)
