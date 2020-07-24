package BinaryTree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Wushiai
 * @date 2020/4/4 20:23
 * @content 给定一个二叉树，返回所有从根节点到叶子节点的路径。
 * <p>
 * 说明: 叶子节点是指没有子节点的节点。
 * <p>
 * 示例:
 * <p>
 * 输入:
 * <p>
 * 1
 * /   \
 * 2     3
 * \
 * 5
 * <p>
 * 输出: ["1->2->5", "1->3"]
 * <p>
 * 解释: 所有根节点到叶子节点的路径为: 1->2->5, 1->3
 */
public class 二叉树的所有路径257 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int x) {
            this.val = x;
        }
    }

    /// Recursive
/// Time Complexity: O(n), where n is the node's number in the tree
/// Space Complexity: O(h), where h is the height of the tree
    public List<String> binaryTreePaths(TreeNode root) {
        ArrayList<String> res = new ArrayList<>();

        if (root == null)
            return res;

        if (root.left == null && root.right == null) {
            res.add(Integer.toString(root.val));
            return res;
        }

        List<String> leftPaths = binaryTreePaths(root.left);
        for (String s : leftPaths) {
            String sb = Integer.toString(root.val) + "->" + s;
            res.add(sb);
        }

        List<String> rightPaths = binaryTreePaths(root.right);
        for (String s : rightPaths) {
            StringBuilder sb = new StringBuilder(Integer.toString(root.val));
            sb.append("->");
            sb.append(s);
            res.add(sb.toString());
        }

        return res;
    }
}
