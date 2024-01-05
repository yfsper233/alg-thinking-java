package com.yfs.backtracking;


import java.util.ArrayList;
import java.util.List;

/**
 * 题号:[51]
 * n 皇后问题 研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 * <p>
 * 给你一个整数 n ，返回所有不同的 n 皇后问题 的解决方案。
 * <p>
 * 每一种解法包含一个不同的 n 皇后问题 的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
 * <p>
 * 输入：n = 4
 * 输出：[[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
 * 解释：如上图所示，4 皇后问题存在两个不同的解法。
 * 示例 2：
 * <p>
 * 输入：n = 1
 * 输出：[["Q"]]
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 9
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/n-queens
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class NQueens {
    public static void main(String[] args) {
        List<List<String>> res = getNQueens(9);
        for (int i = 0; i < res.size(); i++) {
            System.out.println(res.get(i));
        }
        System.out.println(res.size());
    }

    private static List<List<String>> getNQueens(int n) {

        List<List<String>> res = new ArrayList<>();
        ArrayList<int[]> tmp = new ArrayList<>();
        backTracking(res, tmp, 0,n);
        return res;
    }

    private static void backTracking(List<List<String>> res, ArrayList<int[]> tmp, int start, int scale) {
        if (start == scale) {
            res.add(generate(tmp));
            return;
        }
        for (int i = 0; i < scale; i++) {
            int[] coordinates = {i, start};
            if (!valid(tmp, coordinates)) {
                continue;
            }
            tmp.add(coordinates);
            backTracking(res, tmp, start+1, scale);
            tmp.remove(coordinates);
        }
    }

    /**
     * 每当放置一个皇后时,判断是否与其他皇后的位置相冲突
     * @param tmp 已有的合法的皇后位置坐标集合
     * @param coordinates 即将放置的皇后坐标
     * @return 不冲突 true
     */
    private static boolean valid(ArrayList<int[]> tmp, int[] coordinates) {
        for (int k = 0; k < tmp.size(); k++) {
            // 当i*j==0时说明两个棋子在同一条横线或者竖线上,
            // 当两者绝对值相等时,说明两个棋子在一条斜线上
            int i = tmp.get(k)[0] - coordinates[0];
            int j = tmp.get(k)[1] - coordinates[1];
            if (i * j == 0 || Math.abs(i) == Math.abs(j)) {
                return false;
            }
        }
        return true;

    }

    /**
     * 根据皇后的坐标生成题目要求的格式
     * @param tmp
     * @return
     */
    private static List<String> generate(ArrayList<int[]> tmp) {

        String[][] strings = new String[tmp.size()][tmp.size()];
        for (int[] coordinates : tmp) {
            strings[coordinates[0]][coordinates[1]] = "Q";
        }
        List<String> res = new ArrayList<>();
        for (String[] string : strings) {
            StringBuffer sb = new StringBuffer();
            for (String s : string) {
                if ("Q".equals(s)) {
                    sb.append("Q");
                } else {
                    sb.append(".");
                }
            }
            res.add(sb.toString());
        }
        return res;
    }
}
