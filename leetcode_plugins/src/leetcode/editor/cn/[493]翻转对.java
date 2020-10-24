package leetcode.editor.cn;//给定一个数组 nums ，如果 i < j 且 nums[i] > 2*nums[j] 我们就将 (i, j) 称作一个重要翻转对。
//
// 你需要返回给定数组中的重要翻转对的数量。 
//
// 示例 1: 
//
// 
//输入: [1,3,2,3,1]
//输出: 2
// 
//
// 示例 2: 
//
// 
//输入: [2,4,3,5,1]
//输出: 3
// 
//
// 注意: 
//
// 
// 给定数组的长度不会超过50000。 
// 输入数组中的所有数字都在32位整数的表示范围内。 
// 
// Related Topics 排序 树状数组 线段树 二分查找 分治算法 
// 👍 139 👎 0


import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class 反转对493 {
    public int reversePairs(int[] nums) {
        return mergeSort(nums, 0, nums.length - 1);
    }

    private int mergeSort(int[] nums, int left, int right) {
        if (left >= right) {
            return 0;
        }
        int mid = left + (right - left) / 2;
        int res = mergeSort(nums, left, mid) + mergeSort(nums, mid + 1, right);
        //只统计不归并
        for (int i = left, j = mid + 1; i <= mid; i++) {
            while (j <= right && nums[i] / 2.0 > nums[j]) {
                j++;
            }
            res += j - (mid + 1);
        }
//        Arrays.sort(nums, begin, end + 1);//O(nlogn)

        //O(n)
        merge(nums, left, mid, right);
        return res;
    }

    private static void merge(int[] array, int left, int mid, int right) {
        //中间数组
        int[] temp = new int[right - left + 1];
        int i = left, j = mid + 1, k = 0;

        while (i <= mid && j <= right) {
            temp[k++] = array[i] <= array[j] ? array[i++] : array[j++];
        }

        while (i <= mid) {
            temp[k++] = array[i++];
        }
        while (j <= right) {
            temp[k++] = array[j++];
        }

//        for (int l = 0; l < temp.length; l++) {
//            array[left + l] = temp[l];
//        }
        //src表示源数组
        //srcPos表示源数组中拷贝元素的起始位置。
        //dest表示目标数组
        //destPos表示拷贝到目标数组的起始位置
        //length表示拷贝元素的个数
        System.arraycopy(temp, 0, array, left, temp.length);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
