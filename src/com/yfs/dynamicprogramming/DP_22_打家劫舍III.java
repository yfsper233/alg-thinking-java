package com.yfs.dynamicprogramming;

import com.yfs.dynamicprogramming.dependicy.TreeNode;

/**
 * 337:打家劫舍III
 * <p>
 * 小偷又发现了一个新的可行窃的地区。这个地区只有一个入口，我们称之为 root 。
 * <p>
 * 除了 root 之外，每栋房子有且只有一个“父“房子与之相连。一番侦察之后，聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。 如果 两个直接相连的房子在同一天晚上被打劫 ，房屋将自动报警。
 * <p>
 * 给定二叉树的 root 。返回 在不触动警报的情况下 ，小偷能够盗取的最高金额 。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * <p>
 * <p>
 * 输入: root = [3,2,3,null,3,null,1]
 * 输出: 7
 * 解释: 小偷一晚能够盗取的最高金额 3 + 3 + 1 = 7
 * 示例 2:
 * <p>
 * <p>
 * <p>
 * 输入: root = [3,4,5,1,3,null,1]
 * 输出: 9
 * 解释: 小偷一晚能够盗取的最高金额 4 + 5 = 9
 * <p>
 * <p>
 * 提示：
 * <p>
 * 树的节点数在 [1, 104] 范围内
 * 0 <= Node.val <= 104
 * <p>
 * <p>
 * https://leetcode.cn/problems/house-robber-iii/description/
 */
public class DP_22_打家劫舍III {
    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(3);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(3);
        TreeNode treeNode5 = new TreeNode(1);

        treeNode2.right = treeNode4;
        treeNode3.right = treeNode5;
        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;

        int res = houseRobberIII(treeNode1);
    }

    private static int houseRobberIII(TreeNode treeNode) {
        int[] res = robTree(treeNode);
        return Math.max(res[0], res[1]);
    }

    private static int[] robTree(TreeNode treeNode) {
        // dp[0] 不偷当前节点的最大收益
        // dp[1] 偷当前节点的最大收益
        if (treeNode == null) {
            return new int[2];
        }
        if (treeNode.left == null && treeNode.right == null) {
            return new int[]{0, treeNode.val};
        }
        int[] left = robTree(treeNode.left);
        int[] right = robTree(treeNode.right);
        // 偷当前节点 则不能偷两个子节点
        int robCur = left[0] + right[0] + treeNode.val;
        // 不偷当前节点 子节点偷与不偷都有可能 取收益高的
        int noRobCur = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        return new int[]{noRobCur, robCur};

    }
}
