package org.example.graph;


//给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
//
//岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
//
//此外，你可以假设该网格的四条边均被水包围。
//
//
//
//示例 1：
//
//输入：grid = [
//["1","1","1","1","0"],
//["1","1","0","1","0"],
//["1","1","0","0","0"],
//["0","0","0","0","0"]
//]
//输出：1
//示例 2：
//
//输入：grid = [
//["1","1","0","0","0"],
//["1","1","0","0","0"],
//["0","0","1","0","0"],
//["0","0","0","1","1"]
//]
public class NumberOfIslands {
    public int numIslands(char[][] grid) {
        if(grid==null || grid.length==0){
            return 0;
        }
        int numIslands = 0;
        int rows = grid.length;
        int cols = grid[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if(grid[i][j]=='1'){
                    numIslands+=dfs(grid,i,j);
                }
            }
        }
        return numIslands;
    }

    private int dfs(char[][] grid, int i, int j) {
        int rows = grid.length;
        int cols = grid[0].length;
        if(i<0||i>=rows||j<0||j>=cols||grid[i][j] == '0'){
            return 0;
        }
        grid[i][j] = '0';
        dfs(grid,i-1,j);
        dfs(grid,i+1,j);
        dfs(grid,i,j-1);
        dfs(grid,i,j+1);
        return 1;
    }
}
