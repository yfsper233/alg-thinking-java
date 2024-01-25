package com.yfs.dynamicprogramming;

/**
 * 392.判断子序列
 * <p>
 * 给定字符串 s 和 t ，判断 s 是否为 t 的子序列。
 * <p>
 * 字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。（例如，"ace"是"abcde"的一个子序列，而"aec"不是）。
 * <p>
 * 进阶：
 * <p>
 * 如果有大量输入的 S，称作 S1, S2, ... , Sk 其中 k >= 10亿，你需要依次检查它们是否为 T 的子序列。在这种情况下，你会怎样改变代码？
 * <p>
 * 致谢：
 * <p>
 * 特别感谢 @pbrother 添加此问题并且创建所有测试用例。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "abc", t = "ahbgdc"
 * 输出：true
 * 示例 2：
 * <p>
 * 输入：s = "axc", t = "ahbgdc"
 * 输出：false
 * <p>
 * <p>
 * 提示：
 * <p>
 * 0 <= s.length <= 100
 * 0 <= t.length <= 10^4
 * 两个字符串都只由小写字符组成。
 * <p>
 * https://leetcode.cn/problems/is-subsequence/description/
 */
public class DP_35_判断子序列 {
    public static void main(String[] args) {
        String s = "abc";
        String t = "ahbgdc";
        boolean res = isSubsequence(s, t);
    }

    private static boolean isSubsequence(String s, String t) {
        char[] chars1 = s.toCharArray();
        char[] chars2 = t.toCharArray();
        if (chars1.length ==0 ){
            return true;
        }
        if (chars2.length==0){
            return false;
        }

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
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[chars1.length - 1][chars2.length - 1] == chars1.length;
    }
}
