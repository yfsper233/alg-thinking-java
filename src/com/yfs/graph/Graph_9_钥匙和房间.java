package com.yfs.graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * 841.钥匙和房间
 * <p>
 * 有 N 个房间，开始时你位于 0 号房间。每个房间有不同的号码：0，1，2，...，N-1，并且房间里可能有一些钥匙能使你进入下一个房间。
 * <p>
 * 在形式上，对于每个房间 i 都有一个钥匙列表 rooms[i]，
 * 每个钥匙 rooms[i][j] 由 [0,1，...，N-1] 中的一个整数表示，
 * 其中 N = rooms.length。 钥匙 rooms[i][j] = 1 可以打开编号为 1  的房间。
 * <p>
 * 最初，除 0 号房间外的其余所有房间都被锁住。
 * <p>
 * 你可以自由地在房间之间来回走动。
 * <p>
 * 如果能进入每个房间返回 true，否则返回 false。
 * <p>
 * 示例 1：
 * <p>
 * 输入: [[1],[2],[3],[]]
 * 输出: true
 * 解释: 我们从 0 号房间开始，拿到钥匙 1。 之后我们去 1 号房间，拿到钥匙 2。 然后我们去 2 号房间，拿到钥匙 3。
 * 最后我们去了 3 号房间。 由于我们能够进入每个房间，我们返回 true。
 * 示例 2：
 * <p>
 * 输入：[[1,3],[3,0,1],[2],[0]]
 * 输出：false
 * 解释：我们不能进入 2 号房间。
 * <p>
 * https://leetcode.cn/problems/keys-and-rooms/description/
 */
public class Graph_9_钥匙和房间 {
    public static void main(String[] args) {
        ArrayList<List<Integer>> lists = new ArrayList<>();
        ArrayList<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(3);
        ArrayList<Integer> list2 = new ArrayList<>();
        list2.add(3);
        list2.add(0);
        list2.add(1);
        ArrayList<Integer> list3 = new ArrayList<>();
        list3.add(2);
        ArrayList<Integer> list4 = new ArrayList<>();
        list4.add(0);
        lists.add(list1);
        lists.add(list2);
        lists.add(list3);
        lists.add(list4);
        int[][] rooms = lists.stream()
                .map(innerList -> innerList.stream().mapToInt(Integer::intValue).toArray())
                .toArray(int[][]::new);
        HashSet<Integer> set = new HashSet<>();
        boolean res = keysAndRooms(rooms, 0,set);
    }

    private static boolean keysAndRooms(int[][] rooms, int index, HashSet<Integer> set) {
        set.add(index);
        if (set.size() ==  rooms.length) {
            return true;
        }
         for (int j = 0; j < rooms[index].length; j++) {
                int next = rooms[index][j];
                if (next != -1 && !set.contains(next)) {
                    rooms[index][j] = -1;
                   boolean flag = keysAndRooms(rooms, next, set);
                   if (flag){
                       return true;
                   }

                }
         }

        return false;
    }
}
