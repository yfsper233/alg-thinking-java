package com.yfs.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 797.所有可能的路径
 * <p>
 * 给你一个有 n 个节点的 有向无环图（DAG），请你找出所有从节点 0 到节点 n-1 的路径并输出（不要求按特定顺序）
 * <p>
 * graph[i] 是一个从节点 i 可以访问的所有节点的列表（即从节点 i 到节点 graph[i][j]存在一条有向边）。
 * <p>
 * 输入：graph = [[1,2],[3],[3],[]]
 * 输出：[[0,1,3],[0,2,3]]
 * 解释：有两条路径 0 -> 1 -> 3 和 0 -> 2 -> 3
 * <p>
 * 输入：graph = [[4,3,1],[3,2,4],[3],[4],[]]
 * 输出：[[0,4],[0,3,4],[0,1,3,4],[0,1,2,3,4],[0,1,4]]
 */
public class Graph_1_所有可能的路径 {
    public static void main(String[] args) {
        int[][] graph = {{4,3,1}, {3,2,4}, {3}, {4}, {}};
        List<List<Integer>> res = allPathsSourceTarget(graph);
    }

    public static List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        path.add(0);
        dfs(graph, res, path, 0);
        return res;
    }

    private static void dfs(int[][] graph, List<List<Integer>> res, List<Integer> path, int cur) {
        if (cur == graph.length - 1) {
            path.add(cur);
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < graph[cur].length; i++) {
            path.add(graph[cur][i]);
            dfs(graph, res, path, graph[cur][i]);
            path.remove(path.size() - 1);
        }
    }
}
