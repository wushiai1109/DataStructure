package LinkedList;

/**
 * @author Wushiai
 * @date 2020/3/11 16:53
 * @content 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 1->1->2
 * 输出: 1->2
 * 示例 2:
 * <p>
 * 输入: 1->1->2->3->3
 * 输出: 1->2->3
 */
public class 删除排序链表中的重复元素83 {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode deleteDuplicates1(ListNode head) {
        // 递归终止条件
        if (head == null || head.next == null) {
            return head;
        }

        head.next = deleteDuplicates1(head.next);
        if (head.val == head.next.val) {
            head = head.next;
        }
        return head;
    }

    //迭代
    public ListNode deleteDuplicates(ListNode head) {
        ListNode cur = head;
        while (cur != null && cur.next != null) {
            if (cur.val == cur.next.val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        return head;
    }

}
