package leetcode.editor.cn;//n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
//
// 
//
// 上图为 8 皇后问题的一种解法。 
//
// 给定一个整数 n，返回 n 皇后不同的解决方案的数量。 
//
// 示例: 
//
// 输入: 4
//输出: 2
//解释: 4 皇后问题存在如下两个不同的解法。
//[
// [".Q..",  // 解法 1
//  "...Q",
//  "Q...",
//  "..Q."],
//
// ["..Q.",  // 解法 2
//  "Q...",
//  "...Q",
//  ".Q.."]
//]
// 
//
// 
//
// 提示： 
//
// 
// 皇后，是国际象棋中的棋子，意味着国王的妻子。皇后只做一件事，那就是“吃子”。当她遇见可以吃的棋子时，就迅速冲上去吃掉棋子。当然，她横、竖、斜都可走一或 N
//-1 步，可进可退。（引用自 百度百科 - 皇后 ） 
// 
// Related Topics 回溯算法 
// 👍 152 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class N皇后two {
    private int size;
    private int count;

    public int totalNQueens(int n) {
        count = 0;
        //size这里表示的是可以填皇后的位置，比如n=8，1向左移了8位再减一，得到11111111，开始初始化size就是所有可以放皇后的位置
        size = (1 << n) - 1;
        solve(0, 0, 0);
        return count;
    }

    //递归的终止条件
    private void solve(int row, int pie, int na) {
        if (row == size) {
            count++;
            return;
        }
        //当前层能放皇后的所有位置
        int pos = size & (~(row | pie | na));
        while (pos != 0) {
            int p = pos & (-pos);
            pos -= p; //pos &= pos - 1;
            solve(row | p, (pie | p) << 1, (na | p) >> 1);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
