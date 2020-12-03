/**
 * @ClassName JZ55链表中环的入口结点
 * @Description 给一个链表，若其中包含环，请找出该链表的环的入口结点，否则，输出null。
 * 链表
 * @Author Bruce
 * @Date 2020/7/9 1:48 下午
 */
public class JZ55链表中环的入口结点 {

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode EntryNodeOfLoop(ListNode pHead) {

        ListNode slow = pHead;
        ListNode fast = pHead;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) {
                break;
            }
        }
        if (fast == null || fast.next == null) {
            return null;
        }

        //slow从链表头出发
        slow = pHead;
        //fast从相遇点出发
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}
