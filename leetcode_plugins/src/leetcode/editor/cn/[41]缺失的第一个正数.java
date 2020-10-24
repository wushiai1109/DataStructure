package leetcode.editor.cn;//给你一个未排序的整数数组，请你找出其中没有出现的最小的正整数。
//
// 
//
// 示例 1: 
//
// 输入: [1,2,0]
//输出: 3
// 
//
// 示例 2: 
//
// 输入: [3,4,-1,1]
//输出: 2
// 
//
// 示例 3: 
//
// 输入: [7,8,9,11,12]
//输出: 1
// 
//
// 
//
// 提示： 
//
// 你的算法的时间复杂度应为O(n)，并且只能使用常数级别的额外空间。 
// Related Topics 数组 
// 👍 820 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class 缺失的第一个正数41 {
    //时间复杂度：O(N)，其中N是数组的长度。
    //空间复杂度：O(1)

    public int firstMissingPositive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 1;
        }
        int res = nums.length;
        //长度为N的数组，其中没有出现的最小正整数只能在[1,N+1]中
        //如果[1,N]都出现了，那么答案是N+1，否则答案是[1,N]中没有出现的最小正整数
        //我们将数组中所有小于等于0的数修改为N+1
        for (int i = 0; i < res; i++) {
            if (nums[i] <= 0) {
                nums[i] = res + 1;
            }
        }
        //遍历数组中的每一个数x，它可能已经被打了标记，因此原本对应的数为∣x∣。
        // 如果∣x∣∈[1,N]，那么我们给数组中的第∣x∣−1个位置的数添加一个负号。（1-->num[0]）
        // 注意如果它已经有负号，不需要重复添加。
        for (int i = 0; i < res; ++i) {
            int num = Math.abs(nums[i]);
            if (num <= res) {
                nums[num - 1] = -Math.abs(nums[num - 1]);
            }
        }
        for (int i = 0; i < res; ++i) {
            if (nums[i] > 0) {
                return i + 1;
            }
        }
        return res + 1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
