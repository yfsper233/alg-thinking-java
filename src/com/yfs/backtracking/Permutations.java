package com.yfs.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 题号：[46]
 * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 * 示例 2：
 * <p>
 * 输入：nums = [0,1]
 * 输出：[[0,1],[1,0]]
 * 示例 3：
 * <p>
 * 输入：nums = [1]
 * 输出：[[1]]
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 6
 * -10 <= nums[i] <= 10
 * nums 中的所有整数 互不相同
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/permutations
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Permutations {
    public static void main(String[] args) {
//        int[] nums = {1, 2, 3};
//        int[] nums={0,1};
        int[] nums={};
        List<List<Integer>> res = getPermutations(nums);
        System.out.println(res);
    }

    private static List<List<Integer>> getPermutations(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();
        int[] used = new int[nums.length];
        backTracking(res, tmp, nums, used
        );
        return res;
    }

    private static void backTracking(List<List<Integer>> res, List<Integer> tmp, int[] nums, int[] used) {
        if (tmp.size() == nums.length) {
            res.add(new ArrayList<>(tmp));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i]==1){
                continue;
            }
            tmp.add(nums[i]);
            used[i] = 1;
            backTracking(res, tmp, nums, used);
            used[i] = 0;
            tmp.remove(tmp.size() - 1);
        }
    }
}
