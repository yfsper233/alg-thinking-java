package com.yfs.greedy;

/**
 * 738. 单调递增的数字
 * <p>
 * 当且仅当每个相邻位数上的数字 x 和 y 满足 x <= y 时，我们称这个整数是单调递增的。
 * <p>
 * 给定一个整数 n ，返回 小于或等于 n 的最大数字，且数字呈 单调递增 。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: n = 10
 * 输出: 9
 * 示例 2:
 * <p>
 * 输入: n = 1234
 * 输出: 1234
 * 示例 3:
 * <p>
 * 输入: n = 332
 * 输出: 299
 * <p>
 * <p>
 * 提示:
 * <p>
 * 0 <= n <= 109
 * <p>
 * https://leetcode.cn/problems/monotone-increasing-digits/description/
 */
public class Greedy_MonotoneIncreasingDigits {
    public static void main(String[] args) {
//        int res = monotoneIncreasingDigits(332);
        int res2 = monotoneIncreasingDigitsII(100);
    }

    private static int monotoneIncreasingDigitsII(int n) {
        char[] chars = String.valueOf(n).toCharArray();
        int nineStart = chars.length;
        for (int j = chars.length-1; j > 0; j--) {
            if (chars[j] - chars[j - 1] < 0) {
                nineStart = j;
                chars[j-1] --;
            }
        }
        for (int i = nineStart; i < chars.length; i++) {
            chars[i] = '9';
        }
        String s = String.valueOf(chars);
        return Integer.parseInt(s);
    }

    private static int monotoneIncreasingDigits(int input) {
        for (int i = input; i >= 0; i--) {
            if (check(i)){
                return i;
            }
        }
        return 0;
    }

    private static boolean check(int i) {
        char[] chars = String.valueOf(i).toCharArray();
        for (int j = 1; j < chars.length; j++) {
            if (chars[j] - chars[j - 1] < 0) {
                return false;
            }
        }
        return true;
    }
}
