package Stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author Wushiai
 * @date 2020/3/24 20:48
 * @content 给定一个二叉树，返回它的中序 遍历。
 * <p>
 * 示例:
 * <p>
 * 输入: [1,null,2,3]
 * 1
 * \
 * 2
 * /
 * 3
 * <p>
 * 输出: [1,3,2]
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 */
public class 二叉树的中序遍历94 {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    // Classic Non-Recursive algorithm for inorder traversal
// Time Complexity: O(n), n is the node number in the tree
// Space Complexity: O(h), h is the height of the tree
    public List<Integer> inorderTraversal(TreeNode root) {

        ArrayList<Integer> res = new ArrayList<Integer>();
        if(root == null)
            return res;

        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while(cur != null || !stack.empty()){
            while(cur != null){
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            res.add(cur.val);
            cur = cur.right;
        }
        return res;
    }

//    // Inorder Morris Traversal
//// Time Complexity: O(n), n is the node number in the tree
//// Space Complexity: O(1)
//    public List<Integer> inorderTraversal(TreeNode root) {
//
//        ArrayList<Integer> res = new ArrayList<Integer>();
//        if (root == null)
//            return res;
//
//        TreeNode cur = root;
//        while (cur != null) {
//
//            if (cur.left == null) {
//                res.add(cur.val);
//                cur = cur.right;
//            } else {
//                TreeNode prev = cur.left;
//                while (prev.right != null && prev.right != cur)
//                    prev = prev.right;
//
//                if (prev.right == null) {
//                    prev.right = cur;
//                    cur = cur.left;
//                } else {
//                    prev.right = null;
//                    res.add(cur.val);
//                    cur = cur.right;
//                }
//            }
//        }
//        return res;
//    }


//    // Time Complexity: O(n), n is the node number in the tree
//// Space Complexity: O(h), h is the height of the tree
//    public List<Integer> inorderTraversal(TreeNode root) {
//        List<Integer> res = new ArrayList<>();
//        traversal(res, root);
//        return res;
//    }
//
//    public void traversal(List<Integer> res, TreeNode root) {
//        if (root != null) {
//            traversal(res, root.left);
//            res.add(root.val);
//            traversal(res, root.right);
//        }
//    }

}
