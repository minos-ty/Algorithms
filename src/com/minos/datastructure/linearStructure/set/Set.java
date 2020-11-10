package com.minos.datastructure.linearStructure.set;

/**
 * @Author: minos
 * @Date: 2020/10/26 18:04
 */
public interface Set<E> {
    void add(E e);
    void remove(E e);
    boolean contains(E e);
    int getSize();
    boolean isEmpty();
}
