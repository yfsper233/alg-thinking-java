package com.yfs.stack;

import jdk.nashorn.internal.ir.annotations.Ignore;

import java.util.LinkedList;

/**
 * 739. 每日温度
 * <p>
 * 请根据每日 气温 列表，重新生成一个列表。对应位置的输出为：要想观测到更高的气温，至少需要等待的天数。如果气温在这之后都不会升高，请在该位置用 0 来代替。
 * <p>
 * 例如，给定一个列表 temperatures = [73, 74, 75, 71, 69, 72, 76, 73]，你的输出应该是 [1, 1, 4, 2, 1, 1, 0, 0]。
 * <p>
 * 提示：气温 列表长度的范围是 [1, 30000]。每个气温的值的均为华氏度，都是在 [30, 100] 范围内的整数。
 * <p>
 * https://leetcode.cn/problems/daily-temperatures/description/
 */
public class MonotonicStack_1_每日温度 {
    public static void main(String[] args) {
        int[] temperatures = {73, 74, 75, 71, 69, 72, 76, 73};
//        int[] res = dailyTemperatures(temperatures);
        int[] res2 = dailyTemperaturesII(temperatures);

    }

    private static int[] dailyTemperaturesII(int[] temperatures) {
        int[] res = new int[temperatures.length];
        LinkedList<Integer> stack = new LinkedList<>();
        stack.push(0);
        for (int i = 1; i < temperatures.length; i++) {
            if (stack.isEmpty() || temperatures[i] <= temperatures[stack.peekLast()]) {
                stack.addLast(i);
                continue;
            }
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peekLast()]) {
                Integer index = stack.pollLast();
                res[index] = i - index;
            }
            stack.addLast(i);
        }
        return res;
    }

    // O（n*n） 超时
    @Ignore
    public static int[] dailyTemperatures(int[] temperatures) {
        int[] res = new int[temperatures.length];
        for (int i = 0; i < temperatures.length; i++) {
            for (int j = i + 1; j < temperatures.length; j++) {
                if (temperatures[j] > temperatures[i]) {
                    res[i] = j - i;
                    break;
                }
            }
        }
        return res;
    }
}
