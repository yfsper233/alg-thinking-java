package com.yfs.dynamicprogramming;

import java.util.Arrays;

/**
 * 279. 完全平方数
 * <p>
 * 给你一个整数 n ，返回 和为 n 的完全平方数的最少数量 。
 * <p>
 * 完全平方数 是一个整数，其值等于另一个整数的平方；换句话说，其值等于一个整数自乘的积。例如，1、4、9 和 16 都是完全平方数，而 3 和 11 不是。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 12
 * 输出：3
 * 解释：12 = 4 + 4 + 4
 * 示例 2：
 * <p>
 * 输入：n = 13
 * 输出：2
 * 解释：13 = 4 + 9
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 104
 * <p>
 * https://leetcode.cn/problems/perfect-squares/description/
 */
public class DP_17_PerfectSquares {
    public static void main(String[] args) {
        int res = perfectSquares(13);
    }

    private static int perfectSquares(int n) {
        int maxSqrtNum = (int) Math.ceil(Math.sqrt(n));
        int[] values = new int[maxSqrtNum];
        for (int i = 1; i <= maxSqrtNum; i++) {
            values[i-1] = (int) Math.pow(i, 2);
        }
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 0; i < values.length; i++) {
            for (int j = values[i]; j <= n; j++) {
                dp[j] = Math.min(dp[j], dp[j - values[i]] + 1);
            }
        }
        return dp[n];
    }
}
