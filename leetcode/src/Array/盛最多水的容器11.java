package Array;

/**
 * @author Wushiai
 * @date 2019/8/13 15:19
 * 2
 */
public class 盛最多水的容器11 {

    /**
     * 给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
     * 说明：你不能倾斜容器，且 n 的值至少为 2。
     * <p>
     * 输入: [1,8,6,2,5,4,8,3,7]
     * 输出: 49
     */

    /// Two Pointers
/// Time Complexity: O(n)
/// Space Complexity: O(1)
    public static void main(String[] args) {
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(maxArea(height));
    }

//    public static int maxArea(int[] height) {
//        int sum = 0, sum_1 = 0, x = 0;
//        for (int i = 0; i < height.length; i++) {
//            for (int j = i + 1; j < height.length; j++) {
//                x = (height[i] > height[j]) ? height[j] : height[i];
//                sum_1 = x * (j - i);
//                if (sum_1 > sum)
//                    sum = sum_1;
//            }
//        }
//        return sum;
//    }

    public static int maxArea(int[] height) {
        int l = 0, r = height.length - 1, h;
        int area = 0, area1;
        while (l < r) {
            h = height[l] < height[r] ? height[l] : height[r];
            area1 = h * (r - l);
            if (height[l] < height[r])
                l++;
            else
                r--;
            if (area1 > area)
                area = area1;
        }
        return area;
    }

}
