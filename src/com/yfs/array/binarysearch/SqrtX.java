package com.yfs.array.binarysearch;

/**
 * 题目编号:[69]
 * <p>
 * 给你一个非负整数 x ，计算并返回 x 的 算术平方根 。
 * <p>
 * 由于返回类型是整数，结果只保留 整数部分 ，小数部分将被 舍去 。
 * <p>
 * 注意：不允许使用任何内置指数函数和算符，例如 pow(x, 0.5) 或者 x ** 0.5 。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：x = 4
 * 输出：2
 * 示例 2：
 * <p>
 * 输入：x = 8
 * 输出：2
 * 解释：8 的算术平方根是 2.82842..., 由于返回类型是整数，小数部分将被舍去。
 *  
 * <p>
 * 提示：
 * <p>
 * 0 <= x <= 231 - 1
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sqrtx
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SqrtX {
    public static void main(String[] args) {
        System.out.println(getSqrt(4));
        System.out.println(getSqrt(8));

    }

    public static int getSqrt(int x) {
        int left = 0;
        int right = x;

        if (x == 1) {
            return 1;
        }
        while (right - left > 1) {
            int mid = left + (right - left) / 2;
            if (x / mid >= mid) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return left;
    }
}
