package com.yfs.dynamicprogramming;

/**
 * 188.买卖股票的最佳时机IV
 * <p>
 * 给你一个整数数组 prices 和一个整数 k ，其中 prices[i] 是某支给定的股票在第 i 天的价格。
 * <p>
 * 设计一个算法来计算你所能获取的最大利润。你最多可以完成 k 笔交易。也就是说，你最多可以买 k 次，卖 k 次。
 * <p>
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：k = 2, prices = [2,4,1]
 * 输出：2
 * 解释：在第 1 天 (股票价格 = 2) 的时候买入，在第 2 天 (股票价格 = 4) 的时候卖出，
 * 这笔交易所能获得利润 = 4-2 = 2 。
 * 示例 2：
 * <p>
 * 输入：k = 2, prices = [3,2,6,5,0,3]
 * 输出：7
 * 解释：在第 2 天 (股票价格 = 2) 的时候买入，在第 3 天 (股票价格 = 6) 的时候卖出, 这笔交易所能获得利润 = 6-2 = 4 。
 * 随后，在第 5 天 (股票价格 = 0) 的时候买入，在第 6 天 (股票价格 = 3) 的时候卖出, 这笔交易所能获得利润 = 3-0 = 3 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= k <= 100
 * 1 <= prices.length <= 1000
 * 0 <= prices[i] <= 1000
 * <p>
 * https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-iv/description/
 */
public class DP_26_买卖股票的最佳时机IV {
    public static void main(String[] args) {
        int[] prices = {3,2,6,5,0,3};
        int k = 2;
        int res = maxProfit(prices, k);
    }

    private static int maxProfit(int[] prices, int k) {
            int[][] dp = new int[prices.length][2*k + 1];
            for (int i = 0; i < 2 * k + 1; i++) {
                if (i % 2 == 1) {
                    dp[0][i] = -prices[0];
                }
            }

            for (int i = 1; i < prices.length; i++) {
                for (int j = 1; j <= 2 * k; j++) {
                    if (j % 2 == 1) {
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j-1] - prices[i]);
                    }else {
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j-1] + prices[i]);
                    }
                }
            }

            return dp[prices.length-1][2 * k];
    }
}
