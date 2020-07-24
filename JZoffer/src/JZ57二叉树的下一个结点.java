/**
 * @ClassName JZ57二叉树的下一个结点
 * @Description 给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
 * 树
 * @Author Bruce
 * @Date 2020/7/4 8:09 下午
 */
public class JZ57二叉树的下一个结点 {

    public class TreeLinkNode {
        int val;
        TreeLinkNode left = null;
        TreeLinkNode right = null;
        TreeLinkNode next = null;

        TreeLinkNode(int val) {
            this.val = val;
        }
    }

    //a-b、c
    //b-d、e   c-f、g
    //e-h、i
    //1. 若该节点存在右子树：则下一个节点为右子树最左子节点(B-->E-->H)
    //2. 若该节点不存在右子树：这时分两种情况：
    //    1. 该节点为父节点的左子节点(D)，则下一个节点为其父节点(D-->B)
    //    2. 该节点为父节点的右子节点(I)，则沿着父节点向上遍历，直到找到一个节点的父节点的左子节点为该节点，则该节点的父节点下一个节点(I-->E-->B,从节点I,沿着父节点一直向上查找找到B,B为其父节点(A)的左子节点,则 I的下一个节点是B的父节点A)
    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        if (pNode == null) {
            return null;
        }
        // 节点有右子树
        if (pNode.right != null) {
            pNode = pNode.right;
            while (pNode.left != null) {
                pNode = pNode.left;
            }
            return pNode;
            // 节点无右子树且该节点为父节点的左子节点
        } else if (pNode.next != null && pNode.next.left == pNode) {
            return pNode.next;
            // 节点无右子树且该节点为父节点的右子节点
        } else if (pNode.next != null && pNode.next.right == pNode) {
            while (pNode.next != null && pNode.next.left != pNode) {
                pNode = pNode.next;
            }
            return pNode.next;
        } else {
            //节点无父节点 ，即节点为根节点
            return pNode.next;
        }
    }
}
