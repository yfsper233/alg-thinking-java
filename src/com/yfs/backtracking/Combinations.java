package com.yfs.backtracking;

import java.util.ArrayList;

/**
 * 题号:[77]
 * 给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。
 * <p>
 * 你可以按 任何顺序 返回答案。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 4, k = 2
 * 输出：
 * [
 * [2,4],
 * [3,4],
 * [2,3],
 * [1,2],
 * [1,3],
 * [1,4],
 * ]
 * 示例 2：
 * <p>
 * 输入：n = 1, k = 1
 * 输出：[[1]]
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 20
 * 1 <= k <= n
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combinations
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Combinations {
    private static ArrayList<ArrayList<Integer>> res = new ArrayList<>();
    private static ArrayList<Integer> path = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println(getCombinations(4, 2));
    }

    /**
     * 返回范围 [1, n] 中所有可能的 k 个数的组合
     * @param n
     * @param k
     * @return
     */
    public static ArrayList<ArrayList<Integer>> getCombinations(int n,int k){
        backtracking(n,k,1);
        return res;
    }

    /**
     *
     * @param n 遍历集合的右极值
     * @param k 遍历树的深度
     * @param index 当前遍历层次的起点
     */
    private static void backtracking(int n, int k, int index) {
        if (path.size() == k) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = index; i <= n-(k-path.size())+1; i++) {
            path.add(i);
            backtracking(n,k,i+1);
            path.remove(path.size()-1);
        }
    }
}
