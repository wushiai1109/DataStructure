package root;

/**
 * @ClassName 检查平衡性面试题
 * @Description 实现一个函数，检查二叉树是否平衡。在这个问题中，平衡树的定义如下：任意一个节点，其两棵子树的高度差不超过 1。
 * <p>
 * <p>
 * 示例 1:
 * 给定二叉树 [3,9,20,null,null,15,7]
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回 true 。
 * 示例 2:
 * 给定二叉树 [1,2,2,3,3,null,null,4,4]
 * 1
 * / \
 * 2   2
 * / \
 * 3   3
 * / \
 * 4   4
 * 返回 false 。
 * @Author Bruce
 * @Date 2020/5/16 1:50 下午
 */
public class 检查平衡性面试题 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean isBalanced(TreeNode root) {
        if (root==null)
            return true;

        return Math.abs(depth(root.left) - depth(root.right)) < 2  && (isBalanced(root.left) && isBalanced(root.right));
    }

    private int depth(TreeNode root){
        if (root==null)
            return 0;
        return Math.max(depth(root.left), depth(root.right)) + 1;
    }
}
