package com.yfs.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 题号:[90]
 * <p>
 * 给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的子集（幂集）。
 * <p>
 * 解集 不能 包含重复的子集。返回的解集中，子集可以按 任意顺序 排列。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,2]
 * 输出：[[],[1],[1,2],[1,2,2],[2],[2,2]]
 * 示例 2：
 * <p>
 * 输入：nums = [0]
 * 输出：[[],[0]]
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 10
 * -10 <= nums[i] <= 10
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/subsets-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SubsetsII {
    public static void main(String[] args) {
        int[] candidates = new int[]{1,2,2};
        List<List<Integer>> res = getSubsetsII(candidates);
        System.out.println(res);
    }

    private static List<List<Integer>> getSubsetsII(int[] candidates) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> subSet = new ArrayList<>();
        boolean[] used = new boolean[candidates.length];
        Arrays.sort(candidates);
        backTracking(res, subSet, 0, candidates, used);

        return res;
    }

    /**
     *
     * @param res
     * @param subSet
     * @param index
     * @param candidates
     * @param used
     */
    private static void backTracking(List<List<Integer>> res, List<Integer> subSet, int index, int[] candidates, boolean[] used) {
        res.add(new ArrayList<>(subSet));
        if (index >= candidates.length) {
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            // 这里要求先排序,利用标记数组"树层"去重
            if (i > 0 && candidates[i - 1] == candidates[i] && used[i - 1] == false) {
                continue;
            }
            subSet.add(candidates[i]);
            used[i] = true;
            backTracking(res, subSet, i + 1, candidates, used);
            subSet.remove(subSet.size() - 1);
            used[i] = false;
        }

    }
}
