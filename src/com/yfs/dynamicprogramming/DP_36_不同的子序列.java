package com.yfs.dynamicprogramming;

/**
 * 115.不同的子序列
 * <p>
 * 给你两个字符串 s 和 t ，统计并返回在 s 的 子序列 中 t 出现的个数，结果需要对 109 + 7 取模。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "rabbbit", t = "rabbit"
 * 输出：3
 * 解释：
 * 如下所示, 有 3 种可以从 s 中得到 "rabbit" 的方案。
 * rabbbit
 * rabbbit
 * rabbbit
 * 示例 2：
 * <p>
 * 输入：s = "babgbag", t = "bag"
 * 输出：5
 * 解释：
 * 如下所示, 有 5 种可以从 s 中得到 "bag" 的方案。
 * babgbag
 * babgbag
 * babgbag
 * babgbag
 * babgbag
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length, t.length <= 1000
 * s 和 t 由英文字母组成
 * <p>
 * https://leetcode.cn/problems/distinct-subsequences/description/
 */
public class DP_36_不同的子序列 {
    public static void main(String[] args) {
        String s = "babgbag";
        String t = "bag";
        int res = numDistinct(s, t);
    }

    private static int numDistinct(String s, String t) {
        char[] chars1 = s.toCharArray();
        char[] chars2 = t.toCharArray();
        int[][] dp = new int[chars1.length][chars2.length];

        if (chars1[0] == chars2[0]) {
            dp[0][0] = 1;
        }
        for (int i = 1; i < chars1.length; i++) {
            if (chars1[i] == chars2[0]) {
                dp[i][0] = dp[i - 1][0] + 1;
            }else {
                dp[i][0] = dp[i-1][0];

            }
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[i].length; j++) {
                if (chars1[i] == chars2[j]) {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }

            }
        }

        return dp[chars1.length - 1][chars2.length - 1];
    }
}
