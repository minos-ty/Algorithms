package com.minos.datastructure.tree.binarysearchtree;

/**
 * 逻辑清晰版本
 * @Author: minos
 * @Date: 2020/10/20 22:02
 */
public class BST1<E extends Comparable<E>> {

    private class Node {
        public E e;
        public Node left, right;

        public Node(E e) {
            this.e = e;
            left = null;
            right = null;
        }
    }

    private Node root;
    private int size;

    public BST1() {
        root = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }


    /**
     * 调用提供的递归增加元素e
     * @param e
     */
    public void add(E e) {
        //如果没有根节点，创建根节点
        if (root == null) {
            root = new Node(e);
            size++;
        } else {
            //如果存在根节点，调用递归算法添加元素
            add(root, e);
        }
    }

    /**
     * 向以node为根的二分搜索树中插入元素e,递归算法
     *
     * @param node
     * @param e
     */
    private void add(Node node, E e) {

        //递归终止条件
        if (e.equals(node.e)) {
            return;
        } else if (e.compareTo(node.e) < 0 && node.left == null) {
            node.left = new Node(e);
            size++;
            return;
        } else if (e.compareTo(node.e) > 0 && node.right == null) {
            node.right = new Node(e);
            size++;
            return;
        }

        //递归调用
        if (e.compareTo(node.e) < 0) {
            add(node.left, e);
        } else {  // e.compareTo(node.e) > 0
            add(node.right, e);
        }
    }
}











