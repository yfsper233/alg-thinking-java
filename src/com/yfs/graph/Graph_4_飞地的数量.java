package com.yfs.graph;

import javax.xml.stream.FactoryConfigurationError;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 1020. 飞地的数量
 * <p>
 * 给你一个大小为 m x n 的二进制矩阵 grid ，其中 0 表示一个海洋单元格、1 表示一个陆地单元格。
 * <p>
 * 一次 移动 是指从一个陆地单元格走到另一个相邻（上、下、左、右）的陆地单元格或跨过 grid 的边界。
 * <p>
 * 返回网格中 无法 在任意次数的移动中离开网格边界的陆地单元格的数量。
 * <p>
 * https://leetcode.cn/problems/number-of-enclaves/description/
 */
public class Graph_4_飞地的数量 {
    public static void main(String[] args) {
        int[][] grid = {
                {0},{1},{1},{0},{0}
        };

        int res = numEnclaves(grid);
    }

    public static int numEnclaves(int[][] grid) {
        int res = 0;
        boolean[][] tags = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1 && !tags[i][j]) {
                    Queue<int[]> queue = new LinkedList<>();
                    queue.add(new int[]{i,j});
                    tags[i][j] = true;
                    // 广搜
                    int count = bfs(grid, queue, tags);
                    res += count;
                }
            }
        }
        return res;
    }

    private static int bfs(int[][] grid, Queue<int[]> queue, boolean[][] tags) {
        int count = 0;
        boolean hasExits = false;
        int[][] dir = {
                {1, 0},
                {0, 1},
                {-1, 0},
                {0, -1}
        };
        while (!queue.isEmpty()) {
            int[] plot = queue.poll();
            int x = plot[0];
            int y = plot[1];
            count++;
            if (x == 0 || y == 0 || x == grid.length - 1 || y == grid[x].length - 1) {
                hasExits = true;
            }
            for (int i = 0; i < dir.length; i++) {
                    int nx = x + dir[i][0];
                    int ny = y + dir[i][1];
                    if (nx >= 0 && nx <= grid.length - 1
                            && ny >= 0 && ny <= grid[x].length - 1
                            && !tags[nx][ny] && grid[nx][ny] == 1) {
                        queue.add(new int[]{nx,ny});
                        tags[nx][ny] = true;

                }
            }
        }
        return !hasExits ? count : 0;
    }

}
