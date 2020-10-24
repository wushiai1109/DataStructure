package leetcode.editor.cn;//给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
//
// 岛屿总是被水包围，并且每座岛屿只能由水平方向或竖直方向上相邻的陆地连接形成。 
//
// 此外，你可以假设该网格的四条边均被水包围。 
//
// 
//
// 示例 1: 
//
// 输入:
//[
//['1','1','1','1','0'],
//['1','1','0','1','0'],
//['1','1','0','0','0'],
//['0','0','0','0','0']
//]
//输出: 1
// 
//
// 示例 2: 
//
// 输入:
//[
//['1','1','0','0','0'],
//['1','1','0','0','0'],
//['0','0','1','0','0'],
//['0','0','0','1','1']
//]
//输出: 3
//解释: 每座岛屿只能由水平和/或竖直方向上相邻的陆地连接而成。
// 
// Related Topics 深度优先搜索 广度优先搜索 并查集 
// 👍 764 👎 0


import org.w3c.dom.ls.LSOutput;

//leetcode submit region begin(Prohibit modification and deletion)
class 岛屿数量200 {
    public static void main(String[] args) {
        char[][] grid = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };
//        char[][] grid = {
//                {'1', '1', '0', '1', '0', '0', '1', '1'}
//        };
//        char[][] grid = {
//                {'1'}
//        };
        System.out.println(new 岛屿数量200().numIslands(grid));
    }

    void dfs(char[][] grid, int i, int j) {
        int row = grid.length;
        int column = grid[0].length;

        if (i < 0 || j < 0 || i >= row || j >= column || grid[i][j] == '0') {
            return;
        }

        grid[i][j] = '0';
        dfs(grid, i - 1, j);
        dfs(grid, i + 1, j);
        dfs(grid, i, j - 1);
        dfs(grid, i, j + 1);
    }

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int row = grid.length;
        int column = grid[0].length;

        int countIslands = 0;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (grid[i][j] == '1') {
                    ++countIslands;
                    dfs(grid, i, j);
                }
            }
        }
        return countIslands;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
