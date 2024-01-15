package com.yfs.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 56. 合并区间
 * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返回 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
 * 输出：[[1,6],[8,10],[15,18]]
 * 解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * 示例 2：
 * <p>
 * 输入：intervals = [[1,4],[4,5]]
 * 输出：[[1,5]]
 * 解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= intervals.length <= 104
 * intervals[i].length == 2
 * 0 <= starti <= endi <= 104
 * <p>
 * https://leetcode.cn/problems/merge-intervals/description/
 */
public class Greedy_MergeIntervals {
    public static void main(String[] args) {
        int[][] input = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] res = mergeIntervals(input);
    }

    private static int[][] mergeIntervals(int[][] input) {
        if (input.length == 1){
            return input;
        }

        ArrayList<int[]> list = new ArrayList<>();
        Arrays.sort(input, ((o1, o2) -> o1[0] - o2[0]));
        int left = input[0][0];
        int right = input[0][1];

        for (int i = 1; i < input.length; i++) {
            if (input[i][0] <= right) {
                right = Math.max(input[i][1], right);
            } else {
                addRes(left, right , list);
                left = input[i][0];
                right = input[i][1];
            }
            if (i == input.length-1){
                addRes(left, right , list);
            }
        }
        int[][] res = new int[list.size()][];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    private static void addRes(int left, int right, List<int[]> list){
        int[] ints = new int[2];
        ints[0] = left;
        ints[1] = right;
        list.add(ints);
    }

}
