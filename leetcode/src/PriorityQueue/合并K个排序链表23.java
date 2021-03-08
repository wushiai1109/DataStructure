package PriorityQueue;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author Wushiai
 * @date 2020/4/1 22:43
 * @content 合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
 * <p>
 * 示例:
 * <p>
 * 输入:
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * 输出: 1->1->2->3->4->4->5->6
 */


//用容量为K的最小堆优先队列，把链表的头结点都放进去，
// 然后出队当前优先队列中最小的，挂上链表，
// 然后让出队的那个节点的下一个入队，
// 再出队当前优先队列中最小的，直到优先队列为空。
public class 合并K个排序链表23 {
    class ListNode {
        int val;
        ListNode next;

        public ListNode(int x) {
            this.val = x;
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {

        if (lists.length == 0) {
            return null;
        }

        ListNode dummyHead = new ListNode(-1);
        ListNode cur = dummyHead;

        PriorityQueue<ListNode> pq = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode a, ListNode b) {
                return a.val - b.val;
            }
        });

        for (ListNode node : lists) {
            if (node == null) {
                continue;
            }
            pq.add(node);
        }

        while (!pq.isEmpty()) {
            ListNode nextNode = pq.poll();
            cur.next = nextNode;
            cur = cur.next;
            if (nextNode.next != null) {
                pq.add(nextNode.next);
            }
        }
        return dummyHead.next;
    }


    //子集
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println(new 合并K个排序链表23().collection(nums));
    }

    public List<List<Integer>> collection(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        backCollection(nums, res, 0, new ArrayList<Integer>());
        return res;
    }

    private void backCollection(int[] nums, List<List<Integer>> res, int i, ArrayList<Integer> list) {
        res.add(new ArrayList<>(list));
        for (int j = i; j < nums.length; j++) {
            list.add(nums[j]);
            backCollection(nums, res, j + 1, list);
            list.remove(list.size() - 1);
        }
    }

}
