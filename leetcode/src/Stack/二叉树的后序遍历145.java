package Stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author Wushiai
 * @date 2020/3/24 20:19
 * @content 给定一个二叉树，返回它的 后序 遍历。
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
 * 输出: [3,2,1]
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 */
public class 二叉树的后序遍历145 {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    // Classic Non-Recursive
// Using a pre pointer to record the last visted node
// Time Complexity: O(n)
// Space Complexity: O(h)
    public List<Integer> postorderTraversal(TreeNode root) {

        ArrayList<Integer> res = new ArrayList<Integer>();
        if(root == null)
            return res;

        Stack<TreeNode> stack = new Stack<>();
        TreeNode pre = null;
        TreeNode cur = root;

        while(cur != null || !stack.empty()){

            while(cur != null){
                stack.push(cur);
                cur = cur.left;
            }

            cur = stack.pop();
            if(cur.right == null || pre == cur.right){
                res.add(cur.val);
                pre = cur;
                cur = null;
            }else{
                stack.push(cur);
                cur = cur.right;
            }
        }
        return res;
    }


//// Recursive
//// Time Complexity: O(n), n is the node number in the tree
//// Space Complexity: O(h), h is the height of the tree
//    public List<Integer> postorderTraversal(TreeNode root) {
//        List<Integer> res = new ArrayList<>();
//        traversal(res, root);
//        return res;
//    }
//
//    public void traversal(List<Integer> list, TreeNode node) {
//        if(node != null){
//            traversal(list,node.left);
//            traversal(list,node.right);
//            list.add(node.val);
//        }
//    }
}
