package com.minos.datastructure.linearstructure.queue.importantQ;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author: minos
 * @Date: 2020/11/10 09:36
 */
public class UseQueueImplementsStack{

    private Queue<Integer> q;

    /** Initialize your data structure here. */
    public UseQueueImplementsStack() {
        q = new LinkedList<>();
    }

    public boolean isEmpty() {
        return q.isEmpty();
    }

    /**
     * 把入队端当做栈顶
     * @param x
     */
    public void push(int x) {
       q.add(x);
    }

    public int pop() {

        // 单独创建一个队列来存放从第一个队列中为了取到队尾元素而移出的元素
        Queue<Integer> q2 = new LinkedList<>();

        // 除了队尾元素，q中其余的元素放入q2
        while (q.size() > 1) {
            q2.add(q.remove());
        }

        // q中剩下的最后一个元素就是栈顶元素
        int ret = q.remove();

        // 此时 q2 是整个数据结构存储的所有其他数据，赋值给 q
        q = q2;

        //返回栈顶元素
        return ret;
    }

    /**
     *  top不删除元素，取出栈顶元素保存结构后再push回去
     * @return
     */
    public int top() {
        int ret = pop();
        push(ret);
        return ret;
    }

}














