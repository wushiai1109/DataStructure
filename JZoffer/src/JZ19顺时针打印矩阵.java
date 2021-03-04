import java.util.ArrayList;

/**
 * @ClassName JZ19顺时针打印矩阵
 * @Description 本题知识点： 数组
 * 题目描述
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，
 * 例如，如果输入如下4 X 4矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16
 * 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 * 1  2  3  4
 * 5  6  7  8
 * 9  10 11 12
 * 13 14 15 16
 * 示例1
 * 输入
 * [[1,2],[3,4]]
 * 1 2
 * 3 4
 * 返回值
 * [1,2,4,3]
 * @Author Bruce
 * @Date 2021/2/10 下午4:09
 */
public class JZ19顺时针打印矩阵 {

    public ArrayList<Integer> printMatrix(int[][] matrix) {
        ArrayList<Integer> list = new ArrayList<>();
        int l = 0, r = matrix[0].length - 1;
        int m = 0, n = matrix.length - 1;
        while (true) {
            for (int i = l; i <= r; i++) {
                list.add(matrix[m][i]);
            }
            if (++m > n) {
                break;
            }
            for (int i = m; i <= n; i++) {
                list.add(matrix[i][r]);
            }
            if (l > --r) {
                break;
            }
            for (int i = r; i >= l; i--) {
                list.add(matrix[n][i]);
            }
            if (m > --n) {
                break;
            }
            for (int i = n; i >= m; i--) {
                list.add(matrix[i][l]);
            }
            if (++l > r) {
                break;
            }
        }
        return list;
    }
}
