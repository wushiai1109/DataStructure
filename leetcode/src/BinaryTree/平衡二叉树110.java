package BinaryTree;

/**
 * @author Wushiai
 * @date 2020/4/4 0:01
 * @content 给定一个二叉树，判断它是否是高度平衡的二叉树。
 * <p>
 * 本题中，一棵高度平衡二叉树定义为：
 * <p>
 * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1。
 * <p>
 * 示例 1:
 * <p>
 * 给定二叉树 [3,9,20,null,null,15,7]
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回 true 。
 * <p>
 * 示例 2:
 * <p>
 * 给定二叉树 [1,2,2,3,3,null,null,4,4]
 * <p>
 * 1
 * / \
 * 2   2
 * / \
 * 3   3
 * / \
 * 4   4
 * 返回 false 。
 */
public class 平衡二叉树110 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int x) {
            this.val = x;
        }
    }

    //找终止条件：什么时候递归到头了？此题自然是root为空的时候，空树当然是平衡的。
    //思考返回值，每一级递归应该向上返回什么信息？参考我代码中的注释。
    //单步操作应该怎么写？因为递归就是大量的调用自身的重复操作，因此从宏观上考虑，只用想想单步怎么写就行了，左树和右树应该看成一个整体，即此时树一共三个节点：root，root.left，root.right。

    //主函数
    public boolean isBalanced(TreeNode root) {
        return isBST(root) != -1;
    }

    //参考递归套路的第三部：描述单次执行过程是什么样的
    //这里的单次执行过程具体如下：
    //是否终止?->没终止的话，判断是否满足不平衡的三个条件->返回值
    public int isBST(TreeNode root) {
        if (root == null)
            return 0;

        //不平衡的情况有3种：左树不平衡、右树不平衡、左树和右树差的绝对值大于1
        int left = isBST(root.left);
        int right = isBST(root.right);

        if (left == -1 || right == -1)
            return -1;

        if (Math.abs(left - right) > 1) {
            return -1;
        }
        //不满足上面3种情况，说明平衡了，树的深度为左右俩子树最大深度+1
        return Math.max(left, right) + 1;
    }
}
