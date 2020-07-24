import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName JZ60把二叉树打印成多行
 * @Description 从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。
 * 队列 树
 * @Author Bruce
 * @Date 2020/6/24 7:25 下午
 */
public class JZ60把二叉树打印成多行 {

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }

    }

    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {

        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
        if (pRoot == null){
            return lists;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(pRoot);

        while (!queue.isEmpty()){
            ArrayList<Integer> list = new ArrayList<>();
            int count = queue.size();

            for (int i = 0; i < count; i++) {
                TreeNode node = queue.poll();
                list.add(node.val);

                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            lists.add(list);
        }
        return lists;
    }
}
