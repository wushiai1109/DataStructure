import java.time.Instant;
import java.time.ZoneId;
import java.util.Date;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @ClassName Demo
 * @Description
 * @Author Bruce
 * @Date 2020/8/20 8:00 下午
 */
public class Demo {
//    public static void main(String[] args) {
//        Date d = new Date();
//        System.out.println(d);
//
//        Instant instant = Instant.now();
//        System.out.println(instant);
//
//        System.out.println(instant.atZone(ZoneId.systemDefault()));
//
//        System.out.println(instant.atZone(ZoneId.systemDefault()));
//
//        System.out.println();
//
//    }

    static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        ListNode pHead1 = new ListNode(1);
        pHead1.next = new ListNode(5);
        pHead1.next = new ListNode(6);
        pHead1.next = new ListNode(7);
        pHead1.next = new ListNode(9);
        ListNode pHead2 = new ListNode(2);
        pHead2.next = new ListNode(3);
        pHead2.next = new ListNode(4);
        pHead2.next = new ListNode(5);
        pHead2.next = new ListNode(6);
        pHead2.next = new ListNode(7);
        pHead2.next = new ListNode(8);
        ListNode node = findFirstCommonNodeStack(pHead1, pHead2);
        System.out.println(node);
    }

    public static ListNode findFirstCommonNodeStack(ListNode pHead1, ListNode pHead2) {
        ListNode cur1 = pHead1;
        ListNode cur2 = pHead2;
        Stack<ListNode> stack1 = new Stack<>();
        Stack<ListNode> stack2 = new Stack<>();
        while (cur1 != null) {
            stack1.push(cur1);
            cur1 = cur1.next;
        }
        while (cur2 != null) {
            stack2.push(cur2);
            cur2 = cur2.next;
        }
        ListNode publicNode = null;
        while (!stack1.isEmpty() && !stack2.isEmpty()) {
            if (stack1.peek() == stack2.pop()) {
                publicNode = stack1.pop();
            } else {
                return publicNode;
            }
        }
        return publicNode;
    }
}
