package com.yfs.dynamicprogramming;

/**
 * 题号：70 爬楼梯
 * <p>
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * <p>
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 2
 * 输出：2
 * 解释：有两种方法可以爬到楼顶。
 * 1. 1 阶 + 1 阶
 * 2. 2 阶
 * 示例 2：
 * <p>
 * 输入：n = 3
 * 输出：3
 * 解释：有三种方法可以爬到楼顶。
 * 1. 1 阶 + 1 阶 + 1 阶
 * 2. 1 阶 + 2 阶
 * 3. 2 阶 + 1 阶
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 45
 * <p>
 * https://leetcode.cn/problems/climbing-stairs/description/
 */
public class DP_2_ClimbingStairs {
    public static void main(String[] args) {
        int res = climbStairs(3);
        // 这道题目还可以继续深化，就是一步一个台阶，两个台阶，三个台阶，直到 m个台阶，有多少种方法爬到n阶楼顶。
        int res2 = climbStairsII(3, 2);
    }

    private static int climbStairsII(int n, int m) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1 ; j <= m; j++) {
                if (i >= j) {
                    dp[i] = dp[i] + dp[i - j];
                }

            }
        }
        return dp[n];
    }

    private static int climbStairs(int n) {
        if (n < 3) {
            return n;
        }
        int[] dp = new int[2];
        dp[0] = 1;
        dp[1] = 2;
        for (int i = 3; i <= n; i++) {
            int sum = dp[0] + dp[1];
            dp[0] = dp[1];
            dp[1] = sum;
        }
        return dp[1];
    }
}
