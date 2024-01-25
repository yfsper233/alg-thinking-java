package com.yfs.dynamicprogramming;

/**
 * 583. 两个字符串的删除操作
 * <p>
 * 给定两个单词 word1 和 word2 ，返回使得 word1 和  word2 相同所需的最小步数。
 * <p>
 * 每步 可以删除任意一个字符串中的一个字符。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入: word1 = "sea", word2 = "eat"
 * 输出: 2
 * 解释: 第一步将 "sea" 变为 "ea" ，第二步将 "eat "变为 "ea"
 * 示例  2:
 * <p>
 * 输入：word1 = "leetcode", word2 = "etco"
 * 输出：4
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= word1.length, word2.length <= 500
 * word1 和 word2 只包含小写英文字母
 * <p>
 * <p>
 * https://leetcode.cn/problems/delete-operation-for-two-strings/description/
 */
public class DP_37_两个字符串的删除操作 {
    public static void main(String[] args) {
        String word1 = "leetcode";
        String word2 = "etco";
        int res = minDistance(word1, word2);
    }

    private static int minDistance(String word1, String word2) {
        char[] chars1 = word1.toCharArray();
        char[] chars2 = word2.toCharArray();
        int[][] dp = new int[chars1.length][chars2.length];
        for (int i = 0; i < chars1.length; i++) {
            if (chars1[i] == chars2[0]) {
                for (int j = i; j < chars1.length; j++) {
                    dp[j][0] = 1;
                }
            }
        }
        for (int i = 0; i < chars2.length; i++) {
            if (chars2[i] == chars1[0]) {
                for (int j = i; j < chars2.length; j++) {
                    dp[0][j] = 1;
                }
            }
        }


        for (int i = 1; i < chars1.length; i++) {
            for (int j = 1; j < chars2.length; j++) {
                if (chars1[i] == chars2[j]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }
        int maxCommonLength = dp[chars1.length - 1][chars2.length - 1];
        return (chars1.length - maxCommonLength) + (chars2.length - maxCommonLength);
    }
}
