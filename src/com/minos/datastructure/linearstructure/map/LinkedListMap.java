package com.minos.datastructure.linearstructure.map;

/**
 * @Author: minos
 * @Date: 2020/10/26 20:00
 */
public class LinkedListMap<K, V> implements Map<K, V>{

    private class Node{
        public K key;
        public V value;
        public Node next;

        public Node(K key, V value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

        public Node(K key) {
            this(key, null, null);
        }

        public Node() {
            this(null, null, null);
        }

        @Override
        public String toString(){
            return key.toString() + " : " +value.toString();
        }

    }

    private Node dummyHead;
    private int size;

    public LinkedListMap() {
        dummyHead = new Node();
        size = 0;
    }

    /**
     * 找key值所在的节点
     * @param key
     * @return
     */
    private Node getNode(K key){
        Node curr = dummyHead.next;
        while (curr != null) {
            if (curr.key.equals(key)) {
                return curr;
            }

            curr = curr.next;
        }
        return null;
    }

    @Override
    public void add(K key, V value) {

        Node node = getNode(key);
        if (node == null) {
            dummyHead.next = new Node(key, value, dummyHead.next);
            size++;
        }else {
            //如果用户传入key已经存在，那么更新key对应的value
            node.value = value;
        }

    }

    @Override
    public V remove(K key) {

        Node prev = dummyHead;
        while (prev.next != null) {
            if (prev.next.key.equals(key)) {
                break;
            }
            prev = prev.next;
        }

        if (prev.next != null) {
            Node delNode = prev.next;
            //delNode.next --> prev.next.next
            prev.next = delNode.next;
            delNode.next = null;
            size--;
            return delNode.value;
        }

        return null;
    }

    @Override
    public boolean contains(K key) {
        return getNode(key) != null;
    }

    @Override
    public V get(K key) {

        Node node = getNode(key);
        return node == null ? null : node.value;
    }

    @Override
    public void set(K key, V newValue) {

        Node node = getNode(key);
        if (node == null) {
            throw new IllegalArgumentException(key + "doesn't exist ! ");
        }
        node.value = newValue;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }
}
