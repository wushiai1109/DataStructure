package BinaryTree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Wushiai
 * @date 2020/4/4 20:57
 * @content 给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。
 * <p>
 * 说明: 叶子节点是指没有子节点的节点。
 * <p>
 * 示例:
 * 给定如下二叉树，以及目标和 sum = 22，
 * <p>
 * 5
 * / \
 * 4   8
 * /   / \
 * 11  13  4
 * /  \    / \
 * 7    2  5   1
 * 返回:
 * <p>
 * [
 * [5,4,11,2],
 * [5,8,4,5]
 * ]
 */
public class 路径总和II113 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int x) {
            this.val = x;
        }
    }

    /// Recursion
/// Time Complexity: O(n)
/// Space Complexity: O(n)
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        if (root.val == sum && root.left == null && root.right == null) {
            List<Integer> list = new ArrayList<>();
            list.add(root.val);
            res.add(list);
            return res;
        }

        List<List<Integer>> left = pathSum(root.left, sum - root.val);
        for (List<Integer> list : left) {
            list.add(0,root.val);
            res.add(list);
        }

        List<List<Integer>> right = pathSum(root.right, sum - root.val);
        for (List<Integer> list : right) {
            list.add(0,root.val);
            res.add(list);
        }

        return res;
    }
}
