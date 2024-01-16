package com.yfs.greedy;

/**
 * 题号:[55]
 * <p>
 * 给定一个非负整数数组 nums ，你最初位于数组的 第一个下标 。
 * <p>
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * <p>
 * 判断你是否能够到达最后一个下标。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [2,3,1,1,4]
 * 输出：true
 * 解释：可以先跳 1 步，从下标 0 到达下标 1, 然后再从下标 1 跳 3 步到达最后一个下标。
 * 示例 2：
 * <p>
 * 输入：nums = [3,2,1,0,4]
 * 输出：false
 * 解释：无论怎样，总会到达下标为 3 的位置。但该下标的最大跳跃长度是 0 ， 所以永远不可能到达最后一个下标。
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 3 * 104
 * 0 <= nums[i] <= 105
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/jump-game
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Greedy_5_JumpGame {
    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 0, 4};
        boolean res = canJump2(nums);
        boolean res3 = canJump3(nums);
        System.out.println(res);
    }

    private static boolean canJump3(int[] nums) {
        if (nums.length == 1) {
            return true;
        }

        int[] profits = new int[nums.length - 1];
        for (int i = 0; i < nums.length - 1; i++) {
            profits[i] = nums[i] + i - nums.length + 1;
        }
        for (int i = 0; i < nums.length; ) {
            if (nums[i] == 0) {
                return false;
            }
            if (nums[i] + i - nums.length + 1 >= 0) {
                return true;
            }
            int maxProfit = Integer.MIN_VALUE;
            int nextIndex = i + 1;

            for (int j = i + 1; j < nums[i] + i + 1; j++) {
                if (profits[j] >= maxProfit) {
                    maxProfit = profits[j];
                    nextIndex = j;
                }
            }

            i = nextIndex;
        }
        return false;
    }


    private static boolean canJump(int[] nums) {
        int i = 0;
        while ((nums[i] + i) < nums.length - 1) {
            // 贪心策略：下一跳选择落在可覆盖范围最大的点
            int max = Integer.MIN_VALUE;
            int nextIndex = i;
            for (int j = i + 1; j <= (nums[i] + i) && j <= nums.length - 1; j++) {
                if (nums[j] + j >= max) {
                    max = nums[j] + j;
                    nextIndex = j;
                }
            }
            if (i == nextIndex) {
                return false;
            }
            // 跳到下一个最优点
            i = nextIndex;
        }
        return true;
    }

    private static boolean canJump2(int[] nums) {
        if (nums.length == 1) {
            return true;
        }
        int coverage = 0;
        for (int i = 0; i <= coverage; i++) {
            coverage = Math.max(coverage, nums[i] + i);
            if (coverage >= nums.length - 1) {
                return true;
            }
        }
        return false;
    }
}
