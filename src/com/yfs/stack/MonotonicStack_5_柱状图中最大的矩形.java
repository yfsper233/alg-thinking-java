package com.yfs.stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 84.柱状图中最大的矩形
 * <p>
 * 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
 * <p>
 * 求在该柱状图中，能够勾勒出来的矩形的最大面积。
 */
public class MonotonicStack_5_柱状图中最大的矩形 {
    public static void main(String[] args) {
        int[] input = {2,1,5,6,2,3};
        // 动态规划 找出超出内存限制
//        int res = largestRectangleArea(input);
        int res2 = largestRectangleAreaII(input);
    }

    public static int largestRectangleAreaIII(int[] heights) {
        int res = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        int[] new_heights = new int[heights.length + 2];
        for (int i = 1; i < heights.length + 1; i++) {
            new_heights[i] = heights[i - 1];
        }
        for (int i = 0; i < new_heights.length; i++) {
            while (!stack.isEmpty() && new_heights[stack.peek()] > new_heights[i]) {
                int cur = stack.pop();
                int l = stack.peek();
                int r = i;
                res = Math.max(res, (r - l - 1) * new_heights[cur]);
            }
            stack.push(i);
        }
        return res;
    }

    private static int largestRectangleAreaII(int[] heights) {
        Deque<Integer> stack = new LinkedList<>();
        int res = 0;
        int[] new_heights = new int[heights.length + 2];
        for (int i = 1; i < heights.length + 1; i++) {
            new_heights[i] = heights[i - 1];
        }
        for (int i = 0; i < new_heights.length; i++) {
            while (!stack.isEmpty() && new_heights[stack.peek()] > new_heights[i]) {
                Integer cur = stack.pop();
                int left = stack.peek();
                int w = i - left - 1;
                res = Math.max(res, new_heights[cur] * w);
            }
            stack.push(i);
        }
        return res;
    }

    public static int largestRectangleArea(int[] heights) {
        // 动态规划 找出超出内存限制
        int[][] dp = new int[heights.length][heights.length];
        int res = 0;
        for (int i = dp.length - 1; i >= 0; i--) {
            for (int j = i; j < heights.length; j++) {
                if (j == i) {
                    dp[i][j] = heights[j];
                    res = Math.max(dp[i][j] * (j - i + 1), res);
                    continue;
                }
                dp[i][j] = Math.min(dp[i + 1][j], dp[i][j - 1]);
                res = Math.max(dp[i][j] * (j - i + 1), res);
            }
        }
        return res;
    }
}
