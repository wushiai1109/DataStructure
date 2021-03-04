package BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Wushiai
 * @date 2020/3/26 23:56
 * @content 给定一个二叉树，返回其节点值的锯齿形层次遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 * <p>
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回锯齿形层次遍历如下：
 * <p>
 * [
 * [3],
 * [20,9],
 * [15,7]
 * ]
 */
public class 二叉树的锯齿形层次遍历103 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        ArrayList<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null)
            return res;
        queue.add(root);

        int flag = 1;

        while (!queue.isEmpty()) {

            ArrayList<Integer> list = new ArrayList<>();
            int count = queue.size();

            if ((flag % 2) == 1 || ((flag % 2) == 0 && count == 1)) {
                for (int i = 0; i < count; i++) {
                    TreeNode node = queue.remove();
                    list.add(node.val);
                    if (node.left != null)
                        queue.add(node.left);
                    if (node.right != null)
                        queue.add(node.right);
                }
                flag++;
            } else {
                for (int i = 0; i < count; i++) {
                    TreeNode node = queue.remove();
                    list.add(0, node.val);
                    if (node.left != null)
                        queue.add(node.left);
                    if (node.right != null)
                        queue.add(node.right);
                }
                flag++;
            }

            res.add(list);
        }
        return res;
    }
}
