package com.yfs.dynamicprogramming;


/**
 * 多重背包 在01背包基础上 每件物品的数量大于等于1
 * <p>
 * 有N种物品和一个容量为V 的背包。
 * 第i种物品最多有Mi件可用，每件耗费的空间是Ci ，价值是Wi 。
 * 求解将哪些物品装入背包可使这些物品的耗费的空间 总和不超过背包容量，且价值总和最大。
 */
public class DP_19_Multiple_Package {
    public static void main(String[] args) {
        int capacity = 10;
        int[] weight = {1, 3, 4};
        int[] value = {15, 20, 30};
        int[] count = {2, 3, 2};

        int res = multiplePackage(capacity, weight, value, count);
    }

    private static int multiplePackage(int capacity, int[] weight, int[] value, int[] count) {
        int[] dp = new int[capacity + 1];
        dp[0] = 0;
        for (int i = 0; i < weight.length; i++) {
            for (int j = capacity; j >= weight[i]; j--) {
                for (int k = 1; k <= count[i] && j - k * weight[i] >= 0; k++) {
                    dp[j] = Math.max(dp[j], dp[j - k * weight[i]] + k * value[i]);
                }
            }
        }
        return dp[capacity];
    }

}
