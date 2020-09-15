package com.minos.datastructure.stack;

import com.minos.datastructure.array.Array;

/**
 * @Author: minos
 * @Date: 2020/9/15 21:06
 */
public class ArrayStack<E> implements Stack<E> {

    Array<E> array;

    public ArrayStack() {
        this.array = new Array<>();
    }

    public ArrayStack(int capacity) {
        this.array = new Array<>(capacity);
    }

    @Override
    public int getSize() {
        return array.getSize();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    @Override
    public void push(E e) {
        array.addLast(e);
    }

    @Override
    public E pop() {
        return array.removeLast();
    }

    @Override
    public E peak() {
        return array.getLast();
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("Stack: ");
        res.append("[");
        for (int i = 0; i < array.getSize(); i++) {
            res.append(array.get(i));
            if (i != array.getSize() - 1){
                res.append(",");
            }
        }
        res.append("] top" );
        return res.toString();
    }

    public int getCapacity(){
        return array.getCapacity();
    }
}
