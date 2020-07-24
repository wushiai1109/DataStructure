package Array;

import java.util.Arrays;

/**
 * @author Wushiai
 * @date 2020/2/23 12:52
 * @content 给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。
 * <p>
 * 说明:
 * <p>
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
 * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 * 示例:
 * <p>
 * 输入:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 * <p>
 * 输出: [1,2,2,3,5,6]
 */
public class 合并两个有序数组88 {
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 5, 6};
        new 合并两个有序数组88().merge(nums1, 3, nums2, 3);
        System.out.println(Arrays.toString(nums1));
    }


//    //方法1
//    //时间复杂度O(nlogn)
//    //空间复杂度O(1)
//    public void merge(int[] nums1, int m, int[] nums2, int n) {
//        assert (nums1.length >= m + n && nums2.length == n);
//        for (int i = 0; i < n; i++) {
//            nums1[m + i] = nums2[i];
//        }
//        //Arrays.sort，默认是快排方式，时间复杂度O(NlogN)
//        Arrays.sort(nums1);
//    }

    //方法2的解题思路就跟归并排序最后的merge思想一样的，用两个指针分别指向两个数组的头，然后就每次找一个最小的放到结果数组里去，然后该数所在的指针向后移动一个位置，直到某一个数组指针走到头了为止。
    //判断一下要合并的数组的指针都到头了没有，如果没有的话就再把那个指针后面的数也弄过来放到结果数组里去，最后把数组整理到nums1中返回。
    //这道题应该从后向前找，然后直接把结果在nums1中从后向前存会更好
    //方法2
    //时间复杂度O(n)
    //空间复杂度O(1)
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int k = m + n;
        while (m > 0 && n > 0)
            if (nums1[m - 1] >= nums2[n - 1]) {
                nums1[k - 1] = nums1[m - 1];
                --k;
                --m;
            } else {
                nums1[k - 1] = nums2[n - 1];
                --k;
                --n;
            }
        while (n > 0) {
            nums1[k - 1] = nums2[n - 1];
            --k;
            --n;
        }
    }
}
