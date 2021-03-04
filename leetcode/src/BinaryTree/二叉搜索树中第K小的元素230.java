package BinaryTree;

/**
 * @author Wushiai
 * @date 2020/4/7 9:45
 * @content 给定一个二叉搜索树，编写一个函数 kthSmallest 来查找其中第 k 个最小的元素。
 * <p>
 * 说明：
 * 你可以假设 k 总是有效的，1 ≤ k ≤ 二叉搜索树元素个数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: root = [3,1,4,null,2], k = 1
 * 3
 * / \
 * 1   4
 * \
 *    2
 * 输出: 1
 * 示例 2:
 * <p>
 * 输入: root = [5,3,6,2,4,null,null,1], k = 3
 * 5
 * / \
 * 3   6
 * / \
 * 2   4
 * /
 * 1
 * 输出: 3
 * 进阶：
 * 如果二叉搜索树经常被修改（插入/删除操作）并且你需要频繁地查找第 k 小的值，你将如何优化 kthSmallest 函数？
 */
public class 二叉搜索树中第K小的元素230 {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int x) {
            this.val = x;
        }
    }


    /// Inorder Traversal
/// Time Complexity: O(n)
/// Space Complexity: O(h) where h is the height of the BST
    private int index = 0;

    public int kthSmallest(TreeNode root, int k) {
        return kthSmallestNode(root, k).val;
    }

    public TreeNode kthSmallestNode(TreeNode root, int k) {
        if (root == null) {
            return null;
        }

        TreeNode res = kthSmallestNode(root.left, k);
        if (res != null) {
            return res;
        }

        if (++index == k) {
            return root;
        }

        return kthSmallestNode(root.right, k);

    }

}
