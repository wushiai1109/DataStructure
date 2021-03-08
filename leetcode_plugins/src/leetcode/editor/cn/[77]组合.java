package leetcode.editor.cn;//给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
//
// 示例: 
//
// 输入: n = 4, k = 2
//输出:
//[
//  [2,4],
//  [3,4],
//  [2,3],
//  [1,2],
//  [1,3],
//  [1,4],
//] 
// Related Topics 回溯算法 
// 👍 511 👎 0


import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class 组合77 {
    public static void main(String[] args) {
        System.out.println(new 组合77().combine(4, 2));
    }

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        generateCombine(n, k, 1, res, new ArrayList<>());
        return res;
    }

    public void generateCombine(int n, int k, int index, List<List<Integer>> res, List<Integer> list) {
        if (k == 0) {
            res.add(new ArrayList<>(list));
            return;
        }

        for (int i = index; i <= n - k + 1; i++) {
            list.add(i);
            generateCombine(n, k - 1, i + 1, res, list);
            list.remove(list.size() - 1);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
