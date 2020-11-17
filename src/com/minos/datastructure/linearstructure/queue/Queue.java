package com.minos.datastructure.linearstructure.queue;

/**
 * @Author: minos
 * @Date: 2020/10/15 20:22
 */
public interface Queue<E> {
    /**
     * 获得queue大小
     * @return
     */
    int getSize();

    /**
     * 判断queue是否为空
     * @return
     */
    boolean isEmpty();

    /**
     * 入列
     * @param e
     */
    void enqueue(E e);

    /**
     * 出列
     * @return
     */
    E dequeue();

    /**
     * 获取队列头元素
     * @return
     */
    E getFront();
}
