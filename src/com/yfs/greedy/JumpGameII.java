package com.yfs.greedy;

/**
 *
 * 45. 跳跃游戏 II
 * 给你一个非负整数数组 nums ，你最初位于数组的第一个位置。
 *
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 *
 * 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
 *
 * 假设你总是可以到达数组的最后一个位置。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: nums = [2,3,1,1,4]
 * 输出: 2
 * 解释: 跳到最后一个位置的最小跳跃数是 2。
 *      从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
 * 示例 2:
 *
 * 输入: nums = [2,3,0,1,4]
 * 输出: 2
 *  
 *
 * 提示:
 *
 * 1 <= nums.length <= 104
 * 0 <= nums[i] <= 1000
 * 通过次数375,082提交次数833,676
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/jump-game-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class JumpGameII {
    public static void main(String[] args) {
        int[] nums = {2,3,1,1,4};
         int res = canJumpII(nums);
        System.out.println(res);
    }

    private static int canJumpII(int[] nums) {
        int i = 0;
        int res = 0;
        while ((nums[i] + i) < nums.length-1 ){
            // 贪心策略：下一跳选择落在可覆盖范围最大的点
            int max = Integer.MIN_VALUE;
            int nextIndex = i;
            for (int j = i +1; j <= (nums[i] + i) && j <= nums.length-1; j++) {
                if (nums[j] + j >= max) {
                    max = nums[j] + j;
                    nextIndex = j;
                }
            }
            // 跳到下一个最优点
            i = nextIndex;
            res += 1;
        }
        return res + 1;
    }
}
