import java.util.ArrayList;

/**
 * @ClassName 二叉树中和为某一值的路径
 * @Description 题目描述
 * 输入一颗二叉树的根节点和一个整数，按字典序打印出二叉树中结点值的和为输入整数的所有路径。
 * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 * 示例1
 * 输入
 * 复制
 * {10,5,12,4,7},22
 * 返回值
 * 复制
 * [[10,5,7],[10,12]]
 * 示例2
 * 输入
 * 复制
 * {10,5,12,4,7},15
 * 返回值
 * 复制
 * []
 * @Author Bruce
 * @Date 2021/2/10 上午9:31
 */
public class JZ24二叉树中和为某一值的路径 {


    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        dfs(root, target, res, new ArrayList<Integer>());
        return res;
    }

    public void dfs(TreeNode root, int target, ArrayList<ArrayList<Integer>> res, ArrayList<Integer> list) {
        if (root == null) {
            return;
        }
        list.add(root.val);
        target -= root.val;
        if (target == 0 && root.left == null && root.right == null) {
            res.add(new ArrayList<>(list));
        } else {
            dfs(root.left, target, res, list);
            dfs(root.right, target, res, list);
        }
        list.remove(list.size() - 1);
    }

}
