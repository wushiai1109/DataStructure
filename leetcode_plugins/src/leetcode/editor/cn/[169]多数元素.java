package leetcode.editor.cn;//给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
//
// 你可以假设数组是非空的，并且给定的数组总是存在多数元素。 
//
// 
//
// 示例 1: 
//
// 输入: [3,2,3]
//输出: 3 
//
// 示例 2: 
//
// 输入: [2,2,1,1,1,2,2]
//输出: 2
// 
// Related Topics 位运算 数组 分治算法 
// 👍 734 👎 0


import java.util.HashMap;

//leetcode submit region begin(Prohibit modification and deletion)
class 多数元素 {
    public int majorityElement(int[] nums) {
        int count = 0;
        Integer res = null;
        for (int num : nums) {
            if (count == 0) {
                res = num;
            }
            count += (num == res) ? 1 : -1;
        }

        return res;
    }
    // public int majorityElement(int[] nums) {
    //     int len = nums.length;
    //     HashMap<Integer, Integer> hash = new HashMap<>();
    //     for (int num : nums) {
    //         hash.put(num, hash.getOrDefault(num, 0) + 1);
    //         if (hash.get(num) > len / 2) {
    //             return num;
    //         }
    //     }
    //     throw new IllegalArgumentException("this nums without an number is big than half of nums's length");
    // }
}
//leetcode submit region end(Prohibit modification and deletion)
