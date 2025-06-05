package com.zds.leetcode.heap;

import org.junit.jupiter.api.Test;

public class HeapSort {

    public static void main(String[] args) {
        int[] arr = {12, 11, 13, 5, 6, 7};
        heapSort(arr);
        System.out.println("排序后的数组：");
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    /**
     * 堆排序主方法（最大堆实现）
     *
     * @param arr 待排序数组
     */
    private static void heapSort(int[] arr) {
        int n = arr.length;

        // 1. 构建最大堆（从最后一个非叶子节点开始）
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }

        // 2. 排序过程：每次将当前最大值放到数组末尾
        for (int i = n - 1; i >= 0; i--) {
            // 将当前堆顶（最大值）与当前最后一个元素交换
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // 重新构建堆（缩小堆的大小）
            heapify(arr, i, 0);
        }
    }

    /**
     * 堆化函数：维持最大堆性质
     *
     * @param arr       数组
     * @param heapSize  当前堆的有效大小
     * @param rootIndex 当前根节点索引
     */
    private static void heapify(int[] arr, int heapSize, int rootIndex) {
        int largest = rootIndex;
        int leftChild = 2 * rootIndex + 1;
        int rightChild = 2 * rootIndex + 2;

        // 如果左子节点大于当前最大值
        if (leftChild < heapSize && arr[leftChild] > arr[largest]) {
            largest = leftChild;
        }

        // 如果右子节点大于当前最大值
        if (rightChild < heapSize && arr[rightChild] > arr[largest]) {
            largest = rightChild;
        }

        // 如果最大值不是当前根节点，则进行交换并继续堆化
        if (largest != rootIndex) {
            int swap = arr[rootIndex];
            arr[rootIndex] = arr[largest];
            arr[largest] = swap;

            // 递归调整受影响的子树
            heapify(arr, heapSize, largest);
        }
    }
}
