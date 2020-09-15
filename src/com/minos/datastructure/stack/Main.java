package com.minos.datastructure.stack;

/**
 * @Author: minos
 * @Date: 2020/9/15 21:22
 */
public class Main {
    public static void main(String[] args) {

        ArrayStack<Integer> stack = new ArrayStack<>();

        for (int i = 0; i < 5; i++) {
            stack.push(i);
            System.out.println(stack);
        }
        stack.pop();
        System.out.println(stack);
    }
}
