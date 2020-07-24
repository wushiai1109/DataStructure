package LinkedList;

/**
 * @author Wushiai
 * @date 2020/3/11 13:25
 * @content
 */
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class LinkedList {

    private ListNode dummyHead;
    private int size;

    public LinkedList() {
        dummyHead = new ListNode(0);
        size = 0;
    }

    // 获取链表中的元素个数
    public int getSize() {
        return size;
    }

    // 返回链表是否为空
    public boolean isEmpty() {
        return size == 0;
    }

    // 在链表的index(0-based)位置添加新的元素e
    // 在链表中不是一个常用的操作，练习用：）
    public void add(int index, int val) {

        if (index < 0 || index > size)
            throw new IllegalArgumentException("Add failed. Illegal index.");

        ListNode prev = dummyHead;
        for (int i = 0; i < index; i++)
            prev = prev.next;

        prev.next = new ListNode(val, prev.next);
        size++;
    }

    // 在链表头添加新的元素e
    public void addFirst(int val) {
        add(0, val);
    }

    // 在链表末尾添加新的元素e
    public void addLast(int val) {
        add(size, val);
    }

    // 获得链表的第index(0-based)个位置的元素
    // 在链表中不是一个常用的操作，练习用：）
    public ListNode get(int index) {

        if (index < 0 || index >= size)
            throw new IllegalArgumentException("Get failed. Illegal index.");

        ListNode cur = dummyHead.next;
        for (int i = 0; i < index; i++)
            cur = cur.next;
        return cur;
    }

    // 获得链表的第一个元素
    public ListNode getFirst() {
        return get(0);
    }

    // 获得链表的最后一个元素
    public ListNode getLast() {
        return get(size - 1);
    }

    // 修改链表的第index(0-based)个位置的元素为e
    // 在链表中不是一个常用的操作，练习用：）
    public void set(int index, int val) {
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("Set failed. Illegal index.");

        ListNode cur = dummyHead.next;
        for (int i = 0; i < index; i++)
            cur = cur.next;
        cur.val = val;
    }

    // 查找链表中是否有元素e
    public boolean contains(int val) {
        ListNode cur = dummyHead.next;
        while (cur != null) {
            if (cur.val == val)
                return true;
            cur = cur.next;
        }
        return false;
    }

    // 从链表中删除index(0-based)位置的元素, 返回删除的元素
    // 在链表中不是一个常用的操作，练习用：）
    public int remove(int index) {
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("Remove failed. Index is illegal.");

        ListNode prev = dummyHead;
        for (int i = 0; i < index; i++)
            prev = prev.next;

        ListNode removeNode = prev.next;
        prev.next = removeNode.next;
        removeNode.next = null;
        size--;

        return removeNode.val;
    }

    // 从链表中删除第一个元素, 返回删除的元素
    public int removeFirst() {
        return remove(0);
    }

    // 从链表中删除最后一个元素, 返回删除的元素
    public int removeLast() {
        return remove(size - 1);
    }

    // 从链表中删除元素e
    public void removeElement(int val) {

        ListNode prev = dummyHead;
        while (prev.next != null) {
            if (prev.next.val == val)
                break;
            prev = prev.next;
        }

        if (prev.next != null) {
            ListNode delNode = prev.next;
            prev.next = delNode.next;
            delNode.next = null;
            size--;
        }
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        ListNode cur = dummyHead.next;
        while (cur != null) {
            res.append(cur.val + "->");
            cur = cur.next;
        }
        res.append("NULL");

        return res.toString();
    }

    public static String print(ListNode node) {
        StringBuilder res = new StringBuilder();
        while (node != null) {
            res.append(node.val + "->");
            node = node.next;
        }
        res.append("NULL");
        return res.toString();
    }

    //92号问题
    public static ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode pre = dummyHead;
        //找到m前的那个结点
        for (int i = 1; i < m; i++)
            pre = pre.next;
        //head指向需要更换的第一个数
        head = pre.next;
        for (int i = m; i < n; i++) {
            //累计将需要更换的前1,2的结点更换
            //pre->head->next->next.next ===> pre->next->head->next.next
            ListNode next = head.next;
            head.next = next.next;
            next.next = pre.next;
            pre.next = next;
        }
        return dummyHead.next;
    }

    //83号问题
    public static ListNode deleteDuplicates(ListNode head) {
        // 递归终止条件
        if (head == null || head.next == null)
            return head;

//        System.out.println(print(head));
        head.next = deleteDuplicates(head.next);
//        System.out.println(print(head));
        if (head.val == head.next.val) {
            System.out.println(print(head));
            head = head.next;
            System.out.println(print(head));
        }
        return head;
    }

    //445号问题
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        java.util.LinkedList<Integer> s1 = new java.util.LinkedList<>();
        java.util.LinkedList<Integer> s2 = new java.util.LinkedList<>();
        while (l1 != null) {
            s1.addFirst(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            s2.addFirst(l2.val);
            l2 = l2.next;
        }

        ListNode dummyHead = new ListNode(0);
        ListNode node = dummyHead;

        int count = 0;
        while (!s1.isEmpty() || !s2.isEmpty() || count != 0) {
            int val1 = !s1.isEmpty() ? s1.getFirst() : 0;
            int val2 = !s2.isEmpty() ? s2.getFirst() : 0;
            int sumVal = val1 + val2 + count;
            count = sumVal / 10;

            node.next = new ListNode(sumVal % 10);
            node = node.next;

            if (!s1.isEmpty())
                s1.removeFirst();
            if (!s2.isEmpty())
                s2.removeFirst();
        }

        ListNode pre = null;
        ListNode cur = dummyHead.next;
        while (cur != null) {
            ListNode node1 = cur.next;
            cur.next = pre;
            pre = cur;
            cur = node1;
        }

        return pre;
    }

    //445
