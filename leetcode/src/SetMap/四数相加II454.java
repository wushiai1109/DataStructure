package SetMap;

import java.util.HashMap;

/**
 * @author Wushiai
 * @date 2020/3/5 16:22
 * @content 给定四个包含整数的数组列表 A , B , C , D ,计算有多少个元组 (i, j, k, l) ，使得 A[i] + B[j] + C[k] + D[l] = 0。
 * <p>
 * 为了使问题简单化，所有的 A, B, C, D 具有相同的长度 N，且 0 ≤ N ≤ 500 。所有整数的范围在 -228 到 228 - 1 之间，最终结果不会超过 231 - 1 。
 * <p>
 * 例如:
 * <p>
 * 输入:
 * A = [ 1, 2]
 * B = [-2,-1]
 * C = [-1, 2]
 * D = [ 0, 2]
 * <p>
 * 输出:
 * 2
 * <p>
 * 解释:
 * 两个元组如下:
 * 1. (0, 0, 0, 1) -> A[0] + B[0] + C[0] + D[1] = 1 + (-2) + (-1) + 2 = 0
 * 2. (1, 1, 0, 0) -> A[1] + B[1] + C[0] + D[0] = 2 + (-1) + (-1) + 0 = 0
 */
public class 四数相加II454 {
    public static void main(String[] args) {
        int[] a = {1, 2};
        int[] b = {-2, -1};
        int[] c = {-1, 2};
        int[] d = {0, 2};
        System.out.println(new 四数相加II454().fourSumCount(a, b, c, d));
    }

    //方法1：暴力解法O(n^4)

    //方法2：将D中的元素放入查找表,遍历ABC,在查找表中查找0-D[l]的A[i]+B[j]+C[k]：O(n^3)

    //方法3：将C+D的每一种可能放入查找表：O(n^2)

    //时间复杂度：O(n^2)
    //空间复杂度：O(n^2)
//    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
//
//        if (A == null || B == null || C == null || D == null)
//            throw new IllegalArgumentException("Illegal argument");
//
//        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
//        //将C+D的每一种可能放入查找表
//        for (int i = 0; i < C.length; i++)
//            for (int j = 0; j < D.length; j++) {
//                int sum = C[i] + D[j];
//                if (map.containsKey(sum))
//                    map.put(sum, map.get(sum) + 1);
//                else
//                    map.put(sum, 1);
//            }
//        int res = 0;
//        //遍历AB
//        for (int i = 0; i < A.length; i++)
//            for (int j = 0; j < B.length; j++)
//                if (map.containsKey(-A[i] - B[j]))
//                    res += map.get(-A[i] - B[j]);
//
//        return res;
//    }

    //方法4：将A+B和C+D的每一种可能放入两个查找表,之后循环这两个查找表：O(n^2)
    //时间复杂度：O(n^2)
    //空间复杂度：O(n^2)
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        if (A == null || B == null || C == null || D == null)
            throw new IllegalArgumentException("Illegal argument");

        HashMap<Integer, Integer> mapAB = new HashMap<Integer, Integer>();
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                mapAB.put(A[i] + B[j], mapAB.getOrDefault(A[i] + B[j], 0) + 1);
            }
        }
        HashMap<Integer, Integer> mapCD = new HashMap<Integer, Integer>();
        for (int i = 0; i < C.length; i++) {
            for (int j = 0; j < D.length; j++) {
                mapCD.put(C[i] + D[j], mapCD.getOrDefault(C[i] + D[j], 0) + 1);
            }
        }
        int res = 0;
        for (Integer sumAB : mapAB.keySet()) {
            if (mapCD.containsKey(-sumAB))
                res += mapAB.get(sumAB) * mapCD.get(-sumAB);
        }

        return res;
    }
}
