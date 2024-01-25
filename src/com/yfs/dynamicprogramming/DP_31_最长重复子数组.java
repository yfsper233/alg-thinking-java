package com.yfs.dynamicprogramming;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 718. 最长重复子数组
 * <p>
 * <p>
 * 给两个整数数组 nums1 和 nums2 ，返回 两个数组中 公共的 、长度最长的子数组的长度 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums1 = [1,2,3,2,1], nums2 = [3,2,1,4,7]
 * 输出：3
 * 解释：长度最长的公共子数组是 [3,2,1] 。
 * 示例 2：
 * <p>
 * 输入：nums1 = [0,0,0,0,0], nums2 = [0,0,0,0,0]
 * 输出：5
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums1.length, nums2.length <= 1000
 * 0 <= nums1[i], nums2[i] <= 100
 * <p>
 * https://leetcode.cn/problems/maximum-length-of-repeated-subarray/description/
 */
public class DP_31_最长重复子数组 {
    public static void main(String[] args) {
        int[] nums1 = {1,2,3,2,8};
        int[] nums2 = {5,6,1,4,7};
        // 暴力匹配 超时了
//        int length = findLength(nums1, nums2);
        // 二维dp 一个二维数组可以表示出两个集合连续子集对比的所有情况
        int length2 = findLengthII(nums1, nums2);
    }

    private static int findLengthII(int[] nums1, int[] nums2) {
        int[][] dp = new int[nums1.length][nums2.length];
        int res = 0;
        for (int i = 0; i < nums1.length; i++) {
            if (nums1[i] == nums2[0]) {
                dp[i][0] = 1;
            }
            res = Math.max(res,dp[i][0]);
        }
        for (int i = 0; i < nums2.length; i++) {
            if (nums2[i] == nums1[0]) {
                dp[0][i] = 1;
            }
            res = Math.max(res,dp[0][i]);
        }
        for (int i = 1; i < nums1.length; i++) {
            for (int j = 1; j < nums2.length; j++) {
                if (nums1[i] == nums2[j]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }
                res = Math.max(res,dp[i][j]);
            }
        }

        return res;
    }

    public static int findLength(int[] nums1, int[] nums2) {
        int[] dp = new int[nums1.length];
        List<Integer> list2 = IntStream.of(nums2).boxed().collect(Collectors.toList());
        if (list2.contains(nums1[0])) {
            dp[0] = 1;
        }
        int res = dp[0];
        for (int i = 1; i < nums1.length; i++) {
            for (int j = 0; j <= i; j++) {
                if (containsSubArr(nums2, nums1, j, i)) {
                    dp[i] = Math.max(dp[i], i - j + 1);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    private static boolean containsSubArr(int[] nums2, int[] nums1, int startIndex, int endIndex) {
        for (int i = 0; i < nums2.length; i++) {
            if (nums2[i] == nums1[startIndex] && arrEquals(nums2, nums1, i, startIndex, endIndex)) {
                return true;
            }
        }
        return false;
    }

    private static boolean arrEquals(int[] nums2, int[] nums1, int nums2Index, int startIndex, int endIndex) {
        for (int j = startIndex; j <= endIndex; j++) {
            if (nums2Index >= nums2.length) {
                return false;
            }
            if (nums2[nums2Index] != nums1[j]) {
                return false;
            }
            nums2Index++;
        }
        return true;
    }
}
