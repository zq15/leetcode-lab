package com.zds.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class T56 {
    public static void main(String[] args) {
        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] merge = merge(intervals);
        System.out.println();
    }

    public static int[][] merge(int[][] intervals) {
        // 双指针判断
        if (intervals.length <= 1) return intervals;

        // 对开始元素排序
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        // 数组原地操作?
        List<int[]> list = new ArrayList<>();
        list.add(new int[]{intervals[0][0], intervals[0][1]});

        for (int i = 1; i < intervals.length; i++) {
            int[] current = intervals[i];
            // 取出数据结尾元素和后面一个元素对比
            int[] last = list.get(list.size() - 1);
            // 需要合并 后面一个元素在当前已合并的数组的元素末尾的区间内
            if (last[1] >= current[0]) {
                // 替代最后一个元素
                // 取最小开始和最大结束
                last[1] = Math.max(last[1], current[1]);
            } else {
                // 不需要合并就直接添加
                list.add(new int[]{current[0], current[1]});
            }
        }

        return list.stream()
                .map(i -> new int[]{i[0], i[1]})
                .toArray(int[][]::new);
    }
}
