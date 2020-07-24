package BinaryTree;

/**
 * @author Wushiai
 * @date 2020/4/3 23:13
 * @content 给出一个完全二叉树，求出该树的节点个数。
 * <p>
 * 说明：
 * <p>
 * 完全二叉树的定义如下：在完全二叉树中，除了最底层节点可能没填满外，其余每层节点数都达到最大值，并且最下面一层的节点都集中在该层最左边的若干位置。若最底层为第 h 层，则该层包含 1~ 2h 个节点。
 * <p>
 * 示例:
 * <p>
 * 输入:
 * 1
 * / \
 * 2   3
 * / \  /
 * 4  5 6
 * <p>
 * 输出: 6
 */
public class 完全二叉树的节点个数222 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int x) {
            this.val = x;
        }
    }

//    //O(n)
//    public int countNodes(TreeNode root) {
//        return root == null ? 0 : countNodes(root.left) + countNodes(root.right) + 1;
//    }

//    public int countNodes(TreeNode root) {
//        /**
//         完全二叉树的高度可以直接通过不断地访问左子树就可以获取
//         判断左右子树的高度:
//         如果相等说明左子树是满二叉树, 然后进一步判断右子树的节点数(最后一层最后出现的节点必然在右子树中)
//         如果不等说明右子树是深度小于左子树的满二叉树, 然后进一步判断左子树的节点数(最后一层最后出现的节点必然在左子树中)
//         **/
//        if (root == null)
//            return 0;
//        int ld = getDepth(root.left);
//        int rd = getDepth(root.right);
//        if (ld == rd)
//            return (1 << ld) + countNodes(root.right); // 1(根节点) + (1 << ld)-1(左完全左子树节点数) + 右子树节点数量
//        else
//            return (1 << rd) + countNodes(root.left);  // 1(根节点) + (1 << rd)-1(右完全右子树节点数) + 左子树节点数量
//    }
//
//    private int getDepth(TreeNode root) {
//        int depth = 0;
//        while (root != null) {
//            depth++;
//            root = root.left;
//        }
//        return depth;
//    }

    public static void main(String[] args) {

    }


    /// Recursion
/// A very small improvement based on solution1
/// No repeat calculation for leftLeft:)
///
/// Time Complexity: O(h^2) where h is the height of the tree
/// Space Complexity: O(h)
    public int countNodes(TreeNode root) {
        return countNodes(root, -1);
    }

    private int countNodes(TreeNode root, int l) {
        if (root == null)
            return 0;

        int left = l == -1 ? leftHeight(root.left) : l;
        int right = leftHeight(root.right);
        if (left == right)
            return 1 + ((1 << left) - 1) + countNodes(root.right, -1);
        else
            return 1 + ((1 << right) - 1) + countNodes(root.left, left - 1);
    }

    private int leftHeight(TreeNode root) {
        if (root == null)
            return 0;
        return 1 + leftHeight(root.left);
    }

    private int rightHeight(TreeNode root) {
        if (root == null)
            return 0;
        return 1 + rightHeight(root.right);
    }
}