//    public static leetcode.ListNode addTwoNumbers(leetcode.ListNode l1, leetcode.ListNode l2) {
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
//    public static leetcode.ListNode reverseList(leetcode.ListNode cur) {
//        leetcode.ListNode ret = null;
//        while (cur != null) {
//            leetcode.ListNode temp = cur.next;
//            cur.next = ret;
//            ret = cur;
//            cur = temp;
//        }
//        return ret;
//    }

    //234
    public static boolean isPalindrome(ListNode head) {

        if (head == null || head.next == null) {
            return true;
        }

        ListNode slow = head;
        ListNode fast = head;
        ListNode pre = null;

        while (fast != null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
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
        //92
//        LinkedList linkedList = new LinkedList();
//        for (int i = 0; i < 5; i++) {
//            linkedList.addLast(i);
////            System.out.println(linkedList);
//        }
//        leetcode.ListNode node = linkedList.get(0);
//        System.out.println(print(node));
//
//        leetcode.ListNode node1 = reverseBetween(node, 2, 4);
//        System.out.println(print(node1));

        //83
//        LinkedList linkedList = new LinkedList();
//        linkedList.addLast(1);
//        linkedList.addLast(1);
//        linkedList.addLast(2);
//        linkedList.addLast(3);
//        linkedList.addLast(3);
//
//        leetcode.ListNode node = linkedList.get(0);
////        System.out.println(print(node));
//
//        leetcode.ListNode node1 = deleteDuplicates(node);
////        System.out.println(print(node1));

//        //445
//        LinkedList linkedList1 = new LinkedList();
//        linkedList1.addLast(7);
//        linkedList1.addLast(2);
//        linkedList1.addLast(4);
//        linkedList1.addLast(3);
//
//        LinkedList linkedList2 = new LinkedList();
//        linkedList2.addLast(5);
//        linkedList2.addLast(6);
//        linkedList2.addLast(4);
//
//        leetcode.ListNode node = linkedList1.get(0);
//        System.out.println(print(node));
//        leetcode.ListNode node1 = linkedList2.get(0);
//        System.out.println(print(node1));
//
//        leetcode.ListNode node2 = addTwoNumbers(node, node1);
//        System.out.println(print(node2));

        //234
        LinkedList linkedList1 = new LinkedList();
        linkedList1.addLast(1);
        linkedList1.addLast(2);
        linkedList1.addLast(2);
        linkedList1.addLast(1);

        ListNode node = linkedList1.get(0);
        System.out.println(print(node));

        System.out.println(isPalindrome(node));

    }
}
