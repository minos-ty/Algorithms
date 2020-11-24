package com.minos.datastructure.queue;

import java.util.Random;

/**
 * @Author: minos
 * @Date: 2020/10/15 20:21
 */
public class Main {

    /**
     * 测试使用运行optCount个enqueue和dequeue操作所需的时间，单位：秒
     *
     * @param q
     * @param optCount
     * @return
     */
    private static double testQueue(Queue<Integer> q, int optCount) {
        long startTime = System.nanoTime();

        Random random = new Random();
        for (int i = 0; i < optCount; i++) {
            q.enqueue(random.nextInt(Integer.MAX_VALUE));
        }
        for (int i = 0; i < optCount; i++) {
            q.dequeue();
        }

        long endTime = System.nanoTime();

        return (endTime - startTime) / 1000000000.0;
    }

    public static void main(String[] args) {

        int optCount = 10000;

        ArrayQueue<Integer> arrayQueue = new ArrayQueue<>();
        double time1 = testQueue(arrayQueue, optCount);
        System.out.println("ArrayQueue, time: " + time1 + "s");

        LoopQueue<Integer> loopQueue = new LoopQueue<>();
        double time2 = testQueue(loopQueue, optCount);
        System.out.println("LoopQueue, time: " + time2 + "s");

        LinkedListQueue<Integer> linkedListQueue = new LinkedListQueue<>();
        double time3 = testQueue(loopQueue, optCount);
        System.out.println("LoopQueue, time: " + time2 + "s");

    }
}
