package LinkedList;

/**
 * @author Wushiai
 * @date 2020/1/25 21:17
 * @content 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 * <p>
 * 示例：
 * <p>
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 * <p>
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 */
public class 删除链表的倒数第N个节点19双指针 {

    static class ListNode {
        int val;
        ListNode next;

        public ListNode(int x) {
            val = x;
        }
    }

    // Two Pointers - One Pass Algorithm
    // Time Complexity: O(n)
    // Space Complexity: O(1)
    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;

        ListNode p = dummyHead;
        ListNode q = dummyHead;

        //p和q相差n+1个
        for (int i = 0; i < n + 1; i++) {
            assert q != null;
            q = q.next;
        }

        //移动q指向末尾
        while (q != null) {
            p = p.next;
            q = q.next;
        }

        p.next = p.next.next;

        return dummyHead.next;
    }


//    // Time Complexity: O(n)
//    // Space Complexity: O(1)
//    //解法1：先遍历一遍计算链表长度，在遍历一遍删除倒数第n个结点，就一共遍历了两遍
//    public leetcode.ListNode removeNthFromEnd(leetcode.ListNode head, int n) {
//
//        leetcode.ListNode dummyHead = new leetcode.ListNode(0);
//        dummyHead.next = head;
//
//        int length = 0;
//        for (leetcode.ListNode cur = dummyHead.next; cur != null; cur = cur.next)
//            length++;
//
//        int k = length - n;
//        assert k >= 0;
//        leetcode.ListNode cur = dummyHead;
//        for (int i = 0; i < k; i++)
//            cur = cur.next;
//
//        cur.next = cur.next.next;
//
//        return dummyHead.next;
//    }

//    public leetcode.ListNode removeNthFromEnd(leetcode.ListNode head, int n) {
//
//        leetcode.ListNode temp = head;
//        Map<Integer, leetcode.ListNode> nodeMap = new HashMap<>();
//
//        int index = 1;
//        while (temp != null) {
//            nodeMap.put(index++, temp);
//            temp = temp.next;
//        }
//
//        int size = nodeMap.size();
//
//        if (size == 1)
//            return null;
//        if (n == 1) {
//            nodeMap.get(size - 1).next = null;
//        } else if (n == size) {
//            head = head.next;
//        } else {
//            nodeMap.get(size - n).next = nodeMap.get(size - n + 2);
//        }
//
//        return head;
//    }


    public static void main(String[] args) {
        ListNode node = new ListNode(0);

        ListNode listNode = new ListNode(0);
        listNode.val = 1;
        listNode.next = node;
        listNode.next.val = 2;
        ListNode listNode2 = new 删除链表的倒数第N个节点19双指针().removeNthFromEnd(listNode, 1);
        while (listNode2 != null) {
            System.out.println(listNode2.val);
            if (listNode2.next == null) {
                break;
            }
            listNode2 = listNode2.next;
        }
    }

}