package com.yfs.dynamicprogramming;

/**
 * 516.最长回文子序列
 * <p>
 * 给定一个字符串 s ，找到其中最长的回文子序列，并返回该序列的长度。可以假设 s 的最大长度为 1000 。
 * <p>
 * 示例 1: 输入: "bbbab" 输出: 4 一个可能的最长回文子序列为 "bbbb"。
 * <p>
 * 示例 2: 输入:"cbbd" 输出: 2 一个可能的最长回文子序列为 "bb"。
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 1000
 * s 只包含小写英文字母
 * <p>
 * https://leetcode.cn/problems/longest-palindromic-subsequence/description/
 */
public class DP_40_最长回文子序列 {
    public static void main(String[] args) {
        String s = "aabaa";
        int res = longestPalindromeSubseq(s);
    }

    public static int longestPalindromeSubseq(String s) {
        char[] chars = s.toCharArray();
        int[][] dp = new int[chars.length][chars.length];
        for (int i = s.length() - 1; i >= 0; i--) {
            for (int j = i; j <= s.length() - 1; j++) {
                if (i == j) {
                    dp[i][i] = 1;
                    continue;
                }
                // 编号i-j的子序列为回文串
                if (chars[i] == chars[j]) {
                    if (j - i == 1 || (j - i - 1) == dp[i + 1][j - 1]) {
                        // 连续的情况
                        dp[i][j] = j - i + 1;
                    } else {
                         // 注意子串不一定是连续的
                        dp[i][j] = dp[i + 1][j - 1] + 2;
                    }
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[0][s.length() - 1];
    }
}
