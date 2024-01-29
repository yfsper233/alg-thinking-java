package com.yfs.greedy;

import com.yfs.others.BiTreeNode;

/**
 * 968. 监控二叉树
 * <p>
 * 给定一个二叉树，我们在树的节点上安装摄像头。
 * <p>
 * 节点上的每个摄影头都可以监视其父对象、自身及其直接子对象。
 * <p>
 * 计算监控树的所有节点所需的最小摄像头数量。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：[0,0,null,0,0]
 * 输出：1
 * 解释：如图所示，一台摄像头足以监控所有节点。
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * 输入：[0,0,null,0,null,0,null,null,0]
 * 输出：2
 * 解释：需要至少两个摄像头来监视树的所有节点。 上图显示了摄像头放置的有效位置之一。
 * <p>
 * 提示：
 * <p>
 * 给定树的节点数的范围是 [1, 1000]。
 * 每个节点的值都是 0。
 * <p>
 * https://leetcode.cn/problems/binary-tree-cameras/description/
 */
public class Greedy_17_BinaryTreeCameras {
    private static int res = 0;

    public static void main(String[] args) {
        BiTreeNode root = new BiTreeNode();
        BiTreeNode temp = new BiTreeNode();
        root.setLeft(temp);
        temp.setLeft(new BiTreeNode());
        temp.setRight(new BiTreeNode());
        int res = minCameraCover(root);
    }


    private static int minCameraCover(BiTreeNode biTreeNode) {
        // 贪心策略，优先让叶子结点的父节点安装摄像头
        // 后序遍历 左中右
        // 根据子节点状态确定父节点状态
        if (trace(biTreeNode) == 0){
            res++;
        }
        return res;
    }

    private static int trace(BiTreeNode biTreeNode) {
        //节点状态 0无摄像头覆盖 1安装摄像头 2有摄像头覆盖
        // 结束条件 遍历到了nil结点
        if (biTreeNode == null){
            return 2;
        }
        int leftStatus = trace(biTreeNode.getLeft());
        int rightStatus = trace(biTreeNode.getRight());
        if (leftStatus==2 && rightStatus == 2){
            return 0;
        }
        if (leftStatus == 0 || rightStatus == 0){
            res++;
            return 1;
        }
        if (leftStatus == 1  || rightStatus == 1){
            return 2;
        }
        return -1;
    }
}
