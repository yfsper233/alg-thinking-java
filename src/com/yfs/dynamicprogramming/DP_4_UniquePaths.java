package com.yfs.dynamicprogramming;

/**
 * 62 不同路径
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。
 * <p>
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。
 * <p>
 * 问总共有多少条不同的路径
 * <p>
 * 示例 2：
 * <p>
 * 输入：m = 3, n = 2
 * 输出：3
 * 解释：
 * 从左上角开始，总共有 3 条路径可以到达右下角。
 * 1. 向右 -> 向下 -> 向下
 * 2. 向下 -> 向下 -> 向右
 * 3. 向下 -> 向右 -> 向下
 * 示例 3：
 * <p>
 * 输入：m = 7, n = 3
 * 输出：28
 * 示例 4：
 * <p>
 * 输入：m = 3, n = 3
 * 输出：6
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= m, n <= 100
 * 题目数据保证答案小于等于 2 * 109
 * <p>
 * https://leetcode.cn/problems/unique-paths/description/
 */
public class DP_4_UniquePaths {
    public static void main(String[] args) {
        int res = uniquePath(7, 3);
    }

    private static int uniquePath(int m, int n) {
        // m n 二维数组下标
        // 表示从（0 ，0）出发，到(i, j) 有dp[i][j]条不同的路径。
        int[][] dp = new int[m][n];
//        dp[1][1] = dp[0][1] + dp[1][0];
//        dp[2][2] = dp[2][1] + dp[1][2];
//        dp[2][1] = dp[2][0] + dp[1][1];
        // 初始化 起点所在两条边上的所有点可达路径数量为1
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 1;
        }

        for (int j = 0; j < dp[0].length; j++) {
            dp[0][j] = 1;
        }


        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[i].length; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }

        return dp[m - 1][n - 1];

    }
}
