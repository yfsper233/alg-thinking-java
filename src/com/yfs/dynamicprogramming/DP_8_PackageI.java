package com.yfs.dynamicprogramming;

/**
 * 有n件物品和一个最多能背重量为w 的背包。
 * 第i件物品的重量是weight[i]，得到的价值是value[i] 。
 * 每件物品只能用一次，求解将哪些物品装入背包里物品价值总和最大。
 */
public class DP_8_PackageI {
    public static void main(String[] args) {
        int[] weight = {1, 3, 4};
        int[] values = {15, 20, 30};
        // 背包容量
        int w = 4;
        // 二维数组模拟
//        int res = packageI(w, weight, values);
        // 一维数组模拟
        int res2 = packageII(w, weight, values);
    }

    private static int packageII(int w, int[] weight, int[] values) {
        // dp[j] 容量为j的背包，所背的物品价值可以最大为dp[j]。
        int[] dp = new int[w + 1];
        for (int i = 0; i < weight.length; i++) {
            // 此处必须后序遍历
            // 仍然从二维数据的角度来模拟
            // d[j] 的状态依赖于 d[0] -d[j-1]的状态
            // 对于第一个物品（i=0时）来说，最多只能放一个物品，因此遍历顺序对结果无影响
            // 若从背包容量递减方向遍历，对于编号为i的物品，器前置状态已经在i-1轮遍历时处理过了，该物品一定与dp[j-weight[i]]无关。
            // 若从背包容量递增方向遍历，该物品可能已经被放置到dp[j-weight[i]]状态的背包中了
            for (int j = w; j >= weight[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - weight[i]] + values[i]);
            }
        }
        return dp[w];
    }

    private static int packageI(int w, int[] weight, int[] values) {
        // dp[i][j] 表示从下标为[0-i]的物品里任意取，放进容量为j的背包，价值总和最大是多少。
        int[][] dp = new int[weight.length][w + 1];

        // 对于背包容量j和物品编号0-i，
        // 若放不下编号为i的物品 dp[i][j] = dp[i-1][j]
        // 若可以放 此时有两种选择，选取收益较高的方式
        //         dp[i][j] = Math.max(dp[i-1][j-weight[i]] + value[i], dp[i-1][j])

        //第一列 背包重量为0 因此 dp[i][0] = 0
        //第一行 当背包容量大于或等于物品重量时， dp[0][j] = values[j]
        for (int j = weight[0]; j <= w; j++) {
            dp[0][j] = values[0];
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[i].length; j++) {
                // 放不下编号为i的物品
                if (j - weight[i] < 0) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j - weight[i]] + values[i], dp[i - 1][j]);
                }
            }
        }
        return dp[weight.length - 1][w];
    }


}
