package com.yfs.graph;

/**
 * 695. 岛屿的最大面积
 * <p>
 * 给你一个大小为 m x n 的二进制矩阵 grid 。
 * <p>
 * 岛屿 是由一些相邻的 1 (代表土地) 构成的组合，这里的「相邻」要求两个 1 必须在 水平或者竖直的四个方向上 相邻。你可以假设 grid 的四个边缘都被 0（代表水）包围着。
 * <p>
 * 岛屿的面积是岛上值为 1 的单元格的数目。
 * <p>
 * 计算并返回 grid 中最大的岛屿面积。如果没有岛屿，则返回面积为 0 。
 * <p>
 * https://leetcode.cn/problems/max-area-of-island/description/
 */
public class Graph_3_岛屿的最大面积 {

    public static void main(String[] args) {
        int[][] grid = {{1, 1}, {1, 0}};
        int res = maxAreaOfIsland(grid);
    }

    public static int maxAreaOfIsland(int[][] grid) {
        boolean[][] tags = new boolean[grid.length][grid[0].length];
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {

                if (!tags[i][j] && grid[i][j] == 1) {
                    int count = dfs(grid, i, j, tags);
                    res = Math.max(count, res);
                }
            }
        }
        return res;
    }

    private static int dfs(int[][] grid, int i, int j, boolean[][] tags) {
        // 越界、不是陆地、已经被遍历过
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] != 1 || tags[i][j]) {
            return 0;
        }
        if (!tags[i][j] && grid[i][j] == 1) {
            tags[i][j] = true;
        }
        return dfs(grid, i + 1, j, tags)
                +
                dfs(grid, i - 1, j, tags)
                +
                dfs(grid, i, j + 1, tags)
                +
                dfs(grid, i, j - 1, tags)
                + 1;

    }
}
