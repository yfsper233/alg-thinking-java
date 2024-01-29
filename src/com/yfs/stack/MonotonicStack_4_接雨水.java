package com.yfs.stack;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 42. 接雨水
 * <p>
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出：6
 * 解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。
 * 示例 2：
 * <p>
 * 输入：height = [4,2,0,3,2,5]
 * [4,2,0,0,2,4]
 * 输出：9
 * <p>
 * https://leetcode.cn/problems/trapping-rain-water/description/
 */
public class MonotonicStack_4_接雨水 {
    public static void main(String[] args) {
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        int res = trap(height);
    }

    public static int trap(int[] height) {
        Deque<Integer> stack = new LinkedList<>();
        int res = 0;

        for (int i = 0; i < height.length; i++) {
            if (stack.isEmpty() || height[stack.peek()] > height[i]) {
                stack.push(i);
            } else if (height[stack.peek()] == height[i]) {
                stack.pop();
                stack.push(i);
            } else {
                while (!stack.isEmpty() && height[stack.peek()] < height[i]) {
                    int mid = height[stack.pop()];
                    if (stack.isEmpty()) {
                        break;
                    }
                    Integer left = stack.peek();
                    int h = Math.min(height[i], height[left]) - mid;
                    int l = i - left - 1;
                    res += h * l;
                }
                stack.push(i);
            }
        }
        return res;
    }
}
