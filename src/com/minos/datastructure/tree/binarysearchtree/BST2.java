package com.minos.datastructure.tree.binarysearchtree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 改进的代码简化的实现
 *
 * @Author: minos
 * @Date: 2020/10/21 21:20
 */
public class BST2<E extends Comparable<E>> {

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

    public BST2() {
        root = null;
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 向二分搜索树种中添加新元素
     *
     * @param e
     */
    public void add(E e) {
        root = add(root, e);
    }

    /**
     * 向以node为根的二分搜索树中插入元素e，递归算法
     *
     * @param node
     * @param e
     * @return 返回插入新节点后二分搜索树的根
     */
    private Node add(Node node, E e) {

        //插入动作，递归终止条件
        if (node == null) {
            size++;
            return new Node(e);
        }

        //如果待插入元素小于节点中的元素，直接向左孩子递归
        if (e.compareTo(node.e) < 0) {
            //如果当前节点的左孩子为null,生成新节点后直接返回，node.left = 新生成的节点
            node.left = add(node.left, e);

            //用else if 判断后相当于排除了第三种可能，既待插入元素值与当前节点值相等时什么也不做
        } else if (e.compareTo(node.e) > 0) {
            node.right = add(node.right, e);
        }

        return node;
    }

    /**
     * 看二分搜索树中是否包含某个元素e
     *
     * @param e
     * @return
     */
    public boolean contains(E e) {
        return contains(root, e);
    }

    /**
     * 二分搜索树中是否包含某个元素e，递归算法
     *
     * @param node
     * @param e
     * @return
     */
    private boolean contains(Node node, E e) {
        if (node == null) {
            return false;
        }

        if (e.compareTo(node.e) == 0) {
            return true;
        } else if (e.compareTo(node.e) < 0) {
            return contains(node.left, e);
        } else {
            return contains(node.right, e);
        }
    }

    /**
     * 二分搜索树的前序遍历
     */
    public void preOder() {
        preOder(root);
    }

    /**
     * 前序遍历以node为根的二分搜索树, 递归算法
     *
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

    /**
     * 二分搜索数树的非递归前序遍历
     */
    public void preOrderNR() {

        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            Node curr = stack.pop();
            System.out.println(curr.e);

            if (curr.right != null){
                stack.push(curr.right);
            }

             if (curr.left != null){
                stack.push(curr.left);
            }
        }
    }

    /**
     * 二分搜索树的中序遍历
     */
    public void inOder(){
        inOder(root);
    }

    /**
     * 中序遍历以node为根的二分搜索树, 递归算法
     * 中序遍历得到的结果就是二分搜索树排序后的结果
     * @param node
     */
    private void inOder(Node node) {

        if (node == null) {
            return;
        }

        inOder(node.left);
        System.out.println(node.e);
        inOder(node.right);
    }

    /**
     * 二分搜索树的后续遍历
     */
    public void postOder(){
        postOder(root);
    }

    /**
     * 后序遍历以node为根的二分搜索树, 递归算法
     * 后序遍历的应用 为二分搜索树释放内存
     * @param node
     */
    private void postOder(Node node){
        if (node == null){
            return;
        }

        postOder(node.left);
        postOder(node.right);
        System.out.println(node.e);
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        generateString(root, 0, res);
        return res.toString();
    }

    /**
     * 二分搜索树的层序遍历 (广度优先遍历)
     */
    public void levelOrder(){

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node curr = queue.remove();
            System.out.println(curr.e);

            if (curr.left != null){
                queue.add(curr.left);
            }
            if (curr.right != null) {
                queue.add(curr.right);
            }
        }
    }

    /**
     * 寻找二分搜索树的最小元素
     * @return
     */
    public E minimum(){
        if (size == 0){
            throw new IllegalArgumentException("BST is empty.");
        }

       return minimum(root).e;
    }

    /**
     * 返回以node为根的二分搜索树的最小值所在的节点
     * @param node
     * @return
     */
    private Node minimum(Node node){
        if (node.left == null) {
            return node;
        }
        return minimum(node.left);
    }

    /**
     * 寻找二分搜索树的最大元素
     * @return
     */
    public E maximum(){
        if (size == 0){
            throw new IllegalArgumentException("BST is empty.");
        }

        return maximum(root).e;
    }

    /**
     * 返回以node为根的二分搜索树的最大值所在的节点
     * @param node
     * @return
     */
    private Node maximum(Node node){
        if (node.right == null) {
            return node;
        }
        return maximum(node.right);
    }

    /**
     * 从二分搜索树中删除最小值所在的点，返回最小值
     * @return
     */
    public E removeMin(){
        //返回要当前树中的最小值
        E ret = minimum();
        //调用删除函数删除最小值所在的节点
        root =  removeMin(root);
        return ret;
    }

    /**
     * 删除以node为根的二分搜索树的最小节点
     * 返回删除节点后新的二分搜索树的根
     * @param node
     * @return
     */
    private Node removeMin(Node node){

        if (node.left == null) {
            Node rightNode = node.right;
            node.right = null;
            size--;
            return rightNode;
        }

        node.left =  removeMin(node.left);
        return node;
    }


    /**
     * 从二分搜索树中删除最小值所在的点，返回最大值
     * @return
     */
    public E removeMax(){
        E ret = maximum();
        root =  removeMin(root);
        return ret;
    }

    /**
     * 删除以node为根的二分搜索树的最小节点
     * 返回删除节点后新的二分搜索树的根
     * @param node
     * @return
     */
    private Node removeMax(Node node){

        if (node.right == null) {
            Node rightNode = node.left;
            node.left = null;
            size--;
            return rightNode;
        }

        node.right =  removeMax(node.right);
        return node;
    }

    /**
     * 从二分搜索树中删除元素为e的节点
     * @param e
     */
    public void remove(E e) {
        root = remove(root, e);
    }

    public Node remove(Node node, E e){
        if (node == null) {
            return null;
        }

        if (e.compareTo(node.e) < 0) {
            node.left = remove(node.left, e);
            return node;
        }else if ( e.compareTo(node.e) > 0) {
            node.right = remove(node.right, e);
            return node;
        }else { // e == node.e

            //待删除节点左子树为空
            if (node.left == null){
                Node rightNode = node.right;
                node.right = null;
                size--;
                return rightNode;
            }

            //待删除节点右子树为空
            if (node.right == null) {
                Node leftNode = node.left;
                node.left = null;
                size--;
                return leftNode;

            }

            //待删除节点左右子树均不为空的情况
            //找到比待删除节点大的最小节点，即待删除节点右子树的最小节点
            //用这个节点顶替待删除节点的位置
            Node successor = minimum(node.right);
            successor.right = removeMin(node.right);
            successor.left = node.left;

            node.left = node.right = null;
            return successor;
        }
    }


    /**
     * 生成以node为根节点，深度为depth的描述二叉树的字符串
     *
     * @param node
     * @param depth
     * @param res
     */
    private void generateString(Node node, int depth, StringBuilder res) {
        if (node == null) {
            res.append(generateDepthString(depth) + "null\n");
            return;
        }

        res.append(generateDepthString(depth) + node.e + "\n");
        generateString(node.left, depth + 1, res);
        generateString(node.right, depth + 1, res);
    }

    private String generateDepthString(int depth) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < depth; i++) {
            res.append("--");
        }
        return res.toString();
    }


}















