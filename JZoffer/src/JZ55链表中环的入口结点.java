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
        if (pHead.next == null || pHead.next.next == null) {
            return null;
        }
        ListNode slow = pHead.next;
        ListNode fast = pHead.next.next;
        while (fast != null) {
            if (fast == slow) {
                fast = pHead;
                while (fast != slow) {
                    fast = fast.next;
                    slow = slow.next;
                }
                return fast;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return null;
    }

//    public ListNode EntryNodeOfLoop(ListNode pHead) {
//
//        ListNode slow = pHead;
//        ListNode fast = pHead;
//
//        //fast追上slow的点或者null
//        while (fast != null && fast.next != null) {
//            slow = slow.next;
//            fast = fast.next.next;
//            if (fast == slow) {
//                break;
//            }
//        }
//        //判断是否无环
//        if (fast == null || fast.next == null) {
//            return null;
//        }
//
//        //slow从链表头出发
//        slow = pHead;
//        //fast从相遇点出发
//        while (fast != slow) {
//            fast = fast.next;
//            slow = slow.next;
//        }
//        return slow;
//    }

    //fast:a+b+c
    //slow:a+c
    //fast相遇slow时，a+b+c = 2(a+c) --> b = a + c
    //a=b-c

}
