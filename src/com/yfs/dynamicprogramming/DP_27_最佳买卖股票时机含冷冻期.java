package com.yfs.dynamicprogramming;

/**
 * 309.最佳买卖股票时机含冷冻期
 * <p>
 * 给定一个整数数组prices，其中第  prices[i] 表示第 i 天的股票价格 。​
 * <p>
 * 设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:
 * <p>
 * 卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: prices = [1,2,3,0,2]
 * 输出: 3
 * 解释: 对应的交易状态为: [买入, 卖出, 冷冻期, 买入, 卖出]
 * 示例 2:
 * <p>
 * 输入: prices = [1]
 * 输出: 0
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= prices.length <= 5000
 * 0 <= prices[i] <= 1000
 */
public class DP_27_最佳买卖股票时机含冷冻期 {
    public static void main(String[] args) {
        int[] prices = {1};
        int maxProfit = maxProfit(prices);
    }

    private static int maxProfit(int[] prices) {
        // 状态分析：
        // 0当天买入状态、1当天卖出、2冷冻期）
        int[][] dp = new int[prices.length][3];
        dp[0][0] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            // 当天买入状态 或继承上一天的买入状态 或上一天是冷冻期
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][2] - prices[i]);
            // 当天卖出状态 要么上一天买入 要么上一天已经卖出 上一天是冷冻期 说明刚卖出过，不能连续卖出
            dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0] + prices[i]);
            // 冷冻期 说明上一天做了卖出操作
            dp[i][2] = dp[i-1][1];

        }

        return dp[prices.length-1][1];
    }
}
