package com.yfs.stack;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * 503.下一个更大元素II
 * <p>
 * 给定一个循环数组（最后一个元素的下一个元素是数组的第一个元素），输出每个元素的下一个更大元素。
 * 数字 x 的下一个更大的元素是按数组遍历顺序，这个数字之后的第一个比它更大的数，这意味着你应该循环地搜索它的下一个更大的数。
 * 如果不存在，则输出 -1。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,2,1]
 * 输出: [2,-1,2]
 * 解释: 第一个 1 的下一个更大的数是 2；数字 2 找不到下一个更大的数；第二个 1 的下一个最大的数需要循环搜索，结果也是 2。
 * 提示:
 * <p>
 * 1 <= nums.length <= 10^4
 * -10^9 <= nums[i] <= 10^9
 * <p>
 * <p>
 * https://leetcode.cn/problems/next-greater-element-ii/description/
 */
public class MonotonicStack_3_下一个更大元素II {
    public static void main(String[] args) {
        int[] nums = {1,1,1};
        int[] res = nextGreaterElements(nums);
    }

    public static int[] nextGreaterElements(int[] nums) {
        // 模拟将两个数组合并
        int[] res = new int[nums.length];
        Arrays.fill(res,-1);
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < nums.length * 2; i++) {
            if (stack.isEmpty() || nums[stack.peek() % nums.length] >= nums[i % nums.length]) {
                stack.push(i % nums.length);
            } else {
                while (!stack.isEmpty() && nums[stack.peek() % nums.length] < nums[i % nums.length]) {
                    Integer index = stack.pop();
                    res[index % nums.length] = nums[i % nums.length];
                }
                stack.push(i % nums.length);
            }
        }
        return res;
    }
}
