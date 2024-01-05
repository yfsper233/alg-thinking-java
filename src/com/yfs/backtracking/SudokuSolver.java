package com.yfs.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 编写一个程序，通过填充空格来解决数独问题。
 * <p>
 * 数独的解法需 遵循如下规则：
 * <p>
 * 数字 1-9 在每一行只能出现一次。
 * 数字 1-9 在每一列只能出现一次。
 * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。（请参考示例图）
 * 数独部分空格内已填入了数字，空白格用 '.' 表示。
 * <p>
 * 输入：board = [["5","3",".",".","7",".",".",".","."],["6",".",".","1","9","5",".",".","."],[".","9","8",".",".",".",".","6","."],["8",".",".",".","6",".",".",".","3"],["4",".",".","8",".","3",".",".","1"],["7",".",".",".","2",".",".",".","6"],[".","6",".",".",".",".","2","8","."],[".",".",".","4","1","9",".",".","5"],[".",".",".",".","8",".",".","7","9"]]
 * 输出：[["5","3","4","6","7","8","9","1","2"],["6","7","2","1","9","5","3","4","8"],["1","9","8","3","4","2","5","6","7"],["8","5","9","7","6","1","4","2","3"],["4","2","6","8","5","3","7","9","1"],["7","1","3","9","2","4","8","5","6"],["9","6","1","5","3","7","2","8","4"],["2","8","7","4","1","9","6","3","5"],["3","4","5","2","8","6","1","7","9"]]
 * 解释：输入的数独如上图所示，唯一有效的解决方案如下所示：
 * <p>
 * 提示：
 * <p>
 * board.length == 9
 * board[i].length == 9
 * board[i][j] 是一位数字或者 '.'
 * 题目数据 保证 输入数独仅有一个解
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sudoku-solver
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SudokuSolver {
    public static void main(String[] args) {
        List<List<String>> board = new ArrayList<>();
        board.add(Arrays.asList("5", "3", ".", ".", "7", ".", ".", ".", "."));
        board.add(Arrays.asList("6", ".", ".", "1", "9", "5", ".", ".", "."));
        board.add(Arrays.asList(".", "9", "8", ".", ".", ".", ".", "6", "."));
        board.add(Arrays.asList("8", ".", ".", ".", "6", ".", ".", ".", "3"));
        board.add(Arrays.asList("4", ".", ".", "8", ".", "3", ".", ".", "1"));
        board.add(Arrays.asList("7", ".", ".", ".", "2", ".", ".", ".", "6"));
        board.add(Arrays.asList(".", "6", ".", ".", ".", ".", "2", "8", "."));
        board.add(Arrays.asList(".", ".", ".", "4", "1", "9", ".", ".", "5"));
        board.add(Arrays.asList(".", ".", ".", ".", "8", ".", ".", "7", "9"));

        char[][] chars = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'},
        };
        createSudokuSolver(chars);
    }

    private static void createSudokuSolver(char[][] board) {
        backTracking(board);
        System.out.println();
    }

    private static boolean backTracking(char[][] board) {
        // 遍历行
        for (int row = 0; row < board.length; row++) {
            // 遍历列
            for (int col = 0; col < board.length; col++) {
                // 不为'.'则跳过
                if ('.' != board[row][col]) {
                    continue;
                }
                // 遍历【1-9】选择合适的
                for (char j = '1'; j <= '9'; j++) {
                    if (!isValid(board, row, col, j)) {
                        continue;
                    }
                    board[row][col] = j;
                    if (backTracking(board)) {
                        return true;
                    }
                    board[row][col] = '.';
                }
                // 如果某一个位置,[1-9]都不合适,说明前面某一处填错了,要回溯
                return false;
            }
        }
        return true;
    }

    /**
     * 判断数字j填入(row,col)之后是否合法
     *
     * @param board 数独棋盘
     * @param row   横坐标
     * @param col   纵坐标
     * @param k     即将填入的数字
     * @return 合法则返回true
     */
    private static boolean isValid(char[][] board, int row, int col, char k) {
        //  数字 1-9 在每一行只能出现一次。
        char[] rows = board[row];
        for (int i = 0; i < rows.length; i++) {
            if (k == rows[i]) {
                return false;
            }
        }
        // 数字 1-9 在每一列只能出现一次。
        for (int i = 0; i < board.length; i++) {
            if (k == board[i][col]) {
                return false;
            }
        }
        // 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。（请参考示例图）
        for (int i = (row / 3) * 3; i < (row / 3) * 3 + 3; i++) {
            for (int j = (col / 3) * 3; j < (col / 3) * 3 + 3; j++) {
                if (k == board[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}
