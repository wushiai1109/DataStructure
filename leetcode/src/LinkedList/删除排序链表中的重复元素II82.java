package LinkedList;

/**
 * @author Wushiai
 * @date 2020/3/12 19:58
 * @content 给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 1->2->3->3->4->4->5
 * 输出: 1->2->5
 * 示例 2:
 * <p>
 * 输入: 1->1->1->2->3
 * 输出: 2->3
 */
public class 删除排序链表中的重复元素II82 {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;

        ListNode cur = dummyHead;

        while (cur.next != null && cur.next.next != null) {
            if (cur.next.val == cur.next.next.val) {
                ListNode delNode = cur.next;
                while (delNode.next != null && delNode.val == delNode.next.val) {
                    delNode = delNode.next;
                }
                cur.next = delNode.next;
            } else
                cur = cur.next;
        }

        return dummyHead.next;
    }
}