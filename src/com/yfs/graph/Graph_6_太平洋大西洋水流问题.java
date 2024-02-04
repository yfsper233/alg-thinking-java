package com.yfs.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 417. 太平洋大西洋水流问题
 * <p>
 * 有一个 m × n 的矩形岛屿，与 太平洋 和 大西洋 相邻。 “太平洋” 处于大陆的左边界和上边界，而 “大西洋” 处于大陆的右边界和下边界。
 * <p>
 * 这个岛被分割成一个由若干方形单元格组成的网格。给定一个 m x n 的整数矩阵 heights ， heights[r][c] 表示坐标 (r, c) 上单元格 高于海平面的高度 。
 * <p>
 * 岛上雨水较多，如果相邻单元格的高度 小于或等于 当前单元格的高度，雨水可以直接向北、南、东、西流向相邻单元格。水可以从海洋附近的任何单元格流入海洋。
 * <p>
 * 返回网格坐标 result 的 2D 列表 ，其中 result[i] = [ri, ci] 表示雨水从单元格 (ri, ci) 流动 既可流向太平洋也可流向大西洋 。
 * <p>
 * 输入: heights = [[1,2,2,3,5],[3,2,3,4,4],[2,4,5,3,1],[6,7,1,4,5],[5,1,1,2,4]]
 * 输出: [[0,4],[1,3],[1,4],[2,2],[3,0],[3,1],[4,0]]
 * 示例 2：
 * <p>
 * 输入: heights = [[2,1],[1,2]]
 * 输出: [[0,0],[0,1],[1,0],[1,1]]
 * 提示：
 * <p>
 * m == heights.length
 * n == heights[r].length
 * 1 <= m, n <= 200
 * 0 <= heights[r][c] <= 10^5
 * <p>
 * https://leetcode.cn/problems/pacific-atlantic-water-flow/description/
 */
public class Graph_6_太平洋大西洋水流问题 {
    public static void main(String[] args) {
//        int[][] heights = {{1, 2, 2, 3, 5}, {3, 2, 3, 4, 4}, {2, 4, 5, 3, 1}, {6, 7, 1, 4, 5}, {5, 1, 1, 2, 4}};
//        int[][] heights = {{1,1},{1,1},{1,1}};
        int[][] heights = {{3,3,3,3,3,3},{3,0,3,3,0,3},{3,3,3,3,3,3}};
        List<List<Integer>> res = pacificAtlantic(heights);
    }

    public static List<List<Integer>> pacificAtlantic(int[][] heights) {
        // 由四周开始搜索 有路径的置为true
        // 到太平洋有路径的为true
        boolean[][] pacificTags = new boolean[heights.length][heights[0].length];
        // 到大西洋有路径的为true
        boolean[][] atlanticTags = new boolean[heights.length][heights[0].length];

        for (int i = 0; i < heights.length; i++) {
            for (int j = 0; j < heights[i].length; j++) {
                if ((i == 0 || j == 0) && !pacificTags[i][j]) {
                    Queue<int[]> queue = new LinkedList<>();
                    queue.add(new int[]{i, j});
                    pacificTags[i][j] = true;
                    bfs(queue, heights, pacificTags);
                }

                if ((i == heights.length - 1 || j == heights[i].length - 1) && !atlanticTags[i][j]) {
                    Queue<int[]> queue = new LinkedList<>();
                    queue.add(new int[]{i, j});
                    atlanticTags[i][j] = true;
                    bfs(queue, heights, atlanticTags);
                }
            }
        }
        List<List<Integer>> resList = new ArrayList<>();
        for (int i = 0; i < heights.length; i++) {
            for (int j = 0; j < heights[i].length; j++) {
                if (pacificTags[i][j] && atlanticTags[i][j]){
                    ArrayList<Integer> list = new ArrayList<>();
                    list.add(i);
                    list.add(j);
                    resList.add(list);
                }
            }
        }
        return resList;
    }

    private static void bfs(Queue<int[]> queue, int[][] heights, boolean[][] tags) {
        int[][] dir = {{1, 0}, {-1, 0}, {0, -1}, {0, 1}};
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0];
            int y = cur[1];

            for (int i = 0; i < dir.length; i++) {
                int nx = cur[0] + dir[i][0];
                int ny = cur[1] + dir[i][1];
                if (nx < 0 || nx >= heights.length || ny < 0 || ny >= heights[x].length) {
                    continue;
                }
                if (!tags[nx][ny] && heights[nx][ny] >= heights[x][y]) {
                    tags[nx][ny] = true;
                    queue.offer(new int[]{nx, ny});
                }
            }
        }
    }
}
