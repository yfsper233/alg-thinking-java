package com.yfs.backtracking;

import com.sun.org.apache.regexp.internal.RE;

import java.util.*;

/**
 * 题号:[332]
 * <p>
 * 给定一个机票的字符串二维数组 [from, to]，子数组中的两个成员分别表示飞机出发和降落的机场地点，对该行程进行重新规划排序。所有这些机票都属于一个从 JFK（肯尼迪国际机场）出发的先生，所以该行程必须从 JFK 开始。
 * <p>
 * 提示：
 * <p>
 * 如果存在多种有效的行程，请你按字符自然排序返回最小的行程组合。例如，行程 ["JFK", "LGA"] 与 ["JFK", "LGB"] 相比就更小，排序更靠前
 * 所有的机场都用三个大写字母表示（机场代码）。
 * 假定所有机票至少存在一种合理的行程。
 * 所有的机票必须都用一次 且 只能用一次。
 * 示例 1：
 * <p>
 * 输入：[["MUC", "LHR"], ["JFK", "MUC"], ["SFO", "SJC"], ["LHR", "SFO"]]
 * 输出：["JFK", "MUC", "LHR", "SFO", "SJC"]
 * 示例 2：
 * <p>
 * 输入：[["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
 * 输出：["JFK","ATL","JFK","SFO","ATL","SFO"]
 * 解释：另一种有效的行程是 ["JFK","SFO","ATL","JFK","ATL","SFO"]。但是它自然排序更大更靠后。
 */
public class ReconstructItinerary {
    public static void main(String[] args) {
        List<List<String>> candidates = new ArrayList<>();
//        candidates.add(Arrays.asList("MUC", "LHR"));
//        candidates.add(Arrays.asList("JFK", "MUC"));
//        candidates.add(Arrays.asList("SFO", "SJC"));
//        candidates.add(Arrays.asList("LHR", "SFO"));

        candidates.add(Arrays.asList("JFK", "SFO"));
        candidates.add(Arrays.asList("JFK", "ATL"));
        candidates.add(Arrays.asList("SFO", "ATL"));
        candidates.add(Arrays.asList("ATL", "JFK"));
        candidates.add(Arrays.asList("ATL", "SFO"));

//        candidates.add(Arrays.asList("JFK","SFO"));
//        candidates.add(Arrays.asList("SFO","JFK"));
//        candidates.add(Arrays.asList("JFK","ABC"));


        // 核心映射关系:出发机场->到达机场的集合
//        List<String> res = getReconstructItinerary(candidates);
//        System.out.println(res);
        // 核心映射关系:<出发机场,<到达机场,机票张数>>
        List<String> res = getReconstructItineraryII(candidates);
        System.out.println(res);
    }

    private static List<String> getReconstructItineraryII(List<List<String>> list) {
        List<String> res = new ArrayList<>();
        Map<String, Map<String, Integer>> tickets = new HashMap<>();
        for (List<String> t : list) {
            Map<String, Integer> tmp;
            if (tickets.containsKey(t.get(0))) {
                tmp=tickets.get(t.get(0));
                tmp.put(t.get(1), tmp.getOrDefault(t.get(1), 0) + 1);
            } else {
                tmp=new TreeMap<>();
                tmp.put(t.get(1), 1);
            }
            tickets.put(t.get(0), tmp);
        }
        res.add("JFK");
        backTrackingII(res, tickets, list.size());
        return res;
    }

    private static boolean backTrackingII(List<String> res, Map<String, Map<String, Integer>> tickets, int size) {
        if (res.size() == size + 1) {
            return true;
        }
        String last = res.get(res.size() - 1);
        if (tickets.containsKey(last)) {
            for (Map.Entry<String, Integer> entry : tickets.get(last).entrySet()) {
                Integer count = entry.getValue();
                if(count>0){
                    res.add(entry.getKey());
                    entry.setValue(count-1);
                   if(backTrackingII(res,tickets,size)){
                       return true;
                   }
                    res.remove(res.size()-1);
                    entry.setValue(count);
                }
            }
        }
       return false;
    }

    private static List<String> getReconstructItinerary(List<List<String>> list) {
        List<String> res = new ArrayList<>();
        String start = "JFK";
        List<String> candidate = getCandidates(list, start);
        res.add(start);
        backTracking(res, candidate, list, start, list.size());
        return res;
    }

    /**
     * @param res       结果集合
     * @param candidate 当前出发点的目的地集合
     * @param source    当前剩余机票的集合
     * @param start     当前遍历轮次的出发点
     * @param size      机票张数
     */
    private static boolean backTracking(List<String> res, List<String> candidate, List<List<String>> source, String start, int size) {

        // n 张机票，途径n+1次站点（站点可重复），即可用完所有机票
        if (res.size() == size + 1) {
            return true;
        }
        //
        for (int i = 0; i < candidate.size(); i++) {

            res.add(candidate.get(i));
            source.remove(Arrays.asList(start, candidate.get(i)));
            if (backTracking(res, getCandidates(source, candidate.get(i)), source, candidate.get(i), size)) {
                return true;
            }
            source.add(Arrays.asList(start, candidate.get(i)));
            res.remove(res.size() - 1);
        }

        return false;
    }

    /**
     * 根据当前出发点和剩余机票的数量,获取目的地的集合(要求自然升序,这样找到的第一条路径就是所求)
     *
     * @param candidates
     * @param start
     * @return
     */
    private static List<String> getCandidates(List<List<String>> candidates, String start) {
        ArrayList<String> strings = new ArrayList<>();
        for (List<String> candidate : candidates) {
            if (start.equals(candidate.get(0))) {
                strings.add(candidate.get(1));
            }
        }
        strings.sort(Comparator.naturalOrder());
        return strings;
    }
}
