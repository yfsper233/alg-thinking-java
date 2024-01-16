package com.yfs.greedy;

/**
 *
 * 135. 分发糖果
 * n 个孩子站成一排。给你一个整数数组 ratings 表示每个孩子的评分。
 *
 * 你需要按照以下要求，给这些孩子分发糖果：
 *
 * 每个孩子至少分配到 1 个糖果。
 * 相邻两个孩子评分更高的孩子会获得更多的糖果。
 * 请你给每个孩子分发糖果，计算并返回需要准备的 最少糖果数目 。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：ratings = [1,0,2]
 * 输出：5
 * 解释：你可以分别给第一个、第二个、第三个孩子分发 2、1、2 颗糖果。
 * 示例 2：
 *
 * 输入：ratings = [1,2,2]
 * 输出：4
 * 解释：你可以分别给第一个、第二个、第三个孩子分发 1、2、1 颗糖果。
 *      第三个孩子只得到 1 颗糖果，这满足题面中的两个条件。
 *  
 *
 * 提示：
 *
 * n == ratings.length
 * 1 <= n <= 2 * 104
 * 0 <= ratings[i] <= 2 * 104
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/candy
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Greedy_9_Candy {
    public static void main(String[] args) {
        int[] rating = {1,3,4,5,2};
        int candies = distributeCandy(rating);
        int candies2 = distributeCandyII(rating);
        System.out.println(candies);
    }

    private static int distributeCandyII(int[] rating) {
        int count = rating.length;
        int[] candies = new int[rating.length];
        for (int i = 0; i < rating.length; i++) {
            candies[i] = 1;
        }
        for (int i = 1; i < rating.length; i++) {
            if (rating[i] > rating[i-1] && candies[i] <= candies[i-1]){
                int sub = (candies[i - 1] - candies[i]) + 1;
                candies[i] = candies[i] + sub;
                count += sub;
            }
        }
        for (int i = rating.length - 1 ; i > 0  ; i--) {
            if (rating[i] < rating[i-1] && candies[i] >= candies[i-1]){
                int sub = (candies[i] - candies[i-1]) + 1;
                candies[i-1]+=sub;
                count+=sub;
            }
        }
        return count;
    }










    private static int distributeCandy(int[] rating) {
        if (rating == null || rating.length == 0){
            return  0 ;
        }
        int[] candies = new int[rating.length];
        for (int i = 0; i < rating.length - 1; i++) {
            if (rating[i+1] - rating[i]>0){
                candies[i+1] = candies[i] + 1;
            }
        }

        for (int i = rating.length - 1; i > 0; i--) {
            if (rating[i-1] - rating[i]>0 && candies[i-1] -candies[i] <= 0){
                candies[i-1] = candies[i] + 1;
            }
        }
        int sum = candies.length;
        for (int candy : candies) {
            sum += candy;
        }
        return sum;
    }
}
