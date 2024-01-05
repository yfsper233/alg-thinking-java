package com.yfs.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 题号:[40]
 * 给定一个候选人编号的集合 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * <p>
 * candidates 中的每个数字在每个组合中只能使用 一次 。
 * <p>
 * 注意：解集不能包含重复的组合。 
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: candidates = [10,1,2,7,6,1,5], target = 8,
 * 输出:
 * [
 * [1,1,6],
 * [1,2,5],
 * [1,7],
 * [2,6]
 * ]
 * 示例 2:
 * <p>
 * 输入: candidates = [2,5,2,1,2], target = 5,
 * 输出:
 * [
 * [1,2,2],
 * [5]
 * ]
 *  
 * <p>
 * 提示:
 * <p>
 * 1 <= candidates.length <= 100
 * 1 <= candidates[i] <= 50
 * 1 <= target <= 30
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combination-sum-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class CombinationSumII {
    public static void main(String[] args) {
        int[] candidates = new int[]{10, 1, 2, 7, 6, 1, 5};
        int target = 8;
        Arrays.sort(candidates);
        List<List<Integer>> res = getCombinationII(candidates, target);
        System.out.println(res);
    }

    private static List<List<Integer>> getCombinationII(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        ArrayList<Integer> path = new ArrayList<>();

        if (candidates == null || candidates.length == 0) {
            return res;
        }
        boolean[] used = new boolean[candidates.length];
        int startIndex = 0;
        backTracking(res, path, startIndex, candidates, target, used);
        return res;
    }

    private static void backTracking(List<List<Integer>> res, ArrayList<Integer> path, int startIndex, int[] candidates, int target, boolean[] used) {
        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = startIndex; i < candidates.length && target >= 0; i++) {
            if (i > 0 && used[i - 1] == false && candidates[i - 1] == candidates[i]) {
                continue;
            }

            used[i] = true;
            path.add(candidates[i]);
            backTracking(res, path, i + 1, candidates, target - candidates[i], used);
            used[i] = false;
            path.remove(path.size() - 1);
        }

    }
}
