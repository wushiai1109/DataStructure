package root;

/**
 * @ClassName 二叉树的坡度563
 * @Description 给定一个二叉树，计算整个树的坡度。
 * <p>
 * 一个树的节点的坡度定义即为，该节点左子树的结点之和和右子树结点之和的差的绝对值。空结点的的坡度是0。
 * <p>
 * 整个树的坡度就是其所有节点的坡度之和。
 * <p>
 * 示例:
 * <p>
 * 输入:
 * 1
 * /   \
 * 2     3
 * 输出: 1
 * 解释:
 * 结点的坡度 2 : 0
 * 结点的坡度 3 : 0
 * 结点的坡度 1 : |2-3| = 1
 * 树的坡度 : 0 + 0 + 1 = 1
 * 注意:
 * <p>
 * 任何子树的结点的和不会超过32位整数的范围。
 * 坡度的值不会超过32位整数的范围。
 * @Author Bruce
 * @Date 2020/5/24 7:53 下午
 */
public class 二叉树的坡度563 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int x) {
            this.val = x;
        }
    }

    int result = 0;
    public int findTilt(TreeNode root) {
        sum(root);
        return result;
    }

    private int sum(TreeNode root) {
        if (root == null)
            return 0;

        int l = sum(root.left);
        int r = sum(root.right);
        result += Math.abs(l - r);
        return l + r + root.val;
    }

}
