package com.yfs.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 题号:[131]
 * 给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是 回文串 。返回 s 所有可能的分割方案。
 * <p>
 * 回文串 是正着读和反着读都一样的字符串。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "aab"
 * 输出：[["a","a","b"],["aa","b"]]
 * 示例 2：
 * <p>
 * 输入：s = "a"
 * 输出：[["a"]]
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 16
 * s 仅由小写英文字母组成
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/palindrome-partitioning
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class PalindromePartitioning {

    public static void main(String[] args) {
        String s = "aaa";
        List<List<String>> res = getPalindromePartitioning(s);
        System.out.println(res);
    }

    private static List<List<String>> getPalindromePartitioning(String s) {
        List<List<String>> res = new ArrayList<>();
        List<String> path = new ArrayList<>();
        int startIndex = 0;
        backTracking(res, path, s, startIndex);
        return res;

    }

    /**
     *
     * @param res 结果集
     * @param path 暂存路径
     * @param s 被分割的字符串
     * @param startIndex 字符串被分割位置的起点
     */
    private static void backTracking(List<List<String>> res, List<String> path, String s, int startIndex) {
        if (startIndex >= s.length()) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = startIndex; i < s.length(); i++) {
            if (isPalindrome(s, startIndex, i)) {
                path.add(s.substring(startIndex, i+1));
            } else {
                continue;
            }
            backTracking(res, path, s, i + 1);
            path.remove(path.size() - 1);
        }

    }

    private static boolean isPalindrome(String s, int startIndex, int end) {
        for (int i = startIndex, j = end; i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }
        return true;
    }
}
