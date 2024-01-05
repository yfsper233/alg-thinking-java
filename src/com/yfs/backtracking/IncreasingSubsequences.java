package com.yfs.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 题号：[491]
 * 给你一个整数数组 nums ，找出并返回所有该数组中不同的递增子序列，递增子序列中 至少有两个元素 。你可以按 任意顺序 返回答案。
 * <p>
 * 数组中可能含有重复元素，如出现两个整数相等，也可以视作递增序列的一种特殊情况。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [4,6,7,7]
 * 输出：[[4,6],[4,6,7],[4,6,7,7],[4,7],[4,7,7],[6,7],[6,7,7],[7,7]]
 * 示例 2：
 * <p>
 * 输入：nums = [4,4,3,2,1]
 * 输出：[[4,4]]
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 15
 * -100 <= nums[i] <= 100
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/increasing-subsequences
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class IncreasingSubsequences {
    public static void main(String[] args) {
//        int[] nums = {4, 6, 7, 7};
        int[] nums = {4, 4, 3, 2, 1};
        List<List<Integer>> res = getIncreasingSubsequences(nums);
        System.out.println(res);
    }

    private static List<List<Integer>> getIncreasingSubsequences(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        backTracking(res, path, nums, 0);
        return res;
    }

    private static void backTracking(List<List<Integer>> res, List<Integer> path, int[] nums, int index) {
        if (path.size() > 1) {
            res.add(new ArrayList<>(path));
        }
        int[] used = new int[201];
        for (int i = index; i < nums.length; i++) {
            if (path.size() > 0 && nums[i] < path.get(path.size() - 1) || used[nums[i]] == 1) {
                continue;
            }
            used[nums[i]] = 1;
            path.add(nums[i]);
            backTracking(res, path, nums, i + 1);
            path.remove(path.size() - 1);
        }
    }
}
