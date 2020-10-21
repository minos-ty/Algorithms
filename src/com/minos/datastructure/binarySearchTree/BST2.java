package com.minos.datastructure.binarySearchTree;

/**
 * 改进的代码简化的实现
 * @Author: minos
 * @Date: 2020/10/21 21:20
 */
public class BST2<E extends Comparable<E> > {

    private class Node{
        public E e;
        public Node left, right;

        public Node(E e){
            this.e = e;
            left = null;
            right = null;
        }
    }

    private Node root;
    private int size;

    public BST2(){
        root = null;
        size = 0;
    }

    public int getSize(){
        return size;
    }

    public boolean isEmpty(){
        return size==0;
    }

    /**
     * 向二分搜索树种中添加新元素
     * @param e
     */
    public void add(E e){
        root = add(root, e);
    }

    /**
     * 向以node为根的二分搜索树中插入元素e，递归算法
     * @param node
     * @param e
     * @return 返回插入新节点后二分搜索树的根
     */
    private Node add(Node node, E e){

        //插入动作，递归终止条件
        if(node == null){
            size++;
            return new Node(e);
        }

        //如果待插入元素小于节点中的元素，直接向左孩子递归
        if (e.compareTo(node.e) < 0){
            //如果当前节点的左孩子为null,生成新节点后直接返回，node.left = 新生成的节点
            node.left = add(node.left, e);

        //用else if 判断后相当于排除了第三种可能，既待插入元素值与当前节点值相等时什么也不做
        } else if (e.compareTo(node.e) > 0){
            node.right = add(node.right, e);
        }

        return node;
    }

    /**
     * 看二分搜索树中是否包含某个元素e
     * @param e
     * @return
     */
    public boolean contains(E e){
        return contains(root, e);
    }

    /**
     * 二分搜索树中是否包含某个元素e，递归算法
     * @param node
     * @param e
     * @return
     */
    private boolean contains(Node node, E e){
        if (node == null){
            return false;
        }

        if (e.compareTo(node.e) == 0){
            return true;
        }else if (e.compareTo(node.e) < 0){
            return contains(node.left, e);
        }else {
            return contains(node.right, e);
        }
    }

    /**
     * 二分搜索树的前序遍历
     */
    public void preOder(){
        preOder(root);
    }

    /**
     * 前序遍历以node为根的二分搜索树, 递归算法
     * @param node
     */
    private void preOder(Node node) {
        if (node == null) {
            return;
        }
        System.out.println(node.e);

        //进行两次递归调用，左子树和右子树都考虑到
        preOder(node.left);
        preOder(node.right);
    }

}















