package com.yfs.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 题号：[47]
 * 给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,1,2]
 * 输出：
 * [[1,1,2],
 * [1,2,1],
 * [2,1,1]]
 * 示例 2：
 * <p>
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 8
 * -10 <= nums[i] <= 10
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/permutations-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class PermutationsII {
    public static void main(String[] args) {
        int[] candidates = {1, 1, 3};
        List<List<Integer>> res = getPermutations(candidates);
        System.out.println(res);
    }

    private static List<List<Integer>> getPermutations(int[] candidates) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();
        int[] used = new int[candidates.length];
        Arrays.sort(candidates);
        backTracking(res, tmp, used, candidates);
        return res;

    }

    /**
     *
     * @param res
     * @param tmp
     * @param used
     * @param candidates
     */
    private static void backTracking(List<List<Integer>> res, List<Integer> tmp, int[] used, int[] candidates) {
        if (tmp.size() == candidates.length) {
            res.add(new ArrayList<>(tmp));
            return;
        }
        for (int i = 0; i < candidates.length; i++) {
            // candidates[i]已经在集合中了,就不能把与其相等的candidates[i-1]再放进来
            if (i > 0 && used[i - 1] == 0 && candidates[i - 1] == candidates[i]) {
                continue;
            }
            // 跳过自身,保证一个元素不会多次出现
            if (used[i] == 0) {
                used[i] = 1;
                tmp.add(candidates[i]);
                backTracking(res, tmp, used, candidates);
                used[i] = 0;
                tmp.remove(tmp.size() - 1);
            }
        }
    }
}
