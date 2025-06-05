package com.zds.leetcode.heap;

import java.util.*;

public class P347 {
    public int[] topKFrequent(int[] nums, int k) {
        // 1.使用 map 统计数组中每个元素的个数 元素 -> 次数
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        List<Map.Entry<Integer, Integer>> countMap = new ArrayList<>(map.entrySet());
        // 2.把map 的value（出现次数），创建最大堆
        PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<>((a, b) -> {
            return b.getValue() - a.getValue(); // 降序排列，形成最大堆
        });
        for (Map.Entry<Integer, Integer> key : countMap) {
            minHeap.offer(key);
        }
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = minHeap.poll().getKey();
        }
        return res;
    }

    public static void main(String[] args) {
//        int[] nums = {-1, -1};
        int[] nums = {1,1,1,2,2,4};
        int k = 3;
        for (int i : new P347().topKFrequent(nums, k)) {
            System.out.println(i);
        }
    }
}
