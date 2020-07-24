package LinkedList;

/**
 * @author Wushiai
 * @date 2020/3/22 9:06
 * @content 234. 回文链表
 * 请判断一个链表是否为回文链表。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 1->2
 * 输出: false
 * 示例 2:
 * <p>
 * 输入: 1->2->2->1
 * 输出: true
 * 进阶：
 * 你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
 */
public class 回文链表234 {
    static class ListNode {
        int val;
        ListNode next;

        public ListNode(int x) {
            this.val = x;
        }
    }

    public static boolean isPalindrome(ListNode head) {

        if (head == null || head.next == null) {
            return true;
        }

        ListNode slow = head;
        ListNode fast = head;
        ListNode pre = null;

        while (fast != null && fast.next != null) {
            pre = slow;
            slow = head.next;
            fast = head.next.next;
        }
        pre.next = null;

        ListNode head1 = null;
        ListNode cur = slow;

        //翻转后段[slow,fast],head1为后段的头结点
        while (cur != null) {
            ListNode nextNode = cur.next;
            cur.next = head1;
            head1 = cur;
            cur = nextNode;
        }

        while (head != null && head1 != null) {
            if (head.val != head1.val)
                return false;
            else {
                head = head.next;
                head1 = head1.next;
            }
        }
        return true;
    }

    public static void main(String[] args) {

        //尾插法构建链表进行测试
        ListNode dummyHead = new ListNode(-1);
        ListNode tail = dummyHead;
        ListNode newNode = null;
        int arr[] = new int[]{1, 2, 2, 1};
        for (int i = 0; i < arr.length; i++) {
            newNode = new ListNode(arr[i]);
            tail.next = newNode;
            tail = tail.next;
        }

        dummyHead = dummyHead.next;

        while (dummyHead != null) {
            System.out.print(dummyHead.val + "->");
            dummyHead = dummyHead.next;
        }
        System.out.println("null");

        System.out.println(isPalindrome(dummyHead));
    }

}
