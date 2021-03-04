import java.util.*;

/**
 * @ClassName JZ59按之字形顺序打印二叉树
 * @Description 栈 树
 * 题目描述
 * 请实现一个函数按照之字形打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右至左的顺序打印，第三行按照从左到右的顺序打印，其他行以此类推。
 * @Author Bruce
 * @Date 2020/6/26 10:14 上午
 */
public class JZ59按之字形顺序打印二叉树 {

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

//    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
//
//        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
//        if (pRoot == null) {
//            return lists;
//        }
//
//        //s1存奇数层节点
//        Stack<TreeNode> s1 = new Stack<>();
//        s1.push(pRoot);
//        //s2存偶数层节点
//        Stack<TreeNode> s2 = new Stack<>();
//        int layer = 1;
//
//        while (!s1.empty() || !s2.empty()) {
//            if (layer % 2 != 0) {
//                ArrayList<Integer> list = new ArrayList<>();
//                while (!s1.empty()) {
//                    TreeNode node = s1.pop();
//                    if (node != null) {
//                        list.add(node.val);
//                        s2.push(node.left);
//                        s2.push(node.right);
//                    }
//                }
//                if (!list.isEmpty()) {
//                    lists.add(list);
//                    layer++;
//                }
//            } else {
//                ArrayList<Integer> list = new ArrayList<>();
//                while (!s2.empty()) {
//                    TreeNode node = s2.pop();
//                    if (node != null) {
//                        list.add(node.val);
//                        s1.push(node.right);
//                        s1.push(node.left);
//                    }
//                }
//                if (!list.isEmpty()) {
//                    lists.add(list);
//                    layer++;
//                }
//            }
//        }
//        return lists;
//    }


    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {

        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
        if (pRoot == null) {
            return lists;
        }

        LinkedList<TreeNode> linkedList = new LinkedList<>();
        linkedList.add(pRoot);

        int flag = 0;

        while (!linkedList.isEmpty()) {
            ArrayList<Integer> list = new ArrayList<>();
            int count = linkedList.size();
            for (int i = 0; i < count; i++) {
                TreeNode node = linkedList.poll();
                list.add(node.val);
                if (node.left != null) {
                    linkedList.offer(node.left);
                }
                if (node.right != null) {
                    linkedList.offer(node.right);
                }
            }
            if (flag % 2 == 1) {
                Collections.sort(list, new Comparator<Integer>() {
                    @Override
                    public int compare(Integer o1, Integer o2) {
                        return o2-o1;
                    }
                });
//                for (int i = 1; i < list.size(); i++) {
//                    list.add(0, list.remove(i));
//                }
            }
            lists.add(list);
            flag++;
        }
        return lists;
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(8);
        TreeNode node2 = new TreeNode(6);
        TreeNode node3 = new TreeNode(10);
        TreeNode node4 = new TreeNode(5);
        TreeNode node5 = new TreeNode(7);
        TreeNode node6 = new TreeNode(9);
        TreeNode node7 = new TreeNode(11);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;

        System.out.println(new JZ59按之字形顺序打印二叉树().Print(node1));

    }

}
