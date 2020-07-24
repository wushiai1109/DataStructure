/**
 * @ClassName JZ39平衡二叉树
 * @Description 树
 * 题目描述
 * 输入一棵二叉树，判断该二叉树是否是平衡二叉树。
 * <p>
 * 在这里，我们只需要考虑其平衡性，不需要考虑其是不是排序二叉树
 * @Author Bruce
 * @Date 2020/7/15 8:41 上午
 */
public class JZ39平衡二叉树 {
    class TreeNode {
        int val;
        TreeNode right;
        TreeNode left;

        TreeNode(int x) {
            this.val = x;
        }
    }

//    /**
//     * @return boolean
//     * @Description 这种做法有很明显的问题，在判断上层结点的时候，会多次重复遍历下层结点，增加了不必要的开销。
//     * @Param [root]
//     **/
//    public boolean IsBalanced_Solution(TreeNode root) {
//        if (root == null) {
//            return true;
//        }
//        return Math.abs(maxDepth(root.left) - maxDepth(root.right)) <= 1 &&
//                IsBalanced_Solution(root.left) && IsBalanced_Solution(root.right);
//    }
//
//    private int maxDepth(TreeNode root) {
//        if (root == null) {
//            return 0;
//        }
//        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
//    }

    /**
     * @return boolean
     * @Description 如果改为从下往上遍历，如果子树是平衡二叉树，则返回子树的高度；如果发现子树不是平衡二叉树，则直接停止遍历，这样至多只对每个结点访问一次。
     * @Param [root]
     **/
    public boolean IsBalanced_Solution(TreeNode root) {
        if (root == null) {
            return true;
        }

        return getDepth(root) != -1;
    }

    private int getDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = getDepth(root.left);
        if (left == -1) {
            return -1;
        }
        int right = getDepth(root.right);
        if (right == -1) {
            return -1;
        }
        return Math.abs(left - right) > 1 ? -1 : 1 + Math.max(left, right);
    }
}
