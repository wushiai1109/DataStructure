package LinkedList;

import java.util.LinkedList;

/**
 * @author Wushiai
 * @date 2020/3/21 22:11
 * @content 给定一个单链表 L：L0→L1→…→Ln-1→Ln ，
 * 将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→…
 * <p>
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * <p>
 * 示例 1:
 * <p>
 * 给定链表 1->2->3->4, 重新排列为 1->4->2->3.
 * 示例 2:
 * <p>
 * 给定链表 1->2->3->4->5, 重新排列为 1->5->2->4->3.
 */
public class 重排链表143 {
    static class ListNode {
        int val;
        ListNode next;

        public ListNode(int x) {
            this.val = x;
        }
    }

    public static void reorderList(ListNode head) {
//        LinkedList<leetcode.ListNode> queue = new LinkedList<>();
//        leetcode.ListNode cur = head;
//        while (cur != null) {
//            queue.addLast(cur);
//            cur = cur.next;
//        }
//        while (!queue.isEmpty()) {
//            if (cur == null) {
//                cur = queue.pollFirst();
//            } else {
//                cur.next = queue.pollFirst();
//                cur = cur.next;
//            }
//            assert cur != null;
//            cur.next = queue.pollLast();
//            cur = cur.next;
//        }
//        if (cur != null) {
//            cur.next = null;
//        }

//        if (head == null || head.next == null)
//            return;
//        leetcode.ListNode fastnode = head;
//        leetcode.ListNode slownode = head;
//        leetcode.ListNode midnode = null;
//        //找到中间点
//        while (fastnode != null && fastnode.next != null) {
//            fastnode = fastnode.next.next;
//            midnode = slownode;
//            slownode = slownode.next;
//        }
//        midnode.next = null;
//        leetcode.ListNode lastnode = null;
//
//        while (slownode != null) {
//            leetcode.ListNode cur = slownode;
//            slownode = slownode.next;
//            cur.next = lastnode;
//            lastnode = cur;
//        }
//
//        leetcode.ListNode ret = new leetcode.ListNode(0);
//        leetcode.ListNode tempnode = ret;
//
//        while (head != null) {
//            tempnode.next = head;
//            head = head.next;
//            tempnode.next.next = lastnode;
//            assert lastnode != null;
//            lastnode = lastnode.next;
//            tempnode = tempnode.next.next;
//        }
//
//        tempnode.next = lastnode;
//        head = ret;

        if (head == null || head.next == null || head.next.next == null) {
            return;
        }
        ListNode slow = head;
        ListNode fast = head;
        ListNode pre = null;
        //slow、fast起始指向头节点(不是虚拟头结点)，执行以下循环后，将链表一分为二，
        //第一段： [head,pre]，第二段[slow,fast]，
        //如果原链表节点为奇数个，fast不为null,slow为中间那个结点
        //如果原链表节点为偶数个，fast为null
        while (fast != null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        pre.next = null;

        //将第二段链表翻转,翻转之后头节点为 head1
        ListNode head1 = null;
        ListNode cur = slow;

        //翻转第二段[slow,fast]
        while (cur != null) {
            ListNode nextNode = cur.next;
            cur.next = head1;
            head1 = cur;
            cur = nextNode;
        }

        //将两段链表合并为一段
        ListNode dummyHead = new ListNode(-1);
        ListNode list = dummyHead;

        while (head != null && head1 != null) {
            list.next = head;
            head = head.next;

            list.next.next = head1;
            head1 = head1.next;

            list = list.next.next;
        }
        if (head1 != null) {
            list.next = head1;
        }
        head = dummyHead.next;
    }

    public static void main(String[] args) {
        //尾插法构建链表进行测试
        ListNode dummyHead = new ListNode(-1);
        ListNode tail = dummyHead;
        ListNode newNode = null;
        int arr[] = new int[]{1, 2, 3, 4, 5};
        for (int i = 0; i < arr.length; i++) {
            newNode = new ListNode(arr[i]);
            tail.next = newNode;
            tail = tail.next;
        }
        dummyHead = dummyHead.next;

        reorderList(dummyHead);

        while (dummyHead != null) {
            System.out.print(dummyHead.val + "->");
            dummyHead = dummyHead.next;
        }
        System.out.println("null");

    }
}
