package com.yfs.dynamicprogramming;

/**
 * 题号：96 不同的搜索二叉树
 * <p>
 * 给你一个整数 n ，求恰由 n 个节点组成且节点值从 1 到 n 互不相同的 二叉搜索树 有多少种？返回满足题意的二叉搜索树的种数。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：n = 3
 * 输出：5
 * <p>
 * 示例 2：
 * <p>
 * 输入：n = 1
 * 输出：1
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 19
 * <p>
 * https://leetcode.cn/problems/unique-binary-search-trees/description/
 */
public class DP_7_UniqueBinarySearchTrees {
    public static void main(String[] args) {
        int res = uniqueBinarySearchTrees(3);
    }

    private static int uniqueBinarySearchTrees(int n) {
        // n = 2 根节点为1的搜索树数量+根节点为2的搜索树数量
        // n = 3 元素1为头结点搜索树的数量 + 元素2为头结点搜索树的数量 + 元素3为头结点搜索树的数量
        //        元素1为头结点搜索树的数量 = 右子树有2个元素的搜索树数量 * 左子树有0个元素的搜索树数量
        //        元素2为头结点搜索树的数量 = 右子树有1个元素的搜索树数量 * 左子树有1个元素的搜索树数量
        //        元素3为头结点搜索树的数量 = 右子树有0个元素的搜索树数量 * 左子树有2个元素的搜索树数量
        // dp[3] = dp[2] * dp[0] + dp[1] * dp[1] + dp[0]*dp[2]
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = i-1; j >= 0; j--) {
                dp[i] = dp[i] + dp[j] * dp[i-1-j];
            }

        }
        return dp[n];
    }
}
