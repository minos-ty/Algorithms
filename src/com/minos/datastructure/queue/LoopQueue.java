package com.minos.datastructure.queue;

/**
 *
 * @Author: minos
 * @Date: 2020/10/17 10:33
 */
public class LoopQueue<E> implements Queue<E> {

    private E[] data;
    /**
     * front == tail 时表示队列为空
     * tail + 1 == front 队列满
     */
    private int front, tail;
    private int size;

    public LoopQueue(int capacity){
        //  capacity + 1 循环队列tail指向的位置不放元素
        data = (E[]) new Object[capacity + 1];
        front = 0;
        tail = 0;
        size = 0;
    }

    public LoopQueue(){
        this(10);
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return front == tail;
    }

    @Override
    public void enqueue(E e) {

        //  (tail + 1) % data.length == front 当条件为真时队列满
        if ((tail + 1) % data.length == front){
            resize(getCapacity() * 2);
        }

        data[tail] = e;
        // 元素入列以后tail+1，同样的要考虑到循环
        tail = (tail + 1) % data.length;
        size++;
    }

    private void resize(int newCapacity) {

        E[] newData = (E[])new Object[newCapacity + 1];
        for (int i = 0; i < size; i++){
            newData[i] = data[(i + front) % data.length];
        }
        data = newData;
        front = 0;
        tail = size;
    }

    @Override
    public E dequeue() {

        if (isEmpty()){
            throw new IllegalArgumentException("Cannot dequeue from an empty queue.");
        }
        E ret = data[front];
        data[front] = null;
        // front + 1即可实现元素出队列操作
        front = (front + 1) % data.length;
        size--;

        //缩容
        if (size == getCapacity() / 4 && getCapacity() / 2 != 0){
            resize(getCapacity() / 2);
        }
        return ret;
    }

    @Override
    public E getFront() {
        if (isEmpty()){
            throw new IllegalArgumentException("Queue is empty.");
        }
        return data[front];
    }

    public int getCapacity(){
        // 因为有意识的浪费了一个空间，所以实际容量需要-1
        return data.length - 1;
    }

    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        res.append(String.format("Queue: size = %d, capacity = %d\n", size, getCapacity()));
        res.append("front [");
        for (int i = front; i != tail; i = (i + 1) % data.length){
            res.append(data[i]);
            if ((i + 1) % data.length != tail){
                res.append(", ");
            }
        }
        res.append("] tail");
        return res.toString();
    }

    public static void main(String[] args) {
        LoopQueue<Integer> loopQueue = new LoopQueue<>();
        for (int i = 0; i < 10; i ++){
            loopQueue.enqueue(i);
        }
        System.out.println(loopQueue);

        loopQueue.dequeue();
        System.out.println(loopQueue);
    }
}















