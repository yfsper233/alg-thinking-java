package com.yfs.dynamicprogramming;

/**
 * 63 不同路径II
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。
 * <p>
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish”）。
 * <p>
 * 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
 * <p>
 * 网格中的障碍物和空位置分别用 1 和 0 来表示。
 * <p>
 * 示例1：
 * 输入：obstacleGrid = [[0,0,0],[0,1,0],[0,0,0]]
 * 输出：2
 * 解释：3x3 网格的正中间有一个障碍物。
 * 从左上角到右下角一共有 2 条不同的路径：
 * 1. 向右 -> 向右 -> 向下 -> 向下
 * 2. 向下 -> 向下 -> 向右 -> 向右
 * <p>
 * 示例2：
 * 输入：obstacleGrid = [[0,1],[0,0]]
 * 输出：1
 * <p>
 * <p>
 * 提示：
 * <p>
 * m == obstacleGrid.length
 * n == obstacleGrid[i].length
 * 1 <= m, n <= 100
 * obstacleGrid[i][j] 为 0 或 1
 * <p>
 * https://leetcode.cn/problems/unique-paths-ii/
 */
public class DP_5_UniquePathsII {
    public static void main(String[] args) {
        int[][] obstacleGrid = {{0}};
        int res = uniquePathsII(obstacleGrid);
    }

    private static int uniquePathsII(int[][] obstacleGrid) {
        // dp[m][n] 到达下标为m、n位置的路径数量
        int[][] dp = new int[obstacleGrid.length][obstacleGrid[0].length];
        // 递推公式 dp[m][n] = dp[m-1][n] + dp[m][n-1];
        if (obstacleGrid[0][0] != 1){
            dp[0][0] = 1;
        }
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                if (i == 0 && j > 0 && obstacleGrid[0][j] != 1) {
                    dp[0][j] = dp[0][j - 1];
                }
                if (j == 0 && i > 0 && obstacleGrid[i][0] != 1) {
                    dp[i][0] = dp[i - 1][0];
                }
            }
        }
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[i].length; j++) {
                if (obstacleGrid[i][j] == 1) {
                    continue;
                }
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }

        return dp[dp.length - 1][dp[0].length - 1];
    }
}
