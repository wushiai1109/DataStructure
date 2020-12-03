package leetcode.editor.cn;//给出 R 行 C 列的矩阵，其中的单元格的整数坐标为 (r, c)，满足 0 <= r < R 且 0 <= c < C。
//
// 另外，我们在该矩阵中给出了一个坐标为 (r0, c0) 的单元格。 
//
// 返回矩阵中的所有单元格的坐标，并按到 (r0, c0) 的距离从最小到最大的顺序排，其中，两单元格(r1, c1) 和 (r2, c2) 之间的距离是曼哈
//顿距离，|r1 - r2| + |c1 - c2|。（你可以按任何满足此条件的顺序返回答案。） 
//
// 
//
// 示例 1： 
//
// 输入：R = 1, C = 2, r0 = 0, c0 = 0
//输出：[[0,0],[0,1]]
//解释：从 (r0, c0) 到其他单元格的距离为：[0,1]
// 
//
// 示例 2： 
//
// 输入：R = 2, C = 2, r0 = 0, c0 = 1
//输出：[[0,1],[0,0],[1,1],[1,0]]
//解释：从 (r0, c0) 到其他单元格的距离为：[0,1,1,2]
//[[0,1],[1,1],[0,0],[1,0]] 也会被视作正确答案。
// 
//
// 示例 3： 
//
// 输入：R = 2, C = 3, r0 = 1, c0 = 2
//输出：[[1,2],[0,2],[1,1],[0,1],[1,0],[0,0]]
//解释：从 (r0, c0) 到其他单元格的距离为：[0,1,1,2,2,3]
//其他满足题目要求的答案也会被视为正确，例如 [[1,2],[1,1],[0,2],[1,0],[0,1],[0,0]]。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= R <= 100 
// 1 <= C <= 100 
// 0 <= r0 < R 
// 0 <= c0 < C 
// 
// Related Topics 排序 
// 👍 82 👎 0


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class 距离顺序排列矩阵单元格1030 {
    public static void main(String[] args) {
        int[][] ints = new 距离顺序排列矩阵单元格1030().allCellsDistOrder(2, 3, 1, 2);
        for (int[] a : ints) {
            System.out.println(Arrays.toString(a));
        }
    }

//    //桶排序
//    //遍历所有坐标，按照距离的大小分组，每组的距离相等（即放入一个桶中）
//    //按照距离从小到大的原则，遍历所有桶，并输出结果
//    //本解法关键在于求得可能的最大距离，即行距离和列距离都最大时：max(r0, R - 1 - r0) + max(c0, C - 1 - c0)
//    //注意：
//    //此解法时间复杂度为 O(R*C)，理论上已达到最快可能
//    //实际时间消耗会比预估要差，不同语言便利程度和优化不一，原因如下：
//    //桶的制作涉及大量容器的初始化和存取
//    //桶中要存储大量的坐标信息，不论是直接使用长度为 2 的小数组存储，还是用新的简单数据类，都会耗费很多时间
//    //时间复杂度：O(RC)，存储所有点时间复杂度 O(RC)，桶排序时间复杂度 O(RC)。
//    //空间复杂度：O(RC)，需要存储矩阵内所有点
//    public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
//
//        int maxDist = Math.max(r0, R - 1 - r0) + Math.max(c0, C - 1 - c0);
//
//        List<List<int[]>> bucket = new ArrayList<>();
//        for (int i = 0; i <= maxDist; i++) {
//            bucket.add(new ArrayList<>());
//        }
//
//        for (int i = 0; i < R; i++) {
//            for (int j = 0; j < C; j++) {
//                int d = dist(i, j, r0, c0);
//                bucket.get(d).add(new int[]{i, j});
//            }
//        }
//        int[][] ret = new int[R * C][2];
//        int index = 0;
//        for (int i = 0; i <= maxDist; i++) {
//            for (int[] it : bucket.get(i)) {
//                ret[index++] = it;
//            }
//        }
//        return ret;
//    }
//
//    public int dist(int r1, int c1, int r2, int c2) {
//        return Math.abs(r1 - r2) + Math.abs(c1 - c2);
//    }

    //BFS
    //可以把所有的坐标看作树的结点，距离相等的结点位于树的同一层
    //而对于每一层的结点，它们的距离 dist 可以分为行距离和列距离，且 rowDist + colDist = dist 必然成立
    //使 rowDist 从 0 到 dist 递增，colDist 相应有不同的值，可以得到不同的坐标：
    //横坐标为：r0 - rowDist 或 r0 + rowDist
    //纵坐标为：c0 - colDist 或 c0 + colDist
    //注意特殊情况：rowDist 或 colDist 为 0 时，每组只有一个正确值
    //对步骤 3 中，所有在矩阵范围内的坐标进行记录
    //注意：
    //此解法不关心最大距离，只要步骤 4 中记录的结果达到 R * C 的数量就可以终止搜索
    //此解法的时间复杂度是 O((R+C)^2)，因为对每一种距离 dist，rowDist 都要进行从0开始递增到dist的遍历操作，而距离可能的最大值为R+C
    //此解法时间复杂度大于 O(R * C) 的原因是：每种距离可能产生多个不在矩阵内的坐标，但搜索算法必须依次检查予以排除
    //理论上此解法并不比桶排序优秀，但是代码中极少创建额外的容器和对象，所以实际的运行效率不会太差
    public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
        int[][] ret = new int[R * C][2];
        int dist = 0;
        int count = 0;
        //横坐标为：r0-rowDist或r0+rowDist，纵坐标为：c0-colDist或c0+colDist
        int[] factor = {-1, 1};

        while (count < R * C) {

            for (int rowDist = 0; rowDist <= dist; rowDist++) {
                int colDist = dist - rowDist;

                for (int i = 0; i < 2; i++) {
                    int row = r0 + factor[i] * rowDist;
                    for (int j = 0; j < 2; j++) {
                        int col = c0 + factor[j] * colDist;
                        //0<=row<R and 0<=col<C
                        if (row >= 0 && row < R && col >= 0 && col < C) {
                            ret[count][0] = row;
                            ret[count][1] = col;
                            count++;
                        }
                        if (colDist == 0) {
                            break;
                        }
                    }
                    if (rowDist == 0) {
                        break;
                    }
                }

            }

            dist++;

        }

        return ret;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
