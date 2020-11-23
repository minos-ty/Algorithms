package com.minos.datastructure.set;

import com.minos.datastructure.linearstructure.linkedlist.LinkedList;

import java.util.ArrayList;

/**
 * 基于链表实现的集合
 *
 * @Author: minos
 * @Date: 2020/11/23 20:06
 */
public class LinkedListSet<E> implements Set<E> {

    private LinkedList<E> list;

    public LinkedListSet() {
        list = new LinkedList<>();
    }

    @Override
    public void add(E e) {

        if (!list.contains(e)) {
            list.addFirst(e);
        }
    }

    @Override
    public void remove(E e) {
        list.removeElement(e);
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

    public static void main(String[] args) {

        System.out.println("Pride and Prejudice");
        ArrayList<String> wordsOne = new ArrayList<>();
        FileOperation.readFile("src/com/minos/datastructure/set/files/pride-and-prejudice.txt", wordsOne);
        // 使用ArrayList来统计单词数是包含重复单词的
        System.out.println("Total words: " + wordsOne.size());

        LinkedListSet<String> setOne = new LinkedListSet<>();
        for (String word : wordsOne) {
            setOne.add(word);
        }
        System.out.println("Total different words:" + setOne.getSize());
        System.out.println();

        System.out.println("A tale of two cities");
        ArrayList<String> woedsTwo = new ArrayList<>();
        FileOperation.readFile("src/com/minos/datastructure/set/files/a-tale-of-two-cities.txt", woedsTwo);
        // 使用ArrayList来统计单词数是包含重复单词的
        System.out.println("Total words: " + woedsTwo.size());

        LinkedListSet<String> setTwo = new LinkedListSet<>();
        for (String word : woedsTwo) {
            setTwo.add(word);
        }
        System.out.println("Total different words:" + setTwo.getSize());

    }
}
