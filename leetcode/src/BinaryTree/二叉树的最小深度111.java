package BinaryTree;

/**
 * @author Wushiai
 * @date 2020/4/2 20:18
 * @content 给定一个二叉树，找出其最小深度。
 * <p>
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 * <p>
 * 说明: 叶子节点是指没有子节点的节点。
 * <p>
 * 示例:
 * <p>
 * 给定二叉树 [3,9,20,null,null,15,7],
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回它的最小深度  2.
 */
public class 二叉树的最小深度111 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int x) {
            this.val = x;
        }
    }


    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        if (root.left == null && root.right == null) {
            return 1;
        }

        int res = Integer.MAX_VALUE;
        if (root.left != null) {
            res = Math.min(res, minDepth(root.left) + 1);
        }
        if (root.right != null) {
            res = Math.min(res, minDepth(root.right) + 1);
        }

        return res;
    }
}
