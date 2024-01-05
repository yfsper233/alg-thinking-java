package com.yfs.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 题号:[216]
 * 找出所有相加之和为 n 的 k 个数的组合。组合中只允许含有 1 - 9 的正整数，并且每种组合中不存在重复的数字。
 * <p>
 * 说明：
 * <p>
 * 所有数字都是正整数。
 * 解集不能包含重复的组合。 
 * 示例 1:
 * <p>
 * 输入: k = 3, n = 7
 * 输出: [[1,2,4]]
 * 示例 2:
 * <p>
 * 输入: k = 3, n = 9
 * 输出: [[1,2,6], [1,3,5], [2,3,4]]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combination-sum-iii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class CombinationSumIII {
    public static void main(String[] args) {
        int k = 3;
        int n = 7;
        List<List<Integer>> res = getCombinationSumIII(k, n);
        System.out.println(res);
    }

    private static List<List<Integer>> getCombinationSumIII(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        ArrayList<Integer> tmp = new ArrayList<>();
        int curNum = 1;
        backTracking(res, tmp, k, n, curNum);
        return res;
    }

    /**
     *
     * @param res 结果集
     * @param tmp 用于临时保存路径
     * @param k 遍历的深度条件
     * @param target 遍历的求和目标
     * @param curNum 遍历集合开始的起点1，终点9
     */
    private static void backTracking(List<List<Integer>> res, ArrayList<Integer> tmp, int k, int target, int curNum) {
        if (tmp.size() == k && target == 0) {
            res.add(new ArrayList<>(tmp));
            return;
        }

        for (int i = curNum; i <= 9 && target >= 0; i++) {
            target -= i;
            tmp.add(i);
            backTracking(res, tmp, k, target, i+1);
            // 回溯到上一遍历层级
            target += i;
            tmp.remove(tmp.size() - 1);
        }
    }
}
