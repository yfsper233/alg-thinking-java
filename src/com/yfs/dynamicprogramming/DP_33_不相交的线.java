package com.yfs.dynamicprogramming;

import jdk.nashorn.internal.ir.annotations.Ignore;

/**
 * 1035.不相交的线
 * <p>
 * 在两条独立的水平线上按给定的顺序写下 nums1 和 nums2 中的整数。
 * <p>
 * 现在，可以绘制一些连接两个数字 nums1[i] 和 nums2[j] 的直线，这些直线需要同时满足满足：
 * <p>
 * nums1[i] == nums2[j]
 * 且绘制的直线不与任何其他连线（非水平线）相交。
 * 请注意，连线即使在端点也不能相交：每个数字只能属于一条连线。
 * <p>
 * 以这种方法绘制线条，并返回可以绘制的最大连线数。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：nums1 = [1,4,2], nums2 = [1,2,4]
 * 输出：2
 * 解释：可以画出两条不交叉的线，如上图所示。
 * 但无法画出第三条不相交的直线，因为从 nums1[1]=4 到 nums2[2]=4 的直线将与从 nums1[2]=2 到 nums2[1]=2 的直线相交。
 * 示例 2：
 * <p>
 * 输入：nums1 = [2,5,1,2,5], nums2 = [10,5,2,1,5,2]
 * 输出：3
 * 示例 3：
 * <p>
 * 输入：nums1 = [1,3,7,1,7,5], nums2 = [1,9,2,5,1]
 * 输出：2
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums1.length, nums2.length <= 500
 * 1 <= nums1[i], nums2[j] <= 2000
 * <p>
 * https://leetcode.cn/problems/uncrossed-lines/description/
 */
public class DP_33_不相交的线 {
    public static void main(String[] args) {
        int[] nums1 = {1,2,2,2,1,2};
        int[] nums2 = {1};
//        int res = maxUncrossedLines(nums1, nums2);
        int res = maxUncrossedLinesII(nums1, nums2);

    }

    private static int maxUncrossedLinesII(int[] nums1, int[] nums2) {
        int[][] dp = new int[nums1.length][nums2.length];
        for (int i = 0; i < nums1.length; i++) {
            if (nums1[i] == nums2[0]) {
                for (int j = i; j < nums1.length; j++) {
                    dp[j][0] = 1;
                }
            }
        }

        for (int i = 0; i < nums2.length; i++) {
            if (nums2[i] == nums1[0]) {
                for (int j = i; j < nums2.length; j++) {
                    dp[0][j] = 1;
                }
            }
        }

        for (int i = 1; i < nums1.length; i++) {
            for (int j = 1; j < nums2.length; j++) {
                if (nums1[i] == nums2[j]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[nums1.length - 1][nums2.length - 1];
    }

    // {1,1,2,1,2} {1,3,2,3,1}
    @Ignore
    private static int maxUncrossedLines(int[] nums1, int[] nums2) {
        int res = 0;
        int lowIndex = 0;
        for (int i = 0; i < nums1.length; i++) {
            for (int j = lowIndex; j < nums2.length; j++) {
                if (nums1[i] == nums2[j]) {
                    res++;
                    lowIndex = j + 1;
                    break;
                }
            }
        }
        return res;
    }
}
