package com.yfs.dynamicprogramming;

import java.util.stream.IntStream;

/**
 * 1049.最后一块石头的重量II
 * <p>
 * 有一堆石头，用整数数组 stones 表示。其中 stones[i] 表示第 i 块石头的重量。
 * <p>
 * 每一回合，从中选出任意两块石头，然后将它们一起粉碎。假设石头的重量分别为 x 和 y，且 x <= y。那么粉碎的可能结果如下：
 * <p>
 * 如果 x == y，那么两块石头都会被完全粉碎；
 * 如果 x != y，那么重量为 x 的石头将会完全粉碎，而重量为 y 的石头新重量为 y-x。
 * 最后，最多只会剩下一块 石头。返回此石头 最小的可能重量 。如果没有石头剩下，就返回 0。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：stones = [2,7,4,1,8,1]
 * 输出：1
 * 解释：
 * 组合 2 和 4，得到 2，所以数组转化为 [2,7,1,8,1]，
 * 组合 7 和 8，得到 1，所以数组转化为 [2,1,1,1]，
 * 组合 2 和 1，得到 1，所以数组转化为 [1,1,1]，
 * 组合 1 和 1，得到 0，所以数组转化为 [1]，这就是最优值。
 * 示例 2：
 * <p>
 * 输入：stones = [31,26,33,21,40]
 * 输出：5
 * <p>
 * https://leetcode.cn/problems/last-stone-weight-ii/description/
 */
public class DP_10_LastStoneWeightII {
    public static void main(String[] args) {
        int[] stones = {31,26,33,21,40};
        int res = lastStoneWeightII(stones);
    }

    private static int lastStoneWeightII(int[] stones) {
        // 将stones分为所有元素之和尽可能接近的两个子集
        // 归类为01背包问题，背包容量为 sum(stones)/2
        int sum = IntStream.of(stones).sum();
        int target = sum / 2;
        // dp[i][j] 从编号为0-i的元素中选取放入容量为j的背包，能填满的最大容量
        int[][] dp = new int[stones.length][target + 1];
        for (int j = stones[0]; j <= target; j++) {
            dp[0][j] = stones[0];
        }
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[i].length; j++) {
                if (j < stones[i]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - stones[i]] + stones[i]);
                }
            }
        }
        int left = dp[dp.length - 1][target];
        int right = sum - left;
        return  Math.abs(right - left);
    }
}
