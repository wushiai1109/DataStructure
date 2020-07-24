/**
 * @ClassName 数组中求第一个未出现的数字
 * @Description 给出一个n的数组，求第一个未出现的数字，例如1 2 3 5 6 输出 4.
 * 解法： 给一个n+3长度数组ret，if(输入数字大于n) continue，else ret[数字]=1，然后遍历ret，看是那一个数字没有，返回该数字。
 * 有可能是返回n+1或者n+2,所以要设大一点.
 * @Author Bruce
 * @Date 2020/7/17 8:55 下午
 */
public class 数组中求第一个未出现的数字 {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 5, 6};
        System.out.println(new 数组中求第一个未出现的数字().nextPermutation(arr));
    }

    public int nextPermutation(int[] nums) {
        int[] res = new int[nums.length + 3];
        for (int i : nums) {
            if (i > nums.length) {
                break;
            }
            res[i] = 1;
        }
        for (int i = 0; i < nums.length; i++) {
            if (res[i + 1] != 1) {
                return --nums[i];
            }
        }
        return 0;
    }
}
