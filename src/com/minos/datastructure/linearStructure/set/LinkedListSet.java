package com.minos.datastructure.linearStructure.set;

import com.minos.datastructure.linearStructure.linkedList.LinkedList;

/**
 * @Author: minos
 * @Date: 2020/10/26 18:40
 */
public class LinkedListSet<E> implements Set<E> {

    private LinkedList<E> list;

    public LinkedListSet() {
        list = new LinkedList<>();
    }

    @Override
    public void add(E e) {

        if (!list.contains(e)){
            list.addFirst(e);
        }
    }

    /**
     * 链表中忘记写根据元素查找删除了 - -
     * @param e
     */
    @Override
    public void remove(E e) {
    }

    @Override
    public boolean contains(E e) {
        return list.contains(e);
    }

    @Override
    public int getSize() {
        return list.getSize();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }
}
