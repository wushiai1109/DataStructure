package root;

/**
 * @ClassName 二叉搜索树的最小绝对差530
 * @Description 给你一棵所有节点为非负值的二叉搜索树，请你计算树中任意两节点的差的绝对值的最小值。
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * 输入：
 * <p>
 * 1
 * \
 * 3
 * /
 * 2
 * <p>
 * 输出：
 * 1
 * <p>
 * 解释：
 * 最小绝对差为 1，其中 2 和 1 的差的绝对值为 1（或者 2 和 3）。
 *  
 * <p>
 * 提示：
 * <p>
 * 树中至少有 2 个节点。
 * 本题与 783 https://leetcode-cn.com/problems/minimum-distance-between-bst-nodes/ 相同
 * @Author Bruce
 * @Date 2020/5/16 2:08 下午
 */
public class 二叉搜索树的最小绝对差530 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    int res = Integer.MAX_VALUE;

    public int getMinimumDifference(TreeNode root) {
        getMinimumDifference(root, res);
        return res;
    }

    private int getMinimumDifference(TreeNode root, int min) {
        if (root != null) {
            min = getMinimumDifference(root.left, min);
            res = Math.min(Math.abs(min - root.val), res);
            min = getMinimumDifference(root.right, root.val);
        }
        return min;
    }
}
