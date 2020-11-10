package com.minos.datastructure.linearStructure.linkedList;

/**
 * @Author: minos
 * @Date: 2020/10/17 13:38
 */
public class LinkedList<E> {

    private class Node {
        public E e;
        public Node next;

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        public Node(E e) {
            this(e, null);
        }

        public Node() {
            this(null, null);
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }

    private Node dummyHead;
    private int size;

    public LinkedList() {
        // 存在一个虚拟头结点，链表的size不计算该节点
        dummyHead = new Node(null, null);
        size = 0;
    }

    /**
     * 获取链表中的元素个数
     *
     * @return
     */
    public int getSize() {
        return size;
    }

    /**
     * 返回链表是否为空
     *
     * @return
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 在链表index(0-based)位置添加新元素
     * 该方法在链表实际使用中并不常用，因为基本涉及使用链表的时候便不会使用索引
     * 仅做练习用
     *
     * @param index
     */
    public void add(int index, E e) {

        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed.Illegal index.");
        }

        Node prev = dummyHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }

        //Node node = new Node(e);
        //node.next = prev.next;
        //prev.next = node;
        prev.next = new Node(e, prev.next);
        size++;

    }

    /**
     * 在链表头添加新元素
     */
    public void addFirst(E e) {
        //Node node = new Node(e);
        //node.next = head;
        //head = node;

        //上面三行代码的优雅写法
        //head = new Node(e, head);

        add(0, e);
    }

    /**
     * 在链表末尾添加新元素e
     *
     * @param e
     */
    public void addLast(E e) {
        add(size, e);
    }

    /**
     * 获得链表中第index位置元素，不常用，练习用
     *
     * @param index
     * @return
     */
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Get failed. Illegal index.");
        }

        Node curNode = dummyHead.next;
        for (int i = 0; i < index; i++) {
            curNode = curNode.next;
        }
        return curNode.e;
    }

    /**
     * 获得链表头结点元素
     *
     * @return
     */
    public E getFirst() {
        return get(0);
    }

    /**
     * 获得列表尾结点元素
     *
     * @return
     */
    public E getLast() {
        return get(size - 1);
    }

    /**
     * 修改链表中index位置结点的元素，链表中不常用，练习用
     *
     * @param index
     * @param e
     */
    public void set(int index, E e) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Set failed.Illegal index.");
        }

        Node curNode = dummyHead.next;
        for (int i = 0; i < index; i++) {
            curNode = curNode.next;
        }

        curNode.e = e;
    }

    /**
     * 查找链表中是否存在元素e
     *
     * @param e
     * @return
     */
    public boolean contains(E e) {
        Node curNode = dummyHead.next;
        while (curNode != null) {
            if (curNode.e.equals(e)) {
                return true;
            }
            curNode = curNode.next;
        }
        return false;
    }

    /**
     * 从链表中删除index位置的结点
     * @param index index从0开始
     * @return
     */
    public E remove(int index){

        if (index < 0 || index >= size){
            throw new IllegalArgumentException("Remove failed. Illegal index.");
        }

        Node prev = dummyHead;
        for (int i = 0; i < index; i++){
            prev = prev.next;
        }
        Node retNode = prev.next;
        prev.next = retNode.next;
        retNode.next = null;
        size--;
        return retNode.e;
    }

    /**
     * 删除头结点
     * @return
     */
    public E removeFirst(){
        return remove(0);
    }

    /**
     * 删除尾结点
     * @return
     */
    public E removeLast(){
        return remove(size - 1);
    }

    @Override
    public String toString() {

        StringBuilder res = new StringBuilder();

        Node curNode = dummyHead.next;
        while (curNode != null) {
            res.append(curNode + "->");
            curNode = curNode.next;
        }

        // 上面代码的另一种写法
        /*for (Node curNode = dummyHead.next; curNode != null; curNode = curNode.next){
            res.append(curNode + "->");
        }*/

        res.append("Null");
        return res.toString();
    }

}















