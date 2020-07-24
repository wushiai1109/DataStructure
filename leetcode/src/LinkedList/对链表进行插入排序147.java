package LinkedList;

/**
 * @author Wushiai
 * @date 2020/3/19 21:40
 * @content 从第一个元素开始，该链表可以被认为已经部分排序（用黑色表示）。
 * 每次迭代时，从输入数据中移除一个元素（用红色表示），并原地将其插入到已排好序的链表中。
 * <p>
 * 插入排序算法：
 * <p>
 * 插入排序是迭代的，每次只移动一个元素，直到所有元素可以形成一个有序的输出列表。
 * 每次迭代中，插入排序只从输入数据中移除一个待排序的元素，找到它在序列中适当的位置，并将其插入。
 * 重复直到所有输入数据插入完为止。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入: 4->2->1->3
 * 输出: 1->2->3->4
 * 示例 2：
 * <p>
 * 输入: -1->5->3->4->0
 * 输出: -1->0->3->4->5
 */
public class 对链表进行插入排序147 {

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    //想要排序快，就要尽可能少的做比较
    //需要一个指针指向当前已排序的最后一个位置，这里用的是head指针
    //需要另外一个指针pre,每次从表头循环，这里用的是dummyHead表头指针
    //每次拿出未排序的节点，先和前驱比较，如果大于或者等于前驱，就不用排序了，直接进入下一次循环
    //如果前驱小，则进入内层循环，依次和pre指针比较，插入对应位置即可。
    public ListNode insertionSortList(ListNode head) {
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;

        while (head != null && head.next != null) {
            //head指向要交换的第一个元素
            if (head.val <= head.next.val) {
                head = head.next;
                continue;
            }
            ListNode pre = dummyHead;

            //pre指向第一个比head.next大的节点
            while (pre.next.val < head.next.val)
                pre = pre.next;

            ListNode cur = head.next;
            head.next = cur.next;
            cur.next = pre.next;
            pre.next = cur;
        }
        return dummyHead.next;
    }
}
