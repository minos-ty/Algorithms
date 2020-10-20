package com.minos.datastructure.queue;

/**
 * @Author: minos
 * @Date: 2020/10/15 20:21
 */
public class Main {
    public static void main(String[] args) {
        //ArrayQueue<Integer> arrayQueue = new ArrayQueue<>();
        LinkedListQueue<Integer> queue = new LinkedListQueue<>();
        for (int i = 0; i < 10; i++){
            queue.enqueue(i);
            System.out.println(queue);
            if (i % 3 == 2){
                queue.dequeue();
                    System.out.println(queue);
            }
        }
    }
}
