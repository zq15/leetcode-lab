package com.zds.leetcode.heap;

import java.util.PriorityQueue;

public class P215 {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        // 构造最小堆
        for (int i = 0; i < nums.length; i++) {
            minHeap.offer(nums[i]);
        }
        // 找出第k大的元素
        // -> 删除最小的 num.length - k 个元素
        for (int i = 0; i < nums.length - k; i++) {
            minHeap.poll();
        }
        return minHeap.poll();
    }

    public static void main(String[] args) {
        int[] nums = {3,2,1,5,6,4};
        int k = 2;
        System.out.println(new P215().findKthLargest(nums, k));
    }
}
