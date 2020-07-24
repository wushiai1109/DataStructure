package SetMap;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Wushiai
 * @date 2020/3/9 10:45
 * @content 给定一个二维平面，平面上有 n 个点，求最多有多少个点在同一条直线上。
 *
 * 示例 1:
 *
 * 输入: [[1,1],[2,2],[3,3]]
 * 输出: 3
 * 解释:
 * ^
 * |
 * |        o
 * |     o
 * |  o  
 * +------------->
 * 0  1  2  3  4
 * 示例 2:
 *
 * 输入: [[1,1],[3,2],[5,3],[4,1],[2,3],[1,4]]
 * 输出: 4
 * 解释:
 * ^
 * |
 * |  o
 * |     o        o
 * |        o
 * |  o        o
 * +------------------->
 * 0  1  2  3  4  5  6
 */
public class 直线上最多的点数149 {
    public static void main(String[] args) {
        int [][]points={{1,1},{3,2},{5,3},{4,1},{2,3},{1,4}};
        System.out.println(new 直线上最多的点数149().maxPoints(points));
    }

    public int maxPoints(int[][] points) {
        int n = points.length;
        if (n == 0)
            return 0;
        if (n == 1)
            return 1;
        int res = 0;
        for (int i = 0; i < n - 1; i++) {
            Map<String, Integer> map = new HashMap<>();
            int repeat = 0;
            int tmp_max = 0;
            for (int j = i + 1; j < n; j++) {
                int dy = points[i][1] - points[j][1];
                int dx = points[i][0] - points[j][0];
                if (dy == 0 && dx == 0) {
                    repeat++;
                    continue;
                }
                int g = gcd(dy, dx);
                if (g != 0) {
                    dy /= g;
                    dx /= g;
                }
                //斜率
                String tmp = String.valueOf(dy) + "/" + String.valueOf(dx);
                map.put(tmp, map.getOrDefault(tmp, 0) + 1);
                //在此斜率上的点的数量(从0开始计数，并且不包含)
                tmp_max = Math.max(tmp_max, map.get(tmp));
            }
            res = Math.max(res, repeat + tmp_max + 1);
        }
        return res;
    }

    //求最大公约数
    private int gcd(int dy, int dx) {
        if (dx == 0)
            return dy;
        else
            return gcd(dx, dy % dx);
    }
}
