package com.yfs.dynamicprogramming;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 213 打家劫舍II
 * <p>
 * 你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都 围成一圈 ，这意味着第一个房屋和最后一个房屋是紧挨着的。同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警 。
 * <p>
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你 在不触动警报装置的情况下 ，今晚能够偷窃到的最高金额。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [2,3,2]
 * 输出：3
 * 解释：你不能先偷窃 1 号房屋（金额 = 2），然后偷窃 3 号房屋（金额 = 2）, 因为他们是相邻的。
 * 示例 2：
 * <p>
 * 输入：nums = [1,2,3,1]
 * 输出：4
 * 解释：你可以先偷窃 1 号房屋（金额 = 1），然后偷窃 3 号房屋（金额 = 3）。
 * 偷窃到的最高金额 = 1 + 3 = 4 。
 * 示例 3：
 * <p>
 * 输入：nums = [1,2,3]
 * 输出：3
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 100
 * 0 <= nums[i] <= 1000
 * <p>
 * https://leetcode.cn/problems/house-robber-ii/description/
 */
public class DP_21_打家劫舍II {
    public static void main(String[] args) {
        int[] nums = {1,2,3,};
        int res = houseRobberII(nums);
    }

    private static int houseRobberII(int[] nums) {
        int length = nums.length;
        if (length == 0) {
            return 0;
        }

        if (length == 1) {
            return nums[0];
        }
        List<Integer> money = IntStream.of(nums).boxed().collect(Collectors.toList());
        return Math.max(houseRobber(money.subList(0, length - 1)), houseRobber(money.subList(1, length)));
    }

    private static int houseRobber(List<Integer> money) {
        if (money.size() == 0) {
            return 0;
        }
        if (money.size() == 1) {
            return money.get(0);
        }

        // dp[i]:截止编号为i的房子时的最大收益
        int[] dp = new int[money.size()];
        dp[0] = money.get(0);
        dp[1] = Math.max(money.get(0), money.get(1));

        for (int i = 2; i < dp.length; i++) {
            dp[i] = Math.max(dp[i - 2] + money.get(i), dp[i - 1]);
        }
        return dp[money.size() - 1];
    }
}
