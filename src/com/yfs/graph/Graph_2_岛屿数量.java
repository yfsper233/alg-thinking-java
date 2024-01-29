package com.yfs.graph;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 200. 岛屿数量
 * <p>
 * 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
 * <p>
 * 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
 * <p>
 * 此外，你可以假设该网格的四条边均被水包围。
 * <p>
 * 示例 1：
 * <p>
 * 输入：grid = [
 * ["1","1","1","1","0"],
 * ["1","1","0","1","0"],
 * ["1","1","0","0","0"],
 * ["0","0","0","0","0"]
 * ]
 * 输出：1
 * 示例 2：
 * <p>
 * 输入：grid = [
 * ["1","1","0","0","0"],
 * ["1","1","0","0","0"],
 * ["0","0","1","0","0"],
 * ["0","0","0","1","1"]
 * ]
 * 输出：3
 * <p>
 * <p>
 * 提示：
 * <p>
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 300
 * grid[i][j] 的值为 '0' 或 '1'
 * <p>
 * https://leetcode.cn/problems/number-of-islands/description/
 */
public class Graph_2_岛屿数量 {
    public static void main(String[] args) {
        char[][] grid = {
                {'1', '1'},
                {'0', '1'}
        };
        int res = numIslands(grid);
        int res2 = numIslandsII(grid);
    }

    private static int numIslandsII(char[][] grid) {
        int count = 0;
        boolean[][] tags = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (!tags[i][j] && grid[i][j] == '1') {
                    count++;
                    Deque<int[]> queue = new LinkedList<>();
                    queue.add(new int[]{i, j});
                    // 只要加入队列就标记为已访问
                    tags[i][j] = true;
                    bfs(tags, grid, queue);
                }
            }
        }
        return count;
    }

    private static void bfs(boolean[][] tags, char[][] grid, Deque<int[]> queue) {
        int[][] dir = {
                {1, 0},
                {0, 1},
                {-1, 0},
                {0, -1}
        };
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            for (int i = 0; i < dir.length; i++) {
                int nx = cur[0] + dir[i][0];
                int ny = cur[1] + dir[i][1];
                if (nx < 0 || nx >= grid.length || ny < 0 || ny >= grid[0].length || grid[nx][ny] != '1' || tags[nx][ny]) {
                    continue;
                }
                tags[nx][ny] = true;
                queue.addLast(new int[]{nx, ny});
            }
        }

    }

    public static int numIslands(char[][] grid) {
        int count = 0;
        boolean[][] tags = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (!tags[i][j] && grid[i][j] == '1') {
                    count++;
                    dfs(tags, grid, i, j);
                }
            }
        }
        return count;
    }

    private static void dfs(boolean[][] tags, char[][] grid, int x, int y) {
        int[][] dir = {
                {1, 0},
                {0, 1},
                {-1, 0},
                {0, -1}
        };
        for (int i = 0; i < dir.length; i++) {
            int nx = x + dir[i][0];
            int ny = y + dir[i][1];
            if (nx < 0 || nx >= grid.length || ny < 0 || ny >= grid[0].length) {
                continue;
            }
            if (grid[nx][ny] == '1' && !tags[nx][ny]) {
                tags[nx][ny] = true;
                dfs(tags, grid, nx, ny);
            }
        }

    }
}
