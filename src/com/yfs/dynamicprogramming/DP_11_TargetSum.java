package com.yfs.dynamicprogramming;

import java.util.stream.IntStream;

/**
 * 题号：494 目标和
 * <p>
 * 给你一个非负整数数组 nums 和一个整数 target 。
 * <p>
 * 向数组中的每个整数前添加 '+' 或 '-' ，然后串联起所有整数，可以构造一个 表达式 ：
 * <p>
 * 例如，nums = [2, 1] ，可以在 2 之前添加 '+' ，在 1 之前添加 '-' ，然后串联起来得到表达式 "+2-1" 。
 * 返回可以通过上述方法构造的、运算结果等于 target 的不同 表达式 的数目。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,1,1,1,1], target = 3
 * 输出：5
 * 解释：一共有 5 种方法让最终目标和为 3 。
 * -1 + 1 + 1 + 1 + 1 = 3
 * +1 - 1 + 1 + 1 + 1 = 3
 * +1 + 1 - 1 + 1 + 1 = 3
 * +1 + 1 + 1 - 1 + 1 = 3
 * +1 + 1 + 1 + 1 - 1 = 3
 * 示例 2：
 * <p>
 * 输入：nums = [1], target = 1
 * 输出：1
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 20
 * 0 <= nums[i] <= 1000
 * 0 <= sum(nums[i]) <= 1000
 * -1000 <= target <= 1000
 * <p>
 * 链接：https://leetcode.cn/problems/target-sum/description/
 */
public class DP_11_TargetSum {
    public static void main(String[] args) {
        int[] nums = {1};
        int target = 1;
        // 二维数组模拟
//        int res = findTargetSumWays(nums, target);
        // 一维数组模拟
        int res2 = findTargetSumWaysII(nums, target);
    }

    private static int findTargetSumWaysII(int[] nums, int target) {
        // 在集合nums中找和为固定值的组合种类
        int sum = IntStream.of(nums).sum();
        if (sum < Math.abs(target)) {
            return 0;
        }
        // 元素都是非负数，和只可能为非负数
        if ((sum + target) % 2 == 1) {
            return 0;
        }
        int partition = (sum + target) / 2;
        // 从nums中选取元素，每个元素最多出现一次，使得其和为j的方式即为dp[j]
        int[] dp = new int[partition + 1];
        // 初始化dp[0]
        dp[0] = 1;
        for (int i = 0; i < nums.length; i++) {
            for (int j = partition; j >= nums[i]; j--) {
                dp[j] += dp[j - nums[i]];

            }
        }
        return dp[dp.length - 1];
    }


    private static int findTargetSumWays(int[] nums, int target) {
        // 将一个集合分成两份 left + right = sum
        // 假设right是加法总和 left是减法总和 target = right - left
        // target = right -（sum- right）
        // right = (target + sum)/2
        int sum = IntStream.of(nums).sum();
        if (Math.abs(target) > sum) {
            return 0;
        }
        if ((target + sum) % 2 == 1) {
            return 0;
        }
        int right = (target + sum) / 2;
        // dp[i][j] 从编号为0-i的元素中挑选，使得和为j的组合种类为dp[i][j]
        int[][] dp = new int[nums.length][right + 1];
        // 对于dp[i-1][5] 如果剩余空间放得下nums[i](j>=nums[j])
        //已经有一个1（nums[i]） 的话，有 dp[i-1][4]种方法 凑成 容量为5的背包。
        //已经有一个2（nums[i]） 的话，有 dp[i-1][3]种方法 凑成 容量为5的背包。
        //已经有一个3（nums[i]） 的话，有 dp[i-1][2]中方法 凑成 容量为5的背包
        //已经有一个4（nums[i]） 的话，有 dp[i-1][1]中方法 凑成 容量为5的背包
        //已经有一个5 （nums[i]）的话，有 dp[i-1][0]中方法 凑成 容量为5的背包
        if (nums[0] <= right) {
            dp[0][nums[0]] = 1;
        }

        // 初始化最左列（dp[i][0])
        // 当从nums数组的索引0到i的部分有n个0时（n > 0)，每个0可以取+/-，因此有2的n次方中可以取到j = 0的方案
        // n = 0说明当前遍历到的数组部分没有0全为正数，因此只有一种方案可以取到j = 0（就是所有数都不取）
        int numZeros = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                numZeros++;
            }
            dp[i][0] = (int) Math.pow(2, numZeros);

        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                if (j < nums[i]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i - 1][j - nums[i]];
                }
            }
        }
        return dp[nums.length - 1][right];
    }
}
