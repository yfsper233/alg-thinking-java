package com.yfs.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 题号:[93]
 * 有效 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。
 * <p>
 * 例如："0.1.2.201" 和 "192.168.1.1" 是 有效 IP 地址，但是 "0.011.255.245"、"192.168.1.312" 和 "192.168@1.1" 是 无效 IP 地址。
 * 给定一个只包含数字的字符串 s ，用以表示一个 IP 地址，返回所有可能的有效 IP 地址，这些地址可以通过在 s 中插入 '.' 来形成。你 不能 重新排序或删除 s 中的任何数字。你可以按 任何 顺序返回答案。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "25525511135"
 * 输出：["255.255.11.135","255.255.111.35"]
 * 示例 2：
 * <p>
 * 输入：s = "0000"
 * 输出：["0.0.0.0"]
 * 示例 3：
 * <p>
 * 输入：s = "101023"
 * 输出：["1.0.10.23","1.0.102.3","10.1.0.23","10.10.2.3","101.0.2.3"]
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 20
 * s 仅由数字组成
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/restore-ip-addresses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class RestoreIpAddresses {
    public static void main(String[] args) {
        String s = "101023";
        List<String> res = restoreIpAddresses(s);
        System.out.println(res);
    }

    private static List<String> restoreIpAddresses(String s) {
        if (s == null ||!s.matches("^[0-9]{4,12}$")) {
            return new ArrayList<>();
        }
        List<String> res = new ArrayList<>();
        int startIndex = 0;
        backTracking(res, startIndex, new StringBuffer(s), 0);
        return res;
    }

    /**
     *
     * @param res 结果集
     * @param startIndex 本轮分割起点
     * @param s 输入的待处理字符参数
     * @param length 标记"."的个数,最多3个
     */
    private static void backTracking(List<String> res, int startIndex, StringBuffer s, int length) {

        if (length == 3) {
            if (isIpAddress(s, startIndex, s.length() - 1)) {
                res.add(new String(s));
            }
            return;
        }

        for (int i = startIndex; i < s.length(); i++) {
            if (isIpAddress(s, startIndex, i)) {
                s.insert(  i + 1, ".");
                length++;
                // 注意多拼上".",i+2
                backTracking(res, i + 2, s, length);
                s.deleteCharAt( i + 1);
                length--;
            } else {
                break;
            }
        }
    }

    /**
     * 判断是否否和IP地址的格式要求
     *
     * @param s
     * @param startIndex
     * @param i
     * @return
     */
    private static boolean isIpAddress(StringBuffer s, int startIndex, int i) {
        if (startIndex > s.length() - 1) {
            return false;
        }
        String str = s.substring(startIndex, i + 1);
        if (str.startsWith("0") && !str.equals("0")) {
            return false;
        }
        if (!str.matches("^[0-9]{1,3}$")){
            return false;
        }
        int ip = Integer.parseInt(str);
        return ip <= 255 && ip >= 0;
    }
}
