package com.yfs.dsu;


/**
 * 并查集（Disjoint Set Union，DSU）是一种处理不相交集合的合并与查询问题的数据结构。它支持两种操作：查找（Find）和合并（Union）。
 * 并查集非常适用于处理一些不相交集合的合并问题，常见于图论中，比如网络中的连通分量、最小生成树算法中的Kruskal算法等场景
 * <p>
 * 查找（Find）
 * 查找操作用于确定某个元素属于哪个集合，通常是找到该元素的根节点。
 * 在并查集中，每个集合由一个代表元素（根节点）表示，集合中的所有元素都直接或间接指向这个代表元素。
 * <p>
 * 合并（Union）
 * 合并操作用于将两个不相交的集合合并为一个集合。这通常通过将一个集合的根节点连接到另一个集合的根节点来完成。
 * <p>
 * 并查集的核心思想
 * 路径压缩（Path Compression）：在执行查找操作时，将查找路径上的每个节点都直接连接到根节点，从而减少后续查找操作的时间复杂度。
 * 按秩合并（Union by Rank）：在合并两个集合时，总是将较小的集合连接到较大的集合上，这样可以避免树过深，从而优化操作的时间复杂度。
 */
public class DisjointSetUnion {
    public static void main(String[] args) {
        DisjointSetUnion uf = new DisjointSetUnion(10); // 假设有10个元素
        uf.union(1, 2);
        uf.union(2, 3);
        uf.union(4, 5);
        uf.union(6, 7);
        uf.union(5, 6);
        uf.union(3, 7);

        System.out.println(uf.isConnected(1, 5)); // 输出：true
        System.out.println(uf.isConnected(1, 8)); // 输出：false
    }

    private int[] parent;
    private int[] rank;

    public DisjointSetUnion(int size) {
        parent = new int[size];
        rank = new int[size];
        for (int i = 0; i < size; i++) {
            parent[i] = i;
        }
    }

    public int getParent(int u){
        return parent[u];
    }

    // 查找操作，并压缩路径
    public int find(int u) {
        if (u == parent[u]) {
            return u;
        }
        return parent[u] = find(parent[u]);
    }

    public void union(int x, int y) {
        int rootx = find(x);
        int rooty = find(y);
        if (rootx == rooty) {
            return;
        }
        if (rank[rootx] > rank[rooty]) {
            parent[rooty] = rootx;
        } else if (rank[rootx] < rank[rooty]) {
            parent[rootx] = rooty;
        } else {
            parent[rootx] = rooty;
            rank[rooty]++;
        }
    }


    public boolean isConnected(int u, int v) {
        u = find(u);
        v = find(v);
        return u == v;
    }

}
