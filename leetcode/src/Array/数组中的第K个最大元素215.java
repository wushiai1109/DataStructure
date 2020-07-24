package Array;

/**
 * @author Wushiai
 * @date 2020/2/23 15:12
 * @content 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [3,2,1,5,6,4] 和 k = 2
 * 输出: 5
 * 示例 2:
 * <p>
 * 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
 * 输出: 4
 * 说明:
 * <p>
 * 你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度。
 */
public class 数组中的第K个最大元素215 {
    public static void main(String[] args) {
        int[] nums = {3, 2, 3, 1, 2, 4, 5, 5, 6};
        System.out.println(new 数组中的第K个最大元素215().findKthLargest(nums, 4));
    }

//    //方法1
//    //时间复杂度O(nlogn)时间复杂度：因为使用的JDK的Arrays.sort，默认是快排方式，时间复杂度O(NlogN)
//    //空间复杂度O(1)：使用的原地排序，空间复杂度O(1)
//    public int findKthLargest(int[] nums, int k) {
//        Arrays.sort(nums);
//        return nums[nums.length - k];
//    }


//    //leetcode给出的方法
//    public int findKthLargest(int[] nums, int k) {
//
//        PriorityQueue<Integer> heap = new PriorityQueue<Integer>((n1, n2) -> n1 - n2);
//
//        for (int n : nums) {
//            heap.add(n);
//            if (heap.size() > k)
//                heap.poll();
//        }
//
//        return heap.poll();
//    }


//    //方法2
//    //解法二：小顶堆（双亲结点小于等于孩子结点）
//    //利用小顶堆的特性（堆顶元素最小），先对前K个数组元素进行"原地"建小顶堆，建完小顶堆后，堆顶的元素最小，正好是这K个元素的第K大元素。
//    //然后遍历剩下的元素 nums[k] ~ nums[len-1]
//    //1、如果比堆顶元素小，跳过
//    //2、如果比堆顶元素大，和堆顶元素交换后重新堆化
//    //时间复杂度:O(nlogk)
//    //空间复杂度:O(k)，用于存储堆元素。
//    //本方法优化了时间复杂度，但需要O(k)的空间复杂度。
//    //堆可以看做一个完全二叉树，同时该完全二叉树满足双亲结点大于等于孩子结点（大顶堆），
//    // 或者双亲结点小于等于孩子结点（小顶堆）。
//    public int findKthLargest(int[] nums, int k) {
//        //前K个元素原地建小顶堆
//        buildHeap(nums, k);
//        //遍历剩下元素，比堆顶小，跳过；比堆顶大，交换后重新堆化
//        for (int i = k; i < nums.length; i++) {
//            if (nums[i] < nums[0])
//                continue;
//            swap(nums, i, 0);
//            heapify(nums, k, 0);
//        }
//        //K个元素的小顶堆的堆顶即是第K大元素
//        return nums[0];
//    }
//
//    /**
//     * 建堆函数
//     * 从倒数第一个非叶子节点开始堆化，倒数第一个非叶子节点下标为 K/2-1
//     */
//    public void buildHeap(int[] a, int k) {
//        for (int i = k / 2 - 1; i >= 0; i--) {
//            heapify(a, k, i);
//        }
//    }
//
//    /**
//     * 堆化函数
//     * 父节点下标i，左右子节点的下标分别为 2*i+1 和 2*i+2
//     */
//    public void heapify(int[] a, int k, int i) {
//        //临时变量 minPos用于存储最小值的下标，先假设父节点最小
//        int minPos = i;
//        while (true) {
//            //和左子节点比较
//            if (i * 2 + 1 < k && a[i * 2 + 1] < a[i])
//                minPos = i * 2 + 1;
//            //和右子节点比较
//            if (i * 2 + 2 < k && a[i * 2 + 2] < a[minPos])
//                minPos = i * 2 + 2;
//            //如果minPos没有发生变化，说明父节点已经是最小了，直接跳出
//            if (minPos == i)
//                break;
//            //否则交换
//            swap(a, i, minPos);
//            //父节点下标进行更新，继续堆化
//            i = minPos;
//        }
//    }
//
//    public void swap(int[] a, int n, int m) {
//        int tmp = a[n];
//        a[n] = a[m];
//        a[m] = tmp;
//    }


    public int findKthLargest(int[] nums, int k) {
        k = nums.length - k;
        int i = 0, j = nums.length - 1;
        while (true) {
            int index = partition(nums, i, j);
            if (index == k)
                return nums[index];
            else if (index > k)
                j = index - 1;
            else
                i = index + 1;
        }
    }

    //pivot 是轴，i在nums的部分上循环，j是最后一个比pivot小的值，pivot和j的值交换位置就保证了pivot左边的都小于pivot，右边的都大于pivot。
    public int partition(int[] nums, int left, int right) {
        int pivot = nums[left];
        int j = left;
        for (int i = left + 1; i <= right; i++) {
            if (nums[i] < pivot) {
                j++;
                swap(nums, i, j);
            }
        }
        swap(nums, left, j);
        return j;
    }

    public void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }

}
