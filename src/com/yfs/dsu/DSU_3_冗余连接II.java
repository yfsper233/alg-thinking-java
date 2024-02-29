package com.yfs.dsu;

import java.util.*;

/**
 * 685.冗余连接II
 * <p>
 * 在本问题中，有根树指满足以下条件的 有向 图。该树只有一个根节点，所有其他节点都是该根节点的后继。
 * 该树除了根节点之外的每一个节点都有且只有一个父节点，而根节点没有父节点。
 * <p>
 * 输入一个有向图，该图由一个有着 n 个节点（节点值不重复，从 1 到 n）的树及一条附加的有向边构成。
 * 附加的边包含在 1 到 n 中的两个不同顶点间，这条附加的边不属于树中已存在的边。
 * <p>
 * 结果图是一个以边组成的二维数组 edges 。
 * 每个元素是一对 [ui, vi]，用以表示 有向 图中连接顶点 ui 和顶点 vi 的边，其中 ui 是 vi 的一个父节点。
 * <p>
 * 返回一条能删除的边，使得剩下的图是有 n 个节点的有根树。若有多个答案，返回最后出现在给定二维数组的答案。
 * <p>
 * 输入：edges = [[1,2],[1,3],[2,3]]
 * 输出：[2,3]
 * <p>
 * 输入：edges = [[1,2],[2,3],[3,4],[4,1],[1,5]]
 * 输出：[4,1]
 * <p>
 * n == edges.length
 * 3 <= n <= 1000
 * edges[i].length == 2
 * 1 <= ui, vi <= n
 *
 *
 * <p>
 * https://leetcode.cn/problems/redundant-connection-ii/description/
 */
public class DSU_3_冗余连接II {
    public static void main(String[] args) {
        int[][] edges = {{2, 1}, {3, 1}, {4, 2}, {1, 4}};
        int[] res = redundantConnectionII(edges);

        // 1.出现入度为2的点 即一个节点有两个父节点
        //一定是删除指向入度为2的节点的两条边其中的一条，
        // 如果删了一条，判断这个图是一个树，那么这条边就是答案，
        // 同时注意要从后向前遍历，因为如果两天边删哪一条都可以成为树，就删最后那一条。
        // 2.没有出现入度为2的点 出现有向环 去掉环中的任意条边即可
        // 明确没有入度为2的情况，那么一定有向环，找到构成环的边就是要删除的边。
    }

    private static int[] redundantConnectionII(int[][] edges) {
        int[] inDegree = new int[edges.length + 1];
        // 计算每个顶点的入度 并且记录使得入度为2的两条边
        ArrayList<int[]> record = new ArrayList<>();
        for (int i = 0; i <= edges.length - 1; i++) {
            inDegree[edges[i][1]]++;
        }
        for (int i = 0; i <= edges.length - 1; i++) {
            if (inDegree[edges[i][1]] == 2) {
                record.add(0, edges[i]);
            }
        }

        // 情况1
        if (record.size() == 2) {
            if (isTreeAfterRemoveEdge(edges, record.get(0))) {
                return record.get(0);
            } else {
                return record.get(1);
            }

        }
        // 情况2 找到形成有向环的最后一条边
        return getRemoveEdge(edges);

    }

    private static int[] getRemoveEdge(int[][] edges) {
        DisjointSetUnion union = new DisjointSetUnion(edges.length + 1);
        for (int i = 0; i < edges.length; i++) {
            if (union.isConnected(edges[i][0], edges[i][1])) {
                return new int[]{edges[i][0], edges[i][1]};
            } else {
                union.union(edges[i][0], edges[i][1]);
            }
        }
        return new int[0];
    }

    // 通过并查集判断一个图是否同时也是一棵树
    // 如果两个元素在添加之前就已经存在于图中了，那个添加这两个元素之后，必定就不满足树结构了
    private static boolean isTreeAfterRemoveEdge(int[][] edges, int[] del) {
        DisjointSetUnion union = new DisjointSetUnion(edges.length + 1);
        for (int i = 0; i < edges.length; i++) {
            if (edges[i][0] == del[0] && edges[i][1] == del[1]) {
                continue;
            }
            union.union(edges[i][0], edges[i][1]);

        }
        return union.isConnected(del[0], del[1]);
    }
}
