package BinaryTree;

/**
 * @author Wushiai
 * @date 2020/4/4 10:43
 * @content 计算给定二叉树的所有左叶子之和。
 * <p>
 * 示例：
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * <p>
 * 在这个二叉树中，有两个左叶子，分别是 9 和 15，所以返回 24
 */
public class 左叶子之和404 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int x) {
            this.val = x;
        }
    }

    // Recursion
/// Don't use class member variable
/// Time Complexity: O(n)
/// Space Complexity: O(h)
//    public int sumOfLeftLeaves(TreeNode root) {
//        if (root == null)
//            return 0;
//        return sumOfLeftLeaves(root, false);
//    }
//
//    private int sumOfLeftLeaves(TreeNode root, boolean isLeft) {
//        if (root.left == null && root.right == null) {
//            if (isLeft)
//                return root.val;
//            return 0;
//        }
//        int sum = 0;
//        if (root.left != null)
//            sum += sumOfLeftLeaves(root.left, true);
//        if (root.right != null)
//            sum += sumOfLeftLeaves(root.right, false);
//        return sum;
//    }


    private int sum = 0;

    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null)
            return 0;
        sumOfLeftLeaves(root, false);
        return sum;
    }

    private void sumOfLeftLeaves(TreeNode root, boolean isLeft) {
        if (root.left == null && root.right == null)
            if (isLeft)
                sum += root.val;

        if (root.left != null)
            sumOfLeftLeaves(root.left, true);
        if (root.right != null)
            sumOfLeftLeaves(root.right, false);
    }

}
