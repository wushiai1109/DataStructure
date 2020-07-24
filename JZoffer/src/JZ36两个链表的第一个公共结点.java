/**
 * @ClassName JZ36
 * @Description
 * @Author Bruce
 * @Date 2020/7/22 8:29 下午
 */
public class JZ36两个链表的第一个公共结点 {

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {

        ListNode p1 = pHead1;
        ListNode p2 = pHead2;

        while(p1 != p2){
            if(p1 != null){
                p1=p1.next;
            }
            if(p2 != null){
                p2=p2.next;
            }
            if(p1 != p2){
                if(p1 == null){
                    p1 = pHead2;
                }
                if(p2 == null){
                    p2 = pHead1;
                }
            }
        }
        return p1;

    }

}
