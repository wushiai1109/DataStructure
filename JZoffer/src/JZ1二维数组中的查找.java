/**
 * @ClassName JZ1二维数组中的查找
 * @Description 本题知识点： 数组
 * 题目描述
 * 在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 * 示例1
 * 输入
 * 复制
 * 7,[[1,2,8,9],[2,4,9,12],[4,7,10,13],[6,8,11,15]]
 * 返回值
 * 复制
 * true
 * @Author Bruce
 * @Date 2021/1/24 下午2:12
 */
public class JZ1二维数组中的查找 {
    public boolean Find(int target, int[][] array) {
        if (array == null || array[0].length == 0) {
            return false;
        }
        boolean flag = false;
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array[0].length - 1; j++) {
                if (array[i][j] == target) {
                    flag = true;
                }
                if (array[i][j] > array[i][j + 1] || array[i][j] > array[i + 1][j]) {
                    return false;
                }
            }
        }
        return flag;
    }
}
