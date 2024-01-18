package com.yfs.dynamicprogramming;

import java.util.Arrays;
import java.util.jar.JarEntry;
import java.util.stream.IntStream;

/**
 * 题号：416 分割等和子集
 * <p>
 * 给你一个 只包含正整数 的 非空 数组 nums 。请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,5,11,5]
 * 输出：true
 * 解释：数组可以分割成 [1, 5, 5] 和 [11] 。
 * 示例 2：
 * <p>
 * 输入：nums = [1,2,3,5]
 * 输出：false
 * 解释：数组不能分割成两个元素和相等的子集。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 200
 * 1 <= nums[i] <= 100
 * <p>
 * https://leetcode.cn/problems/partition-equal-subset-sum/description/
 */
public class DP_9_PartitionEqualSubsetSum {
    public static void main(String[] args) {
        int[] nums = {23, 13, 11, 7, 6, 5, 5};
        // 一维数组解法
//        boolean res = canPartition(nums);
        // 二维数组解法
        boolean res2 = canPartitionII(nums);
    }

    private static boolean canPartitionII(int[] nums) {
        // 等价于寻到一个子集，使得其和为sum(nums)/2
        // 每个元素只能使用1次，通过01背包思路来解决
        // 背包容量 sum(nums)/2  物品重量数组 nums  物品价值数组 nums
        int sum = IntStream.of(nums).sum();
        if (sum % 2 != 0) {
            return false;
        }
        int target = sum / 2;
        // 行：物品编号 列：背包容量 dp[i][j] 从编号为[0,i]的元素中选取，每个元素最多使用一次，背包容量为j时的最大重量
        int[][] dp = new int[nums.length][target + 1];
        for (int j = nums[0]; j <= target; j++) {
            dp[0][j] = nums[0];
        }
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[i].length; j++) {
                if (j >= nums[i]){
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-nums[i]] + nums[i]);
                }else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[nums.length-1][target] == target;
    }







    private static boolean canPartition(int[] nums) {
        // 等价于寻到一个子集，使得其和为sum(nums)/2
        // 每个元素只能使用1次，通过01背包思路来解决
        // 背包容量 sum(nums)/2  物品重量数组 nums  物品价值数组 nums
        int sum = IntStream.of(nums).sum();
        if (sum % 2 != 0) {
            return false;
        }
        int mid = sum / 2;
        int[] dp = new int[mid + 1];
        // dp[j]表示 背包总容量（所能装的总重量）是j，放进物品后，背的最大重量为dp[j]。
        for (int j = 0; j < nums.length; j++) {
            for (int i = mid; i >= nums[j]; i--) {
                dp[i] = Math.max(dp[i], dp[i - nums[j]] + nums[j]);
            }
        }

        return dp[mid] == mid;
    }
}
