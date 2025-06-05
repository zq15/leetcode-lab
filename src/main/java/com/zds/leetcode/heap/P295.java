package com.zds.leetcode.heap;

import java.util.PriorityQueue;

public class P295 {
    /**
     * Your MedianFinder object will be instantiated and called as such:
     * MedianFinder obj = new MedianFinder();
     * obj.addNum(num);
     * double param_2 = obj.findMedian();
     */

    public static void main(String[] args) {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(1);    // arr = [1]
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(2);    // arr = [1, 2]
        System.out.println(medianFinder.findMedian());// 返回 1.5 ((1 + 2) / 2)
        medianFinder.addNum(3);    // arr[1, 2, 3]
        System.out.println(medianFinder.findMedian()); // return 2.0
        medianFinder.addNum(-4);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(-5);
        System.out.println(medianFinder.findMedian());
    }
}

class MedianFinder {
    // 用两个堆维护中位数，奇数时返回中间数，偶数时返回中间两个数的平均数
    private PriorityQueue<Integer> smallHeap = new PriorityQueue<>();
    private PriorityQueue<Integer> bigHeap = new PriorityQueue<>((a, b)->b - a);

    public MedianFinder() {

    }

    public void addNum(int num) {
        if (smallHeap.size() == bigHeap.size()){
            // 保证优先放到大堆，后面如果是单数就从大堆中取
            // 如果在大堆就直接放，不在就需要从小堆移走一个元素，再放小堆
            if (bigHeap.isEmpty()) {
                bigHeap.offer(num);
            } else if (num <= bigHeap.peek()){ // 这里的判断可以解决，因为大堆需要先被放入元素
                bigHeap.offer(num);
            } else {
                bigHeap.offer(smallHeap.poll());
                // 判断怎么操作

                bigHeap.offer(smallHeap.poll());
                smallHeap.offer(num);
            }
        } else {
            // 在小堆那边就直接放，否则从大堆中取一个元素补充到小堆，再放大堆
            if (smallHeap.isEmpty()) { //todo 考虑这里小堆为空，这时小堆无法 peek，需要额外判断
                if (num < bigHeap.peek()) {
                    smallHeap.offer(num);
                } else {
                    smallHeap.offer(bigHeap.poll());
                    bigHeap.offer(num);
                }
            } else if (num >= smallHeap.peek()) {
                smallHeap.offer(num);
            } else {
                smallHeap.offer(bigHeap.poll());
                bigHeap.offer(num);
            }

        }
    }

    public double findMedian() {
        if (smallHeap.size() == bigHeap.size()){
            return (smallHeap.peek() + bigHeap.peek()) / 2.0;
        } else {
            return bigHeap.peek();
        }
    }
}