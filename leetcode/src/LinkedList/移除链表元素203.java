package LinkedList;

/**
 * @author Wushiai
 * @date 2020/3/12 15:40
 * @content 删除链表中等于给定值 val 的所有节点。
 * <p>
 * 示例:
 * <p>
 * 输入: 1->2->6->3->4->5->6, val = 6
 * 输出: 1->2->3->4->5
 */
public class 移除链表元素203 {

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    // Time Complexity: O(n)
    // Space Complexity: O(1)
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;

        ListNode cur = dummyHead;
        while(cur.next != null){
            if(cur.next.val == val ){
                ListNode delNode = cur.next;
                cur.next = delNode.next;
            }else
                cur = cur.next;
        }

        return dummyHead.next;
    }
}
