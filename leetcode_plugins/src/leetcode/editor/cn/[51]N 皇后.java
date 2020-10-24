package leetcode.editor.cn;//n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
//
// 
//
// 上图为 8 皇后问题的一种解法。 
//
// 给定一个整数 n，返回所有不同的 n 皇后问题的解决方案。 
//
// 每一种解法包含一个明确的 n 皇后问题的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。 
//
// 
//
// 示例： 
//
// 输入：4
//输出：[
// [".Q..",  // 解法 1
//  "...Q",
//  "Q...",
//  "..Q."],
//
// ["..Q.",  // 解法 2
//  "Q...",
//  "...Q",
//  ".Q.."]
//]
//解释: 4 皇后问题存在两个不同的解法。
// 
//
// 
//
// 提示： 
//
// 
// 皇后彼此不能相互攻击，也就是说：任何两个皇后都不能处于同一条横行、纵行或斜线上。 
// 
// Related Topics 回溯算法 
// 👍 605 👎 0


import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class N皇后51 {

    public static void main(String[] args) {
//        System.out.println("!".repeat(3));

//        StringBuilder row = new StringBuilder();
//        System.out.println(row.append(".".repeat(Math.max(0, 4))));
//        System.out.println(row.replace(1, 1 + 1, "Q"));

//
        System.out.println(new N皇后51().solveNQueens(8));
    }

    private int n;
    // 记录某一列是否放置了皇后
    private boolean[] col;
    // 记录正斜杠上的单元格是否放置了皇后/：0-7，1-8，2-9，……，8-15（若n=8）
    private boolean[] sub;
    // 记录正斜杠上的单元格是否放置了皇后\：7-0，8-1，9-2，……，15-8（若n=8）
    private boolean[] main;
    private List<List<String>> res;

    public List<List<String>> solveNQueens(int n) {
        res = new ArrayList<>();
        if (n == 0) {
            return res;
        }

        // 设置成员变量，减少参数传递
        this.n = n;
        this.col = new boolean[n];
        this.sub = new boolean[2 * n - 1];
        this.main = new boolean[2 * n - 1];
        Deque<Integer> path = new ArrayDeque<>();
        dfs(0, path);
        return res;
    }

    private void dfs(int row, Deque<Integer> path) {
        if (row == n) {
            // 深度优先遍历到下标为 n，表示 [0.. n - 1] 已经填完，得到了一个结果
            List<String> board = convert2board(path);
            res.add(board);
            return;
        }

        // 针对下标为 row 的每一列，尝试是否可以放置
        for (int j = 0; j < n; j++) {
            if (!col[j] && !sub[row + j] && !main[row - j + n - 1]) {
                path.addLast(j);
                col[j] = true;
                sub[row + j] = true;
                main[row - j + n - 1] = true;

                dfs(row + 1, path);

                main[row - j + n - 1] = false;
                sub[row + j] = false;
                col[j] = false;
                path.removeLast();
            }
        }
    }


    private List<String> convert2board(Deque<Integer> path) {
        List<String> board = new ArrayList<>();
        for (Integer num : path) {
            StringBuilder row = new StringBuilder();
            row.append(".".repeat(Math.max(0, n)));
            row.replace(num, num + 1, "Q");
            board.add(row.toString());
        }
        return board;
    }

}
//leetcode submit region end(Prohibit modification and deletion)
