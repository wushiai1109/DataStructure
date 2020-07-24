package LinkedList;

/**
 * @author Wushiai
 * @date 2020/3/19 20:03
 * @content 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 * <p>
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * <p>
 * <p>
 * <p>
 * 示例:
 * <p>
 * 给定 1->2->3->4, 你应该返回 2->1->4->3.
 */
public class 两两交换链表中的节点24 {

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }



    //dummyHead->node1->node2->3
    //node2.next->node1
    //node1->3;
    //dummyHead->node2
    //dummyHead->node2->node1->3
    //dummyHead=node1

    //时间复杂度O(n)
    //空间复杂度O(1)

    public ListNode swapPairs(ListNode head) {

        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;

        ListNode pre = dummyHead;

        while (pre.next != null && pre.next.next != null) {
            ListNode node1 = pre.next;
            ListNode node2 = node1.next;
            ListNode next = node2.next;
            node2.next = node1;
            node1.next = next;
            pre.next = node2;
            pre = node1;
        }
        return dummyHead.next;
    }

}
