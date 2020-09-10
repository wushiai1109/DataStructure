package Stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author Wushiai
 * @date 2020/3/24 20:19
 * @content 给定一个二叉树，返回它的 前序 遍历。
 * <p>
 *  示例:
 * <p>
 * 输入: [1,null,2,3]
 * 1
 * \
 * 2
 * /
 * 3
 * <p>
 * 输出: [1,2,3]
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 */
public class 二叉树的前序遍历144 {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

//    public List<Integer> preorderTraversal(TreeNode root) {
//        List<Integer> res = new ArrayList<>();
//        if (root == null)
//            return res;
//        Stack<TreeNode> stack = new Stack<>();
//        stack.push(root);
//        while (!stack.isEmpty()) {
//            TreeNode node = stack.pop();
//            res.add(node.val);
//            if (node.right != null)
//                stack.push(node.right);
//            if (node.left != null)
//                stack.push(node.left);
//        }
//        return res;
//    }


    // Another Classic Non-Recursive algorithm for preorder traversal
// Time Complexity: O(n), n is the node number in the tree
// Space Complexity: O(h), h is the height of the tree
    public List<Integer> preorderTraversal(TreeNode root) {

        ArrayList<Integer> res = new ArrayList<Integer>();
        if(root == null)
            return res;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode cur = root;
        while(cur != null || !stack.isEmpty()){
            while(cur != null){
                res.add(cur.val);
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            cur = cur.right;
        }
        return res;
    }


//// Recursive
//// Time Complexity: O(n), n is the node number in the tree
//// Space Complexity: O(h), h is the height of the tree
//    public List<Integer> preorderTraversal(TreeNode root) {
//        List<Integer> res = new ArrayList<>();
//        traversal(res, root);
//        return res;
//    }
//
//    public void traversal(List<Integer> list, TreeNode node) {
//        if(node != null){
//            list.add(node.val);
//            traversal(list,node.left);
//            traversal(list,node.right);
//        }
//    }
}
