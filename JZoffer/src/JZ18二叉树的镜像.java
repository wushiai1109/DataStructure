import java.util.LinkedList;

/**
 * @ClassName JZ18二叉树的镜像
 * @Description 本题知识点： 树
 * 题目描述
 * 操作给定的二叉树，将其变换为源二叉树的镜像。
 * 输入描述:
 * 二叉树的镜像定义：源二叉树
 * 8
 * /  \
 * 6   10
 * / \  / \
 * 5  7 9 11
 * 镜像二叉树
 * 8
 * /  \
 * 10   6
 * / \  / \
 * 11 9 7  5
 * @Author Bruce
 * @Date 2021/2/11 下午1:40
 */
public class JZ18二叉树的镜像 {
    class TreeNode {

        int val;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }

    }

    /// Recursive
/// Time Complexity: O(n), where n is the node's number of the tree
/// Space Complexity: O(h), where h is the height of the tree
    public TreeNode Mirror(TreeNode pRoot) {
        if (pRoot == null) {
            return null;
        }

        TreeNode left = Mirror(pRoot.left);
        TreeNode right = Mirror(pRoot.right);

        pRoot.left = right;
        pRoot.right = left;

        return pRoot;
    }

    /// Non-Recursive
/// Time Complexity: O(n), where n is the node's number of the tree
/// Space Complexity: O(h), where h is the height of the tree
    public TreeNode Mirror1(TreeNode pRoot) {

        if (pRoot == null) {
            return null;
        }

        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.addLast(pRoot);
        while (!queue.isEmpty()) {
            TreeNode curNode = queue.removeFirst();

            TreeNode tempNode = curNode.left;
            curNode.left = curNode.right;
            curNode.right = tempNode;

            if (curNode.left != null) {
                queue.addLast(curNode.left);
            }
            if (curNode.right != null) {
                queue.push(curNode.right);
            }
        }
        return pRoot;
    }
}
