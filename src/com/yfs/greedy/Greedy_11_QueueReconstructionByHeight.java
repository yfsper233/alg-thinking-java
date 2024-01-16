package com.yfs.greedy;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * 假设有打乱顺序的一群人站成一个队列，数组 people 表示队列中一些人的属性（不一定按顺序）。
 * 每个 people[i] = [hi, ki] 表示第 i 个人的身高为 hi ，前面 正好 有 ki 个身高大于或等于 hi 的人。
 * <p>
 * 请你重新构造并返回输入数组 people 所表示的队列。返回的队列应该格式化为数组 queue ，
 * 其中 queue[j] = [hj, kj] 是队列中第 j 个人的属性（queue[0] 是排在队列前面的人）。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：people = [[7,0],[4,4],[7,1],[5,0],[6,1],[5,2]]
 * 输出：[[5,0],[7,0],[5,2],[6,1],[4,4],[7,1]]
 * 解释：
 * 编号为 0 的人身高为 5 ，没有身高更高或者相同的人排在他前面。
 * 编号为 1 的人身高为 7 ，没有身高更高或者相同的人排在他前面。
 * 编号为 2 的人身高为 5 ，有 2 个身高更高或者相同的人排在他前面，即编号为 0 和 1 的人。
 * 编号为 3 的人身高为 6 ，有 1 个身高更高或者相同的人排在他前面，即编号为 1 的人。
 * 编号为 4 的人身高为 4 ，有 4 个身高更高或者相同的人排在他前面，即编号为 0、1、2、3 的人。
 * 编号为 5 的人身高为 7 ，有 1 个身高更高或者相同的人排在他前面，即编号为 1 的人。
 * 因此 [[5,0],[7,0],[5,2],[6,1],[4,4],[7,1]] 是重新构造后的队列。
 * 示例 2：
 * <p>
 * 输入：people = [[6,0],[5,0],[4,0],[3,2],[2,2],[1,4]]
 * 输出：[[4,0],[5,0],[2,2],[3,2],[1,4],[6,0]]
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= people.length <= 2000
 * 0 <= hi <= 106
 * 0 <= ki < people.length
 * 题目数据确保队列可以被重建
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/queue-reconstruction-by-height
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Greedy_11_QueueReconstructionByHeight {
    public static void main(String[] args) {
        int[][] people = {{6,0},{5,0},{4,0},{3,2},{2,2},{1,4}};
//        int[][] res =  reconstruct(people);
        int[][] res2 =  reconstructII(people);

    }

    private static int[][] reconstructII(int[][] people) {
        Arrays.sort(people,((o1, o2) -> {
            if (o1[0] == o2[0]){
                return o1[1] - o2[1];
            }else {
                return o2[0] - o1[0];
            }
        }));
        LinkedList<int[]> res = new LinkedList<>();
        for (int[] person : people) {
            res.add(person[1], person);
        }

        return res.toArray(new int[people.length][people[0].length]);
    }







    /**
     * 根据结果的要求,前面 正好 有 ki 个身高大于或等于 hi 的人。先安排高个子位置,将身高按照降序排列,相同身高的人先安排ki小的人,将排序好的数组插入到新数组,ki即为其相对位置
     * @param people
     * @return
     */
    private static int[][] reconstruct(int[][] people) {
        int[][] res = new int[people.length][2];
        int nums = people.length;
        while (nums>0){
            int[] max = findMax(people);
            for (int i = res.length - 1; i > max[1]; i--) {
                res[i] = res[i-1];
            }
            res[max[1]] = max;
            nums--;
        }
        return res;
    }

    private static int[] findMax(int[][] people) {
        int[] tag = {Integer.MIN_VALUE,Integer.MIN_VALUE};
        int maxHeight = people[0][0];
        int maxCounts = people[0][1];
        int maxIndex = 0;
        for (int i = 0; i < people.length; i++) {
            if (people[i] == tag){
                continue;
            }
            if (people[i][0] > maxHeight){
                maxHeight=people[i][0];
                maxCounts = people[i][1];
                maxIndex = i;
            }else if (people[i][0] == maxHeight && people[i][1] > maxCounts){
                maxHeight=people[i][0];
                maxCounts = people[i][1];
                maxIndex = i;
            }
        }
        int[] person = people[maxIndex];
        people[maxIndex] = tag;
        return person;
    }
}
