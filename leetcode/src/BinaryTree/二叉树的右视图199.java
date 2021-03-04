package BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Wushiai
 * @date 2020/3/27 9:11
 * @content 给定一棵二叉树，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
 * <p>
 * 示例:
 * <p>
 * 输入: [1,2,3,null,5,null,4]
 * 输出: [1, 3, 4]
 * 解释:
 * <p>
 * 1            <---
 * /   \
 * 2     3         <---
 * \     \
 * 5     4       <---
 */
public class 二叉树的右视图199 {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

//    public List<Integer> rightSideView(TreeNode root) {
//
//        ArrayList<Integer> res = new ArrayList<>();
//        if (root == null)
//            return res;
//
//        ArrayList<List<Integer>> arrayList = new ArrayList<>();
//        Queue<TreeNode> queue = new LinkedList<>();
//        queue.add(root);
//
//        while (!queue.isEmpty()) {
//
//            int count = queue.size();
//
//            ArrayList<Integer> list = new ArrayList<>();
//
//            for (int i = 0; i < count; i++) {
//                TreeNode node = queue.remove();
//                list.add(node.val);
//
//                if (node.left != null)
//                    queue.add(node.left);
//                if (node.right != null)
//                    queue.add(node.right);
//            }
//            arrayList.add(list);
//        }
//
//        for (List<Integer> list : arrayList) {
//            res.add(list.get(list.size() - 1));
//        }
//
//        return res;
//    }

    public List<Integer> rightSideView(TreeNode root) {

        ArrayList<Integer> res = new ArrayList<Integer>();
        if (root == null)
            return res;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int count = queue.size();

            for (int i = 0; i < count; ++i) {
                if (i == count - 1) {
                    assert queue.peek() != null;
                    res.add(queue.peek().val);
                }
                TreeNode node = queue.remove();

                if (node.left != null)
                    queue.add(node.left);
                if (node.right != null)
                    queue.add(node.right);

            }
        }
        return res;
    }
}
