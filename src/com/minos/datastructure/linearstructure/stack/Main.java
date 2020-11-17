package com.minos.datastructure.linearstructure.stack;

import java.util.Random;

/**
 * @Author: minos
 * @Date: 2020/9/15 21:22
 */
public class Main {

    /**
     *  测试stack运行opCount个push和pop操作所用的时间，单位：秒
     * @param stack
     * @param opCount
     * @return
     */
    private static double testStack(Stack<Integer> stack, int opCount) {

        long startTime = System.nanoTime();

        Random random = new Random();
        for (int i = 0; i < opCount; i++) {
            stack.push(random.nextInt(Integer.MAX_VALUE));
        }
        for (int i = 0; i < opCount; i++) {
            stack.pop();
        }

        long endTime = System.nanoTime();

        return (endTime - startTime) / 1000000000.0;
    }


    public static void main(String[] args) {

        // 当面对巨大的数据量的时候， 使用链表实现的的容器效率更低， 因为其要不断的new新节点
        int opCount = 1000000;

        ArrayStack<Integer> arrayStack = new ArrayStack<>();
        double time1 = testStack(arrayStack, opCount);
        System.out.println("ArrayStack, time: " + time1 + "s");


        LinkedListStack<Integer> listStack = new LinkedListStack<>();
        double time2 = testStack(listStack, opCount);
        System.out.println("LinkedListStack, time: " + time2 + "s");
    }
}
