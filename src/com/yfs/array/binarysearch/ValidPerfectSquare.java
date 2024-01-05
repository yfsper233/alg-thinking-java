package com.yfs.array.binarysearch;

import java.util.Scanner;

/**
 * 题目编号:[376]
 * 给定一个 正整数 num ，编写一个函数，如果 num 是一个完全平方数，则返回 true ，否则返回 false 。
 * <p>
 * 进阶：不要 使用任何内置的库函数，如  sqrt 。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：num = 16
 * 输出：true
 * 示例 2：
 * <p>
 * 输入：num = 14
 * 输出：false
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= num <= 2^31 - 1
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-perfect-square
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ValidPerfectSquare {
    public static void main(String[] args) {

        int x = 2;
        Scanner scanner = new Scanner(System.in);
        while (true){
            String s = scanner.nextLine();
            boolean flag = checkValidPerfectSquare(Integer.parseInt(s));
            System.out.println(flag);
        }
    }

    private static boolean checkValidPerfectSquare(int x) {
        if (x==1){
            return true;
        }
        int res = SqrtX.getSqrt(x);
        if (res*res==x){
            return true;
        }
        return false;
    }
}
