package com.yfs.dynamicprogramming;

/**
 * 完全背包
 *
 * 有N件物品和一个最多能背重量为W的背包。
 * 第i件物品的重量是weight[i]，得到的价值是value[i] 。
 * 每件物品都有无限个（也就是可以放入背包多次），求解将哪些物品装入背包里物品价值总和最大。
 */
public class DP_13_Complete_Package {
    public static void main(String[] args) {
        int[] weight = {1, 3, 4};
        int[] value = {15, 20, 30};
        int w = 4;
        // 一维数组模拟
//        int res = solveMultiPackage(weight, value, w);
        // 二维数组模拟
        int res2 = solveMultiPackageII(weight, value, w);
    }

    private static int solveMultiPackageII(int[] weight, int[] value, int w) {
        int[][] dp = new int[weight.length][w + 1];
        for (int j = weight[0]; j <= w; j++) {
            dp[0][j] = Math.max(dp[0][j-1], dp[0][j - weight[0]] + value[0]);
        }
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j <= w; j++) {
                if (j >= weight[i]) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weight[i]] + value[i]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[dp.length - 1][w];
    }


    private static int solveMultiPackage(int[] weight, int[] value, int w) {
        int[] dp = new int[w + 1];
        for (int i = 0; i < weight.length; i++) {
            for (int j = weight[i]; j <= w; j++) {
                dp[j] = Math.max(dp[j], dp[j - weight[i]] + value[i]);
            }
        }
        return dp[w];
    }
}
