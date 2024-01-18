package com.yfs.dynamicprogramming;

import java.util.Objects;

/**
 * 题号：474 一和零
 * 给你一个二进制字符串数组 strs 和两个整数 m 和 n 。
 * <p>
 * 请你找出并返回 strs 的最大子集的长度，该子集中 最多 有 m 个 0 和 n 个 1 。
 * <p>
 * 如果 x 的所有元素也是 y 的元素，集合 x 是集合 y 的 子集 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：strs = ["10", "0001", "111001", "1", "0"], m = 5, n = 3
 * 输出：4
 * 解释：最多有 5 个 0 和 3 个 1 的最大子集是 {"10","0001","1","0"} ，因此答案是 4 。
 * 其他满足题意但较小的子集包括 {"0001","1"} 和 {"10","1","0"} 。{"111001"} 不满足题意，因为它含 4 个 1 ，大于 n 的值 3 。
 * 示例 2：
 * <p>
 * 输入：strs = ["10", "0", "1"], m = 1, n = 1
 * 输出：2
 * 解释：最大的子集是 {"0", "1"} ，所以答案是 2 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= strs.length <= 600
 * 1 <= strs[i].length <= 100
 * strs[i] 仅由 '0' 和 '1' 组成
 * 1 <= m, n <= 100
 * <p>
 * <p>
 * 链接：https://leetcode.cn/problems/ones-and-zeroes/description/
 */
public class DP_12_OnesAndZeros {
    public static void main(String[] args) {
        String[] strs = {"10",  "1", "0"};
        int m = 1;
        int n = 1;
        int res = findMaxForm(strs, m, n);
    }

    private static int findMaxForm(String[] strs, int m, int n) {
        // 从全体元素中选择，满足 最多有 m 个 0 和 n 个 1 的最大子集的长度
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i < strs.length; i++) {
            int zeroCount = findCount(strs[i], '0');
            int oneCount = findCount(strs[i], '1');
            for (int j = m; j >= zeroCount; j--) {
                for (int k = n; k >= oneCount; k--) {
                    dp[j][k] = Math.max(dp[j][k], dp[j - zeroCount][k - oneCount] + 1);
                }
            }
        }
        return dp[m][n];
    }

    private static int findCount(String str, Character s) {
        char[] chars = str.toCharArray();
        int count = 0;
        for (int i = 0; i < chars.length; i++) {
            if (Objects.equals(s, chars[i])) {
                count++;
            }
        }
        return count;
    }
}
