package LinkedList;


/**
 * @author Wushiai
 * @date 2020/3/10 13:10
 * @content 反转一个单链表。
 * <p>
 * 示例:
 * <p>
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * 进阶:
 * 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
 */
public class 反转链表206 {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    // Iterative迭代
// 时间复杂度: O(n)
// 空间复杂度: O(1)
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    // Recursive递归
// 时间复杂度: O(n)
// 空间复杂度: O(n)
    public ListNode reverseList1(ListNode head) {
        // 递归终止条件
        if (head == null || head.next == null) {
            return head;
        }

        ListNode rhead = reverseList1(head.next);

        // head->next此刻指向head后面的链表的尾节点
        // head->next->next = head把head节点放在了尾部
        //1->2->3->4->5
        //1->2->3->4<-5,4->null
        //1->2->3<-4<-5,3->null
        //1->2<-3<-4<-5,2->null
        //null<-1<-2<-3<-4<-5
        head.next.next = head;
        head.next = null;

        return rhead;
    }
}
