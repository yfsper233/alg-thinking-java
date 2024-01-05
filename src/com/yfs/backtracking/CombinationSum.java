package com.yfs.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 题号:[39]
 * 给你一个 无重复元素 的整数数组 candidates 和一个目标整数 target ，找出 candidates 中可以使数字和为目标数 target 的 所有 不同组合 ，并以列表形式返回。你可以按 任意顺序 返回这些组合。
 * <p>
 * candidates 中的 同一个 数字可以 无限制重复被选取 。如果至少一个数字的被选数量不同，则两种组合是不同的。 
 * <p>
 * 对于给定的输入，保证和为 target 的不同组合数少于 150 个。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：candidates = [2,3,6,7], target = 7
 * 输出：[[2,2,3],[7]]
 * 解释：
 * 2 和 3 可以形成一组候选，2 + 2 + 3 = 7 。注意 2 可以使用多次。
 * 7 也是一个候选， 7 = 7 。
 * 仅有这两种组合。
 * 示例 2：
 * <p>
 * 输入: candidates = [2,3,5], target = 8
 * 输出: [[2,2,2,2],[2,3,3],[3,5]]
 * 示例 3：
 * <p>
 * 输入: candidates = [2], target = 1
 * 输出: []
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= candidates.length <= 30
 * 1 <= candidates[i] <= 200
 * candidate 中的每个元素都 互不相同
 * 1 <= target <= 500
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combination-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class CombinationSum {
    public static void main(String[] args) {
        int[] candidates = {5,2, 3};
        int target = 8;

        Arrays.sort(candidates);
        List<List<Integer>> res = getCombinationSum(candidates, target);
        System.out.println(res);
    }

    private static List<List<Integer>> getCombinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        ArrayList<Integer> curList = new ArrayList<>();
        if (candidates == null || candidates.length == 0) {
            return res;
        }
        int curSum = 0;
        int index = 0;
        backtracking(res, curList, curSum, index, target, candidates);
        return res;
    }

    /**
     * @param res        结果集
     * @param curList    当前回溯路径的集合
     * @param curSum     当前回溯路径的和
     * @param index      当前遍历到的集合索引
     * @param target     目标值
     * @param candidates 输入的int[]数组条件
     */
    private static void backtracking(List<List<Integer>> res, List<Integer> curList, int curSum, int index, int target, int[] candidates) {
        if (curSum > target) {
            return;
        }

        if (curSum == target) {
            res.add(new ArrayList<>(curList));
            return;
        }

        for (int i = index; i < candidates.length && curSum + candidates[i] <= target; i++) {
            curSum += candidates[i];
            curList.add(candidates[i]);
            backtracking(res, curList, curSum, index, target, candidates);
            // index增加，缩小下层遍历的结果集
            index += 1;
            curSum -= candidates[i];
            curList.remove(curList.size() - 1);
        }
    }
}
