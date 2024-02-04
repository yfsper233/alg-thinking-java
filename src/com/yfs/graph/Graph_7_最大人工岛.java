package com.yfs.graph;

import java.util.HashMap;
import java.util.HashSet;

/**
 * 827.最大人工岛
 * <p>
 * 给你一个大小为 n x n 二进制矩阵 grid 。最多 只能将一格 0 变成 1 。
 * <p>
 * 返回执行此操作后，grid 中最大的岛屿面积是多少？
 * <p>
 * 岛屿 由一组上、下、左、右四个方向相连的 1 形成。
 * <p>
 * 示例 1:
 * <p>
 * 输入: grid = [[1, 0], [0, 1]]
 * 输出: 3
 * 解释: 将一格0变成1，最终连通两个小岛得到面积为 3 的岛屿。
 * 示例 2:
 * <p>
 * 输入: grid = [[1, 1], [1, 0]]
 * 输出: 4
 * 解释: 将一格0变成1，岛屿的面积扩大为 4。
 * 示例 3:
 * <p>
 * 输入: grid = [[1, 1], [1, 1]]
 * 输出: 4
 * 解释: 没有0可以让我们变成1，面积依然为 4。
 * <p>
 * https://leetcode.cn/problems/making-a-large-island/description/
 */
public class Graph_7_最大人工岛 {
    public static void main(String[] args) {
        int[][] grid = {{1, 1}, {1, 0}};
        int res = largestIsland(grid);
    }

    private static int largestIsland(int[][] grid) {
        // 先全局搜索，找到孤立的所有岛屿，为每个岛屿编号
        // 在遍历所有海洋点，将与其相邻的岛屿面积相加，从而求出最大值
        int[][] tags = new int[grid.length][grid[0].length];
        Integer no = 1;
        // 统计岛屿面积
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1 && tags[i][j] == 0) {
                    tags[i][j] = no;
                    map.put(no, dfs(grid, i, j, tags, no));
                    no++;
                }
            }
        }
        // 找出连接后的最大面积
        int max = -1;
        int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 0) {
                    HashSet<Integer> set = new HashSet<>();
                    for (int k = 0; k < dir.length; k++) {
                        int nx = dir[k][0] + i;
                        int ny = dir[k][1] + j;
                        if (nx < 0 || nx >= grid.length || ny < 0 || ny >= grid[i].length
                        ) {
                            continue;
                        }
                        set.add(tags[nx][ny]);
                    }
                    int curSum = 1;
                    for (Integer num : set) {
                        curSum += map.getOrDefault(num, 0);

                    }
                    max = Math.max(curSum, max);
                }
            }
        }
        return max < 0 ? grid.length * grid.length : max;
    }

    private static int dfs(int[][] grid, int x, int y, int[][] tags, Integer no) {
        int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        int count = 1;
        for (int i = 0; i < dir.length; i++) {
            int nx = dir[i][0] + x;
            int ny = dir[i][1] + y;
            if (nx < 0 || nx >= grid.length || ny < 0 || ny >= grid[x].length
                    || grid[nx][ny] == 0 || tags[nx][ny] != 0) {
                continue;
            }
            tags[nx][ny] = no;
            count +=  dfs(grid, nx, ny, tags, no);
        }
        return count;
    }
}
