package com.yfs.graph;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 127. 单词接龙
 * 字典 wordList 中从单词 beginWord 和 endWord 的 转换序列 是一个按下述规格形成的序列：
 * <p>
 * 序列中第一个单词是 beginWord 。
 * 序列中最后一个单词是 endWord 。
 * 每次转换只能改变一个字母。
 * 转换过程中的中间单词必须是字典 wordList 中的单词。
 * 给你两个单词 beginWord 和 endWord 和一个字典 wordList ，
 * 找到从 beginWord 到 endWord 的 最短转换序列 中的 单词数目 。
 * 如果不存在这样的转换序列，返回 0。
 * 示例 1：
 * <p>
 * 输入：beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log","cog"]
 * 输出：5
 * 解释：一个最短转换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog", 返回它的长度 5。
 * 示例 2：
 * <p>
 * 输入：beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log"]
 * 输出：0
 * 解释：endWord "cog" 不在字典中，所以无法进行转换。
 * <p>
 * https://leetcode.cn/problems/word-ladder/description/
 */
public class Graph_8_单词接龙 {
    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";
        String[] wordArr = {"hot","dot","dog","lot","log","cog"};
        List<String> wordList = Stream.of(wordArr).collect(Collectors.toList());
        int res = wordLadder(beginWord, endWord, wordList);
    }

    private static int wordLadder(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) {
            return 0;
        }
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);

        HashMap<String, Integer> visitedMap = new HashMap<>();
        visitedMap.put(beginWord, 1);
        return bfs(wordList, endWord, queue, visitedMap);
    }

    private static int bfs(List<String> wordList, String endWord, Queue<String> queue, HashMap<String, Integer> visitedMap) {
        while (!queue.isEmpty()) {
            String cur = queue.poll();
            Integer length = visitedMap.get(cur);
            for (int i = 0; i < wordList.size(); i++) {
                String next = wordList.get(i);
                if (like(cur, next) && !visitedMap.containsKey(next)) {
                    if (Objects.equals(next, endWord)) {
                        return length + 1;
                    }
                    visitedMap.put(next, length + 1);
                    queue.offer(next);
                }
            }
        }
        return 0;
    }

    private static boolean like(String s1, String s2) {
        char[] chars1 = s1.toCharArray();
        char[] chars2 = s2.toCharArray();
        if (chars1.length != chars2.length) {
            return false;
        }
        int count = 0;
        for (int i = 0; i < chars1.length; i++) {
            if (chars1[i] != chars2[i]) {
                count++;
            }
        }
        return count == 1;
    }
}
