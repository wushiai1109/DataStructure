/**
 * @ClassName JZ17树的子结构
 * @Description 本题知识点： 二叉树 树
 * 题目描述
 * 输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
 * 示例1
 * 输入
 * {8,8,#,9,#,2,#,5},{8,9,#,2}
 * 返回值
 * true
 * @Author Bruce
 * @Date 2021/2/12 下午2:33
 */
public class JZ17树的子结构 {

    class TreeNode {
        int val;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public boolean HasSubtree(TreeNode root1, TreeNode root2) {
        if (root1 == null || root2 == null) {
            return false;
        }
        //如果找到与子树相同根的值，走判断方法
        if (root1.val == root2.val) {
            if (judge(root1, root2)) {
                return true;
            }
        }
        //遍历左孩子，右孩子
        return HasSubtree(root1.left, root2) || HasSubtree(root1.right, root2);
    }

    //判断是否是子结构
    public boolean judge(TreeNode root, TreeNode node) {
        //子结构已经循环完毕，代表全部匹配
        if (node == null) {
            return true;
        }
        //大树已经循环完毕，并未成功匹配
        if (root == null) {
            return false;
        }
        //相等后判断左右孩子
        if (root.val == node.val) {
            return judge(root.left, node.left) && judge(root.right, node.right);
        }
        return false;
    }
}