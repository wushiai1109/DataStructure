package leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Deque;
//给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
//
// 求在该柱状图中，能够勾勒出来的矩形的最大面积。 
//
// 
//
// 
//
// 以上是柱状图的示例，其中每个柱子的宽度为 1，给定的高度为 [2,1,5,6,2,3]。
//
// 
//
// 
//
// 图中阴影部分为所能勾勒出的最大矩形面积，其面积为 10 个单位。
//
// 
//
// 示例: 
//
// 输入: [2,1,5,6,2,3]
//输出: 10 
// Related Topics 栈 数组 
// 👍 858 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class 柱状图中最大的矩形 {

    //依次遍历柱形的高度，对于每一个高度分别向两边扩散，求出以当前高度为矩形的最大宽度多少。
    //左边看一下，看最多能向左延伸多长，找到大于等于当前柱形高度的最左边元素的下标；
    //
    //右边看一下，看最多能向右延伸多长；找到大于等于当前柱形高度的最右边元素的下标。
    //
    //对于每一个位置，我们都这样操作，得到一个矩形面积，求出它们的最大值。
    //复杂度分析：
    //
    //时间复杂度：O(N^2)，这里 N 是输入数组的长度。
    //空间复杂度：O(1)。
    //看到时间复杂度为 O(N^2)和空间复杂度为O(1) 的组合，那么我们是不是可以一次遍历，不需要中心扩散就能够计算出每一个高度所对应的那个最大面积矩形的面积呢？
    //
    //其实很容易想到的优化的思路就是「以空间换时间」。我们需要在遍历的过程中记录一些信息。

//    public int largestRectangleArea(int[] heights) {
//        int len = heights.length;
//        // 特判
//        if (len == 0) {
//            return 0;
//        }
//        int res = 0;
//        for (int i = 0; i < len; i++) {
//            // 找左边最后1个大于等于 heights[i] 的下标(连续前提下)
//            int left = i;
//            int curHeight = heights[i];
//            while (left > 0 && heights[left - 1] >= curHeight) {
//                left--;
//            }
//            // 找右边最后 1 个大于等于 heights[i] 的索引(连续前提下)
//            int right = i;
//            while (right < len - 1 && heights[right + 1] >= curHeight) {
//                right++;
//            }
//            int width = right - left + 1;
//            res = Math.max(res, width * curHeight);
//        }
//        return res;
//    }


    //方法二：以空间换时间，用到的数据结构是栈
    //我们就拿示例的数组 [2, 1, 5, 6, 2, 3] 为例：
    //1、一开始看到的柱形高度为 2 ，这个时候以这个 2 为高度的最大面积的矩形还不能确定，我们需要继续向右遍历
    //2、然后看到到高度为 1 的柱形，这个时候以这个柱形为高度的矩形的最大面积还是不知道的。但是它之前的以 2 为高度的最大面积的矩形是可以确定的，这是因为这个 1 比 2 小 ，因为这个 1 卡在了这里 2 不能再向右边扩展了
    //我们计算一下以 2 为高度的最大矩形的面积是 2。
    //3、遍历到高度为 5 的柱形，同样的以当前看到柱形为高度的矩形的最大面积也是不知道的，因为我们还要看右边高度的情况。那么它的左右有没有可以确定的柱形呢？没有，这是因为 5 比 1 大，我们看后面马上就出现了 6，不管是 1 这个柱形还是 5 这个柱形，都还可以向右边扩展
    //4、接下来，遍历到高度为 6 的柱形，同样的，以柱形 1、5、6 为高度的最大矩形面积还是不能确定下来
    //5、再接下来，遍历到高度为 2 的柱形
    //发现了一件很神奇的事情，高度为 6 的柱形对应的最大矩形的面积的宽度可以确定下来，它就是夹在高度为 5 的柱形和高度为 2 的柱形之间的距离，它的高度是 6，宽度是 1。
    //接下来柱形 5 对应的最大面积的矩形的宽度也可以确定下来，它是夹在高度为 1 和高度为 2 的两个柱形之间的距离；

    public int largestRectangleArea(int[] heights) {
        int len = heights.length;
        if (len == 0) {
            return 0;
        }
        if (len == 1) {
            return heights[0];
        }
        int res = 0;
        Deque<Integer> stack = new ArrayDeque<>(len);
        for (int i = 0; i < len; i++) {
            // 这个 while 很关键，因为有可能不止一个柱形的最大宽度可以被计算出来
            while (!stack.isEmpty() && heights[i] < heights[stack.peekLast()]) {
                int curHeight = heights[stack.pollLast()];
                while (!stack.isEmpty() && heights[stack.peekLast()] == curHeight) {
                    stack.pollLast();
                }

                int curWidth;
                if (stack.isEmpty()) {
                    curWidth = i;
                } else {
                    curWidth = i - stack.peekLast() - 1;
                }
                res = Math.max(res, curHeight * curWidth);
            }
            stack.addLast(i);
        }
        while (!stack.isEmpty()) {
            int curHeight = heights[stack.pollLast()];
            while (!stack.isEmpty() && heights[stack.peekLast()] == curHeight) {
                stack.pollLast();
            }
            int curWidth;
            if (stack.isEmpty()) {
                curWidth = len;
            } else {
                curWidth = len - stack.peekLast() - 1;
            }
            res = Math.max(res, curHeight * curWidth);
        }
        return res;
    }

}
//leetcode submit region end(Prohibit modification and deletion)
