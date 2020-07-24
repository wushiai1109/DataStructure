/**
 * @ClassName JZ56删除链表中重复的结点
 * @Description 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
 * 链表
 * @Author Bruce
 * @Date 2020/7/8 8:39 下午
 */
public class JZ56删除链表中重复的结点 {
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    //下面代码只是完成了使链表不重复，并没有完成删除重复的结点，例如链表1->2->3->3->4->4->5 处理后为1->2->3->4->5
//    public ListNode deleteDuplication(ListNode pHead) {
//
//        if (pHead == null || pHead.next == null) {
//            return pHead;
//        }
//
//        ListNode dummyHead = new ListNode(-1);
//        dummyHead.next = pHead;
//
//        while (pHead.next != null) {
//            ListNode cur = pHead.next;
//            if (cur.val == pHead.val) {
//                pHead.next = cur.next;
//                cur.next = null;
//            } else {
//                pHead = pHead.next;
//            }
//        }
//        return dummyHead.next;
//    }

    //完成删除重复的结点，例如链表1->2->3->3->4->4->5 处理后为1->2->5

    public ListNode deleteDuplication(ListNode pHead) {

        if (pHead == null || pHead.next == null) {
            return pHead;
        }
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = pHead;
        ListNode pre = dummyHead;
        ListNode cur = dummyHead.next;

        while (cur != null && cur.next != null) {
            if (cur.val == cur.next.val) {
                // 找到最后的一个相同节点
                while (cur.next != null && cur.val == cur.next.val) {
                    cur = cur.next;
                }
                pre.next = cur.next;
                cur = cur.next;
            } else {
                pre = pre.next;
                cur = cur.next;
            }
        }
        return dummyHead.next;
    }

}

