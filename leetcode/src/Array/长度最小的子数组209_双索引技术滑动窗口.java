package Array;

/**
 * @author Wushiai
 * @date 2020/2/27 15:58
 * @content 给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的连续子数组。如果不存在符合条件的连续子数组，返回 0。
 * <p>
 * 示例: 
 * <p>
 * 输入: s = 7, nums = [2,3,1,2,4,3]
 * 输出: 2
 * 解释: 子数组 [4,3] 是该条件下的长度最小的连续子数组。
 * 进阶:
 * <p>
 * 如果你已经完成了O(n) 时间复杂度的解法, 请尝试 O(n log n) 时间复杂度的解法。
 */
public class 长度最小的子数组209_双索引技术滑动窗口 {

    public static void main(String[] args) {

        int[] nums = {2, 3, 1, 2, 4, 3};
        int s = 7;
        System.out.println((new 长度最小的子数组209_双索引技术滑动窗口().minSubArrayLen(s, nums)));
    }

    // Sum Prefix
// Time Complexity: O(n^2)
// Space Complexity: O(n)
//    public int minSubArrayLen(int s, int[] nums) {
//
//        if (s <= 0 || nums == null)
//            throw new IllegalArgumentException("Illegal Arguments");
//
//        int[] sums = new int[nums.length + 1];
//        sums[0] = 0;
//        for (int i = 1; i <= nums.length; i++)
//            sums[i] = sums[i - 1] + nums[i - 1];
//
//        int res = nums.length + 1;
//        for (int l = 0; l < nums.length; l++)
//            for (int r = l; r < nums.length; r++)
//                if (sums[r + 1] - sums[l] >= s)
//                    res = Math.min(res, r - l + 1);
//
//        return res == nums.length + 1 ? 0 : res;
//    }

//    public int minSubArrayLen(int s, int[] nums) {
//
//        if(s <= 0 || nums == null)
//            throw new IllegalArgumentException("Illegal Arguments");
//
//        int res = nums.length + 1;
//        for(int l = 0 ; l < nums.length ; l ++) {
//            int sum = 0;
//            for (int r = l; r < nums.length; r++){
//                sum += nums[r];
//                if(sum >= s){
//                    res = Math.min(res, r - l + 1);
//                    break;
//                }
//            }
//        }
//
//        return res == nums.length + 1 ? 0 : res;
//    }


//    // Sum Prefix + Binary Search
//// Time Complexity: O(nlogn)
//// Space Complexity: O(n)
//    public int minSubArrayLen(int s, int[] nums) {
//
//        if (s <= 0 || nums == null)
//            throw new IllegalArgumentException("Illegal Arguments");
//
//        int[] sums = new int[nums.length + 1];
//        sums[0] = 0;
//        for (int i = 1; i <= nums.length; i++)
//            sums[i] = sums[i - 1] + nums[i - 1];
//
//        int res = nums.length + 1;
//        for (int l = 0; l < nums.length; l++) {
//            //lowerBound函数用于找到目标sums[l] + target，即最终答案的sums的右下标
//            int r = lowerBound(sums, sums[l] + s);
//            if (r != sums.length)
//                res = Math.min(res, r - l);
//        }
//        return res == nums.length + 1 ? 0 : res;
//    }
//
//    //找到最小的下标，是的sums的值大于或者等于target
//    private int lowerBound(int[] sums, int target) {
//
//        if (sums == null)
//            throw new IllegalArgumentException("Illegal argument nums in lowerBound.");
//
//        int l = 0, r = sums.length;
//        while (l != r) {
//            int mid = l + (r - l) / 2;
//            if (sums[mid] >= target)
//                r = mid;
//            else
//                l = mid + 1;
//        }
//        return l;
//    }


    // Sliding Window
// Another Implementation
// Time Complexity: O(n)
// Space Complexity: O(1)
    public int minSubArrayLen(int s, int[] nums) {
        if (s <= 0 || nums == null)
            throw new IllegalArgumentException("Illegal Arguments");

        //r=-1,使得我们初始时不包括任何元素
        int l = 0, r = -1;//nums[l……r]为我们的滑动窗口
        int sum = 0;
        int res = nums.length + 1;

        while (l < nums.length) {

            if (r + 1 < nums.length && sum < s)
                sum += nums[++r];
            else
                sum -= nums[l++];

            if (sum >= s)
                res = Math.min(res, r - l + 1);
        }

        return res == nums.length + 1 ? 0 : res;
    }


//    public int minSubArrayLen(int s, int[] nums) {
//
//        if (s <= 0 || nums == null)
//            throw new IllegalArgumentException("Illegal Arguments");
////r=-1,使得我们初始时不包括任何元素
//        int l = 0, r = -1;
//        int sum = 0;
//        int res = nums.length + 1;
//
//        while (r + 1 < nums.length) {
//
//            while (r + 1 < nums.length && sum < s)
//                sum += nums[++r];
//
//            if (sum >= s)
//                res = Math.min(res, r - l + 1);
//
//            while (l < nums.length && sum >= s) {
//                sum -= nums[l++];
//                if (sum >= s)
//                    res = Math.min(res, r - l + 1);
//            }
//        }
//
//        return res == nums.length + 1 ? 0 : res;
//    }

}
