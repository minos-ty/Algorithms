package com.minos.datastructure.heap.maxheap;

import java.util.Random;

/**
 * @Author: minos
 * @Date: 2020/10/27 22:27
 */
public class Main {

    private static double testHeap(Integer[] testData, boolean isHeapify) {

        long startTime = System.nanoTime();

        MaxHeap<Integer> maxHeap;
        if (isHeapify) {
            maxHeap = new MaxHeap<>(testData);
        }else {
            maxHeap = new MaxHeap<>();
            for (Integer num : testData) {
                maxHeap.add(num);
            }
        }

        // 每次取出根节点的值存入数组，相当与给随机数从大到小排序了
        int[] arr = new int[testData.length];
        for (int i = 0; i < testData.length; i++) {
            arr[i] = maxHeap.extractMax();
        }

        // 验证数组中的数是否是从大到小排序的
        for (int i = 1; i < testData.length; i++) {
            if (arr[i-1] < arr[i]) {
                throw new IllegalArgumentException("Error");
            }
        }

        // 没有抛出异常测试成功
        System.out.println("Test MaxHeap completed.");
        long endTime = System.nanoTime();

        return (endTime - startTime) / 1000000000.0;
    }

    public static void main(String[] args) {

        int n = 1000000;
        Random random = new Random();
        Integer[] testData = new Integer[n];
        for (int i = 0; i < n; i++) {
            testData[i] =random.nextInt(Integer.MAX_VALUE);
        }

        double timeOne = testHeap(testData, false);
        System.out.println("Without heapyfy: " + timeOne + "s");
        System.out.println();

        double timeTwo = testHeap(testData, true);
        System.out.println("With heapyfy: " + timeTwo + "s");

    }
}
