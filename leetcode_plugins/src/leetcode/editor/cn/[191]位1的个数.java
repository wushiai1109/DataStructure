package leetcode.editor.cn;//编写一个函数，输入是一个无符号整数，返回其二进制表达式中数字位数为 ‘1’ 的个数（也被称为汉明重量）。
//
// 
//
// 示例 1： 
//
// 输入：00000000000000000000000000001011
//输出：3
//解释：输入的二进制串 00000000000000000000000000001011 中，共有三位为 '1'。
// 
//
// 示例 2： 
//
// 输入：00000000000000000000000010000000
//输出：1
//解释：输入的二进制串 00000000000000000000000010000000 中，共有一位为 '1'。
// 
//
// 示例 3： 
//
// 输入：11111111111111111111111111111101
//输出：31
//解释：输入的二进制串 11111111111111111111111111111101 中，共有 31 位为 '1'。 
//
// 
//
// 提示： 
//
// 
// 请注意，在某些语言（如 Java）中，没有无符号整数类型。在这种情况下，输入和输出都将被指定为有符号整数类型，并且不应影响您的实现，因为无论整数是有符号的
//还是无符号的，其内部的二进制表示形式都是相同的。 
// 在 Java 中，编译器使用二进制补码记法来表示有符号整数。因此，在上面的 示例 3 中，输入表示有符号整数 -3。 
// 
//
// 
//
// 进阶: 
//如果多次调用这个函数，你将如何优化你的算法？ 
// Related Topics 位运算 
// 👍 225 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class 位1的个数191 {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        //时间复杂度：O(1)。运行时间与n中位为1的有关。在最坏情况下，n中所有位都是1。对于32位整数，运行时间是O(1)的。
        //空间复杂度：O(1)。没有使用额外空间。
        //1.for loop:0-->32  (需要32次)
        //2.%2看最低位是否为1,/2相当于打掉最后一位 (需要32次)
        //3.&1,x=x>>1; (需要32次)
        //4.x=x&(x-1)清零最低位的1：while(x>0){ count++; x=x&(x-1); } (有多少个1需要多少次)
        int sum = 0;
        while (n != 0) {
            sum++;
            n &= (n - 1);
        }
        return sum;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
