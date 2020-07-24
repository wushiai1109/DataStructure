package LinkedList;

import java.awt.*;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Wushiai
 * @date 2020/3/12 11:02
 * @content 给定两个非空链表来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储单个数字。将这两数相加会返回一个新的链表。
 * <p>
 *  
 * <p>
 * 你可以假设除了数字 0 之外，这两个数字都不会以零开头。
 * <p>
 * 进阶:
 * <p>
 * 如果输入链表不能修改该如何处理？换句话说，你不能对列表中的节点进行翻转。
 * <p>
 * 示例:
 * <p>
 * 输入: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出: 7 -> 8 -> 0 -> 7
 */
public class 两数相加II445 {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }


    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        //使l1和l2按照 逆序 的方式存储在s1和s2
        LinkedList<Integer> s1 = new LinkedList<>();
        LinkedList<Integer> s2 = new LinkedList<>();
        while (l1 != null) {
            s1.addFirst(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            s2.addFirst(l2.val);
            l2 = l2.next;
        }

        int count = 0;
        ListNode ret = null;
        while (!s1.isEmpty() || !s2.isEmpty() || count != 0) {
            int a1 = 0, a2 = 0;
            if (!s1.isEmpty())
                a1 = s1.removeFirst();
            if (!s2.isEmpty())
                a2 = s2.removeFirst();
            count = (a1 + a2 + count) / 10;

            ListNode curNode = new ListNode((a1 + a2 + count) % 10);
            curNode.next = ret;
            ret = curNode;
        }
        return ret;
    }


//    public leetcode.ListNode addTwoNumbers(leetcode.ListNode l1, leetcode.ListNode l2) {
//        leetcode.ListNode rev1 = reverseList(l1);
//        leetcode.ListNode rev2 = reverseList(l2);
//        leetcode.ListNode ret = null;
//
//        int count = 0;
//        while (rev1 != null || rev2 != null || count != 0) {
//            int val1 = rev1 != null ? rev1.val : 0;
//            int val2 = rev2 != null ? rev2.val : 0;
//            int sumVal = val1 + val2 + count;
//            count = sumVal / 10;
//
//            leetcode.ListNode cur = new leetcode.ListNode(sumVal % 10);
//            cur.next = ret;
//            ret = cur;
//
//            if (rev1 != null)
//                rev1 = rev1.next;
//            if (rev2 != null)
//                rev2 = rev2.next;
//        }
//        return ret;
//    }
//
//    public leetcode.ListNode reverseList(leetcode.ListNode cur) {
//        leetcode.ListNode ret = null;
//        while (cur != null) {
//            leetcode.ListNode temp = cur.next;
//            cur.next = ret;
//            ret = cur;
//            cur = temp;
//        }
//        return ret;
//    }

}