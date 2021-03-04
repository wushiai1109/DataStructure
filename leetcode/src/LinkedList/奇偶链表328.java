package LinkedList;

/**
 * @author Wushiai
 * @date 2020/3/11 19:05
 * @content 给定一个单链表，把所有的奇数节点和偶数节点分别排在一起。请注意，这里的奇数节点和偶数节点指的是节点编号的奇偶性，而不是节点的值的奇偶性。
 * <p>
 * 请尝试使用原地算法完成。你的算法的空间复杂度应为 O(1)，时间复杂度应为 O(nodes)，nodes 为节点总数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 1->2->3->4->5->NULL
 * 输出: 1->3->5->2->4->NULL
 * 示例 2:
 * <p>
 * 输入: 2->1->3->5->6->4->7->NULL
 * 输出: 2->3->6->7->1->5->4->NULL
 * 说明:
 * <p>
 * 应当保持奇数节点和偶数节点的相对顺序。
 * 链表的第一个节点视为奇数节点，第二个节点视为偶数节点，以此类推。
 */
public class 奇偶链表328 {

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode oddEvenList(ListNode head) {
        ListNode dummyHead1 = new ListNode(-1);
        ListNode dummyHead2 = new ListNode(-1);
        ListNode node1 = dummyHead1;
        ListNode node2 = dummyHead2;
        boolean flag = true;
        while (head != null) {
            if (flag) {
                node1.next = head;
                head = head.next;
                node1 = node1.next;
                node1.next = null;
                flag = false;
            } else {
                node2.next = head;
                head = head.next;
                node2 = node2.next;
                node2.next = null;
                flag = true;
            }
        }
        node1.next = dummyHead2.next;
        return dummyHead1.next;
    }
}
