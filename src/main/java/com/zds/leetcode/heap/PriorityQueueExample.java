package com.zds.leetcode.heap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class PriorityQueueExample {
    public static void main(String[] args) {
        // 默认最小堆，优先级搞的元素（最小值）先出队
        PriorityQueue<Integer> minHeap = new PriorityQueue<>((a, b) -> {
            return b - a; // 降序排列，形成最大堆
        });
        minHeap.offer(5);
        minHeap.offer(3);
        minHeap.offer(7);

        while (!minHeap.isEmpty()){
            System.out.println(minHeap.poll());
        }
    }
}
