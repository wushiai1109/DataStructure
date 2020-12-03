package LinkedList;

import java.util.HashMap;

/**
 * @author Wushiai
 * @date 2020/3/10 14:08
 * @content 反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
 * <p>
 * 说明:
 * 1 ≤ m ≤ n ≤ 链表长度。
 * <p>
 * 示例:
 * <p>
 * 输入: 1->2->3->4->5->NULL, m = 2, n = 4
 * 输出: 1->4->3->2->5->NULL
 */
public class 反转链表II92 {

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode pre = dummyHead;
        //找到m前的那个结点
        for (int i = 1; i < m; i++) {
            pre = pre.next;
        }
        //head指向需要更换的第一个数
        head = pre.next;
        for (int i = m; i < n; i++) {
            //累计将需要更换的前1,2的结点更换
            //pre->head->next->next.next ===> pre->next->head->next.next
            ListNode next = head.next;
            head.next = next.next;
            next.next = pre.next;
            pre.next = next;
        }
        return dummyHead.next;
    }

}
