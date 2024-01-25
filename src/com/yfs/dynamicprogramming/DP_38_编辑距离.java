package com.yfs.dynamicprogramming;

import java.util.jar.JarEntry;

/**
 * 72. 编辑距离
 * <p>
 * 给你两个单词 word1 和 word2，请你计算出将 word1 转换成 word2 所使用的最少操作数 。
 * <p>
 * 你可以对一个单词进行如下三种操作：
 * <p>
 * 插入一个字符
 * <p>
 * 删除一个字符
 * <p>
 * 替换一个字符
 * <p>
 * 示例 1：
 * <p>
 * 输入：word1 = "horse", word2 = "ros"
 * <p>
 * 输出：3
 * <p>
 * 解释： horse -> rorse (将 'h' 替换为 'r') rorse -> rose (删除 'r') rose -> ros (删除 'e')
 * <p>
 * 示例 2：
 * <p>
 * 输入：word1 = "intention", word2 = "execution"
 * <p>
 * 输出：5
 * <p>
 * 解释： intention -> inention (删除 't') inention -> enention (将 'i' 替换为 'e') enention -> exention (将 'n' 替换为 'x') exention -> exection (将 'n' 替换为 'c') exection -> execution (插入 'u')
 * <p>
 * 提示：
 * <p>
 * 0 <= word1.length, word2.length <= 500
 * word1 和 word2 由小写英文字母组成
 * <p>
 * https://leetcode.cn/problems/edit-distance/description/
 */
public class DP_38_编辑距离 {
    public static void main(String[] args) {
        String word1 = "distance";
        String word2 = "springbok";
        int res = minEditDistance(word1, word2);
    }


    private static int minEditDistance(String word1, String word2) {
        char[] chars1 = word1.toCharArray();
        char[] chars2 = word2.toCharArray();

        if (chars1.length == 0 || chars2.length == 0) {
            return Math.max(chars1.length, chars2.length);
        }

        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
        // dp[i][j] 以i-1，j-1为结尾的字符串之间的最短编辑距离
        // dp[i][0] 以i-1为结尾的字符串到空字符的最短编辑距离
        for (int i = 0; i <= chars1.length; i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i <= chars2.length; i++) {
            dp[0][i] = i;
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[i].length; j++) {
                if (chars1[i - 1] == chars2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    // char1删除一个  char2删除一个（等价于chars1增加一个）
                    int temp = Math.min(dp[i - 1][j], dp[i][j - 1]);
                    // char1修改一个
                    dp[i][j] = Math.min(temp, dp[i - 1][j - 1]) + 1;
                }
            }
        }


        return dp[chars1.length][chars2.length];
    }


}
