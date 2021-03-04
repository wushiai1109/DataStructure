package LinkedList;


/**
 * @author Wushiai
 * @date 2020/3/21 21:16
 * @content 给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 1->2->3->4->5->NULL, k = 2
 * 输出: 4->5->1->2->3->NULL
 * 解释:
 * 向右旋转 1 步: 5->1->2->3->4->NULL
 * 向右旋转 2 步: 4->5->1->2->3->NULL
 * 示例 2:
 * <p>
 * 输入: 0->1->2->NULL, k = 4
 * 输出: 2->0->1->NULL
 * 解释:
 * 向右旋转 1 步: 2->0->1->NULL
 * 向右旋转 2 步: 1->2->0->NULL
 * 向右旋转 3 步: 0->1->2->NULL
 * 向右旋转 4 步: 2->0->1->NULL
 */
public class 旋转链表61双指针 {
    class ListNode {
        int val;
        ListNode next;

        public ListNode(int x) {
            this.val = x;
        }
    }

    public ListNode rotateRight(ListNode head, int k) {
        if (k == 0 || head == null || head.next == null) {
            return head;
        }

        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;

        ListNode p = dummyHead;
        ListNode q = dummyHead;

        int length = 0;
        ListNode len = dummyHead;

        //链表的长度length
        while (len.next != null) {
            length++;
            len = len.next;
        }

        if (length == k || k % length == 0) {
            return dummyHead.next;
        }

        //p为翻转起始点的前一个点
        for (int i = 0; i < (k % length); i++) {
            p = p.next;
        }

        //q为翻转的起始点的前一个点，p为最后一个结点的前一个点
        while (p.next != null) {
            q = q.next;
            p = p.next;
        }

        ListNode ret = q.next;
        q.next = null;
        p.next = dummyHead.next;

        return ret;
    }
}
