package root;

/**
 * @ClassName 二叉树的直径543
 * @Description 给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过也可能不穿过根结点。
 * <p>
 *  
 * <p>
 * 示例 :
 * 给定二叉树
 * <p>
 * 1
 * / \
 * 2   3
 * / \
 * 4   5
 * 返回 3, 它的长度是路径 [4,2,1,3] 或者 [5,2,1,3]。
 * <p>
 *  
 * <p>
 * 注意：两结点之间的路径长度是以它们之间边的数目表示。
 * @Author Bruce
 * @Date 2020/5/24 7:35 下午
 */
public class 二叉树的直径543 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }

    }


    int max = 0;
    /**
     * @Description 遍历每一个节点,求出此节点作为根的树的深度,那么,左子树深度加右子树深度的最大值即是答案
     * @Param [root]
     * @return int
     **/
    public int diameterOfBinaryTree(TreeNode root) {
        if (root != null) {
            setDepth(root);
            return max;
        }
        return 0;
    }

    public int setDepth(TreeNode root) {
        if (root != null) {
            int right = setDepth(root.right);
            int left = setDepth(root.left);
            if (right + left > max)
                max = right + left;
            return Math.max(right, left) + 1;
        }
        return 0;
    }
}
