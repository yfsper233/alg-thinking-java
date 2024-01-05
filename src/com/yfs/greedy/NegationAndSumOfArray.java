package com.yfs.greedy;

/**
 *
 * 1005. K 次取反后最大化的数组和
 * 给你一个整数数组 nums 和一个整数 k ，按以下方法修改该数组：
 *
 * 选择某个下标 i 并将 nums[i] 替换为 -nums[i] 。
 * 重复这个过程恰好 k 次。可以多次选择同一个下标 i 。
 *
 * 以这种方式修改数组后，返回数组 可能的最大和 。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [4,2,3], k = 1
 * 输出：5
 * 解释：选择下标 1 ，nums 变为 [4,-2,3] 。
 * 示例 2：
 *
 * 输入：nums = [3,-1,0,2], k = 3
 * 输出：6
 * 解释：选择下标 (1, 2, 2) ，nums 变为 [3,1,0,2] 。
 * 示例 3：
 *
 * 输入：nums = [2,-3,-1,5,-4], k = 2
 * 输出：13
 * 解释：选择下标 (1, 4) ，nums 变为 [2,3,-1,5,4] 。
 *  
 *
 * 提示：
 *
 * 1 <= nums.length <= 104
 * -100 <= nums[i] <= 100
 * 1 <= k <= 104
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/maximize-sum-of-array-after-k-negations
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class NegationAndSumOfArray {
    public static void main(String[] args) {
        int[] nums = {2,-3,-1,5,-4};
        int k = 2;
        int maxSum = negationAndSumOfArray(nums , k);
        System.out.println(maxSum);
    }

    private static int negationAndSumOfArray(int[] nums, int k) {
        for (int i = 0; i < k; i++) {
            int minIndex = getMinElementIndex(nums);
            nums[minIndex] = -nums[minIndex];
        }
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        return sum;
    }

    private static int getMinElementIndex(int[] nums) {
        int minIndex = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < min){
                min = nums[i];
                minIndex = i;
            }
        }
        return minIndex;
    }
}
