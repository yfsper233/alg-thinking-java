package com.yfs.graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 给定一个 row x col 的二维网格地图 grid ，其中：grid[i][j] = 1 表示陆地， grid[i][j] = 0 表示水域。
 * <p>
 * 网格中的格子 水平和垂直 方向相连（对角线方向不相连）。整个网格被水完全包围，但其中恰好有一个岛屿（或者说，一个或多个表示陆地的格子相连组成的岛屿）。
 * <p>
 * 岛屿中没有“湖”（“湖” 指水域在岛屿内部且不和岛屿周围的水相连）。格子是边长为 1 的正方形。网格为长方形，且宽度和高度均不超过 100 。计算这个岛屿的周长。
 * <p>
 * 输入：grid = [[0,1,0,0],[1,1,1,0],[0,1,0,0],[1,1,0,0]]
 * 输出：16
 * 解释：它的周长是上面图片中的 16 个黄色的边
 * 示例 2：
 * <p>
 * 输入：grid = [[1]]
 * 输出：4
 * 示例 3：
 * <p>
 * 输入：grid = [[1,0]]
 * 输出：4
 * 提示：
 * <p>
 * row == grid.length
 * col == grid[i].length
 * 1 <= row, col <= 100
 * grid[i][j] 为 0 或 1
 * <p>
 * https://leetcode.cn/problems/island-perimeter/description/
 */
public class Graph_10_岛屿的周长 {
    public static void main(String[] args) {
        int[][] grid = {{0, 1, 0, 0}, {1, 1, 1, 0}, {0, 1, 0, 0}, {1, 1, 0, 0}};
        int res = isLandPerimeter(grid);
    }

    private static int isLandPerimeter(int[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    Queue<int[]> queue = new LinkedList<>();
                    queue.offer(new int[]{i, j});
                    visited[i][j] = true;
                    return bfs(grid, queue, visited);
                }
            }
        }
        return 0;
    }

    private static int bfs(int[][] grid, Queue<int[]> queue, boolean[][] visited) {
        int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int sum = 0;
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            for (int i = 0; i < dir.length; i++) {
                int nx = cur[0] + dir[i][0];
                int ny = cur[1] + dir[i][1];

                if (nx < 0 || nx >= grid.length || ny < 0 || ny >= grid[nx].length ||grid[nx][ny] == 0 ) {
                    sum++;
                    continue;
                }
                if (!visited[nx][ny] && grid[nx][ny] == 1) {
                    queue.add(new int[]{nx, ny});
                    visited[nx][ny] = true;
                }
            }
        }
        return sum;
    }
}
