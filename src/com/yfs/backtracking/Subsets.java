package com.yfs.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 题号:[78]
 * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
 * <p>
 * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,3]
 * 输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
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
 * nums 中的所有元素 互不相同
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/subsets
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Subsets {
    public static void main(String[] args) {
        int[] nums = {1};
        List<List<Integer>> res = getSubsets(nums);
        System.out.println(res);
    }

    private static List<List<Integer>> getSubsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        ArrayList<Integer> tmp = new ArrayList<>();
        backTracking(res, tmp, 0, nums);
        return res;
    }

    /**
     *
     * @param res
     * @param tmp
     * @param index
     * @param nums
     */
    private static void backTracking(List<List<Integer>> res, ArrayList<Integer> tmp, int index, int[] nums) {
        res.add(new ArrayList<>(tmp));
        if (index >= nums.length) {
            return;
        }

        for (int i = index; i < nums.length; i++) {
            tmp.add(nums[i]);
            backTracking(res, tmp, i + 1, nums);
            tmp.remove(tmp.size() - 1);
        }
    }
}
