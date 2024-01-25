package com.yfs.dynamicprogramming;

/**
 * 647. 回文子串
 * <p>
 * 给你一个字符串 s ，请你统计并返回这个字符串中 回文子串 的数目。
 * <p>
 * 回文字符串 是正着读和倒过来读一样的字符串。
 * <p>
 * 子字符串 是字符串中的由连续字符组成的一个序列。
 * <p>
 * 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被视作不同的子串。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "abc"
 * 输出：3
 * 解释：三个回文子串: "a", "b", "c"
 * 示例 2：
 * <p>
 * 输入：s = "aaa"
 * 输出：6
 * 解释：6个回文子串: "a", "a", "a", "aa", "aa", "aaa"
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 1000
 * s 由小写英文字母组成
 * <p>
 * https://leetcode.cn/problems/palindromic-substrings/
 */
public class DP_39_回文子串 {
    public static void main(String[] args) {
        String s = "aba";
        int res = countSubstrings(s);
    }

    public static int countSubstrings(String s) {
        char[] chars = s.toCharArray();
        int[][] dp = new int[chars.length][chars.length];

        int res = 0;
        for (int i = dp.length-1; i >= 0; i--) {
            for (int j = i; j <= dp.length-1; j++) {
                if (chars[i] == chars[j]) {
                    if (j-i <= 1 || dp[i+1][j-1] == 1){
                        dp[i][j] =  1;
                        res++;
                    }
                }
            }
        }
        return res;
    }
}
