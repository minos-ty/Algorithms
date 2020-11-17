package com.minos.datastructure.linearstructure.map;

/**
 * @Author: minos
 * @Date: 2020/10/26 19:56
 */
public interface Map<K, V> {
    void add(K key, V value);
    V remove(K key);
    boolean contains(K key);
    V get(K key);
    void set(K key, V newValue);
    int getSize();
    boolean isEmpty();
}
