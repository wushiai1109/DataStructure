package BinaryTree;

/**
 * @author Wushiai
 * @date 2020/4/6 13:29
 * @content 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 * <p>
 * 假设一个二叉搜索树具有如下特征：
 * <p>
 * 节点的左子树只包含小于当前节点的数。
 * 节点的右子树只包含大于当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 * 示例 1:
 * <p>
 * 输入:
 * 2
 * / \
 * 1   3
 * 输出: true
 * 示例 2:
 * <p>
 * 输入:
 * 5
 * / \
 * 1   4
 *      / \
 *     3   6
 * 输出: false
 * 解释: 输入为: [5,1,4,null,null,3,6]。
 *      根节点的值为 5 ，但是其右子节点值为 4 。
 */
public class 验证二叉搜索树98 {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int x) {
            this.val = x;
        }
    }

    /// Recursive test
/// Time Complexity: O(n)
/// Space Complexity: O(h)
    public boolean isValidBST(TreeNode root) {

        return isValidBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }


    private boolean isValidBST(TreeNode node, int min, int max) {

        if (node == null) {
            return true;
        }

        if (node.val < min || node.val > max) {
            return false;
        }

        if (node.left != null && node.left.val >= node.val) {
            return false;
        }

        if (node.right != null && node.right.val <= node.val) {
            return false;
        }

        return isValidBST(node.left, min, node.val - 1)
                && isValidBST(node.right, node.val + 1, max);
    }

    public static void main(String[] args) {

        System.out.println(Integer.MIN_VALUE);
        TreeNode root = new TreeNode(-2147483648);
        root.left = new TreeNode(-2147483648);

        System.out.println((new 验证二叉搜索树98()).isValidBST(root));
    }

}
