/**
 * @ClassName JZ23二叉搜索树的后序遍历序列
 * @Description 本题知识点： 栈 树
 * 题目描述
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。如果是则返回true,否则返回false。假设输入的数组的任意两个数字都互不相同。
 * 示例1
 * 输入
 * [4,8,6,12,16,14,10]
 * 返回值
 * true
 * @Author Bruce
 * @Date 2021/2/10 下午12:51
 */
public class JZ23二叉搜索树的后序遍历序列 {

    public boolean VerifySquenceOfBST(int[] sequence) {
        if (sequence == null || sequence.length == 0) {
            return false;
        }
        return process(sequence, 0, sequence.length - 1);
    }

    public boolean process(int[] arr, int start, int end) {
        if (start >= end) {
            return true;
        }
        int left = start;
        int root = arr[end];
        while (arr[left] < root) {
            left++;
        }
        int right = left;
        for (; left < end; left++) {
            if (arr[left] < root) {
                return false;
            }
        }
        return process(arr, start, right - 1) && process(arr, right, end - 1);
    }

}
