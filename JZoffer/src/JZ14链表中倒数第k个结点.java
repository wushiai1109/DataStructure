/**
 * @ClassName JZ14链表中倒数第k个结点
 * @Description 本题知识点： 链表 双指针
 * 题目描述
 * 输入一个链表，输出该链表中倒数第k个结点。
 * 示例1
 * 输入
 * 1,{1,2,3,4,5}
 * 返回值
 * {5}
 * @Author Bruce
 * @Date 2021/2/12 下午3:12
 */
public class JZ14链表中倒数第k个结点 {
    class ListNode {
        int val;
        ListNode next = null;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode FindKthToTail(ListNode head, int k) {
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;

        ListNode start = dummyHead;
        ListNode end = dummyHead;

        int n = k+1;
        //start和end相差n+1个
        for (int i = 0; i < k + 1; i++) {
            if(end != null){
                end = end.next;
                n--;
            }
        }

        //移动end指向末尾
        while (end != null) {
            start = start.next;
            end = end.next;
        }

        return n == 0 ? start.next : null;
    }

}
