/**
 * @ClassName JZ38二叉树的深度
 * @Description 树
 * 题目描述
 * 输入一棵二叉树，求该树的深度。从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。
 * @Author Bruce
 * @Date 2020/7/16 12:50 下午
 */
public class JZ38二叉树的深度 {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

    public int TreeDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(TreeDepth(root.left) + 1, TreeDepth(root.right) + 1);
    }
}
