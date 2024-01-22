package com.yfs.dynamicprogramming;

import com.sun.org.apache.xml.internal.utils.res.LongArrayWrapper;
import jdk.nashorn.internal.ir.annotations.Ignore;

import java.util.stream.IntStream;

/**
 * 121 买卖股票的最佳时机
 * <p>
 * 给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。
 * <p>
 * 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
 * <p>
 * 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：[7,1,5,3,6,4]
 * 输出：5
 * 解释：在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 * 注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。
 * 示例 2：
 * <p>
 * 输入：prices = [7,6,4,3,1]
 * 输出：0
 * 解释：在这种情况下, 没有交易完成, 所以最大利润为 0。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= prices.length <= 105
 * 0 <= prices[i] <= 104
 * <p>
 * https://leetcode.cn/problems/best-time-to-buy-and-sell-stock/description/
 */
public class DP_23_买卖股票的最佳时机 {
    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
//        int res = maxProfitII(prices);
        // 贪心策略
        int res = maxProfitIII(prices);
        // 动态规划
        int res3 = maxProfit(prices);
    }

    private static int maxProfitIII(int[] prices) {
        // 遍历过程中不断更新截止目前的最低价和收益
        int low = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            low = Math.min(low, prices[i]);
            maxProfit = Math.max(maxProfit, prices[i] - low);
        }
        return maxProfit;
    }

    @Ignore
    // 超时
    private static int maxProfitII(int[] prices) {
        // 第i天买入股票的最大收益
        int dp = 0;
        for (int i = 0; i < prices.length; i++) {
            for (int j = prices.length - 1; j > i; j--) {
                dp = Math.max(dp, prices[j] - prices[i]);
            }
        }
        return dp;
    }

    @Ignore
    private static int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][2];
        dp[0][0] = -prices[0];
        dp[0][1] = 0;
        // 每天要么买，要么不买
        // dp[i][0] 第i天持有（上一天就持有/当天买入）股票情况下最优收益
        // dp[i][1] 第i天不持有（上一天就不持有/当天卖出）股票情况下最优收益
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0],  - prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + prices[i]);
        }
        return Math.max(dp[prices.length - 1][0], dp[prices.length - 1][1]);
    }
}
