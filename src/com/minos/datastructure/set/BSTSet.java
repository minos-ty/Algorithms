package com.minos.datastructure.set;

import com.minos.datastructure.binarySearchTree.BST2;

/**
 * 基于二分搜索树实现的集合
 * @Author: minos
 * @Date: 2020/10/26 18:06
 */
public class BSTSet<E extends Comparable<E>> implements Set<E>{

    /**
     * 二分搜索树的完整实现是BST2
     */
    private BST2<E> bst;

    public BSTSet() {
        bst = new BST2<>();
    }

    @Override
    public void add(E e) {

    }

    @Override
    public void remove(E e) {

    }

    @Override
    public boolean contains(E e) {
        return false;
    }

    @Override
    public int getSize() {
        return bst.getSize();
    }

    @Override
    public boolean isEmpty() {
        return bst.isEmpty();
    }
}