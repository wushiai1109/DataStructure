/**
 * @ClassName JZ51构建乘积数组
 * @Description 给定一个数组A[0, 1, ..., n-1],请构建一个数组B[0,1,...,n-1],其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。
 * 不能使用除法。（注意：规定B[0] = A[1] * A[2] * ... * A[n-1]，B[n-1] = A[0] * A[1] * ... * A[n-2];）
 * 数组
 * @Author Bruce
 * @Date 2020/7/10 6:33 下午
 */
public class JZ51构建乘积数组 {
    public static int[] multiply(int[] A) {
        if (A == null) {
            return null;
        }
        int len = A.length;
        int[] B = new int[len];
        B[0] = 1;
        // 计算前i - 1个元素的乘积
        for (int i = 1; i < A.length; i++) {
            B[i] = A[i - 1] * B[i - 1];
        }
        int temp = 1;
        // 计算后N - i个元素的乘积并连接
        for (int i = len - 1; i >= 1; i--) {
            temp *= A[i];
            B[i - 1] *= temp;
        }
        return B;
    }
}
