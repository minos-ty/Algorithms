package com.minos.datastructure.set;

import java.util.ArrayList;

/**
 * @Author: minos
 * @Date: 2020/11/23 19:46
 */
public class Main {

    public static void main(String[] args) {

        System.out.println("Pride and Prejudice");
        ArrayList<String> wordsOne = new ArrayList<>();
        FileOperation.readFile("src/com/minos/datastructure/set/files/pride-and-prejudice.txt", wordsOne);
        // 使用ArrayList来统计单词数是包含重复单词的
        System.out.println("Total words: " + wordsOne.size());

        BSTSet<String> setOne = new BSTSet<>();
        for (String word: wordsOne) {
            setOne.add(word);
        }
        System.out.println("Total different words:" + setOne.getSize());
        System.out.println();

        System.out.println("A tale of two cities");
        ArrayList<String> woedsTwo = new ArrayList<>();
        FileOperation.readFile("src/com/minos/datastructure/set/files/a-tale-of-two-cities.txt", woedsTwo);
        // 使用ArrayList来统计单词数是包含重复单词的
        System.out.println("Total words: " + woedsTwo.size());

        BSTSet<String> setTwo = new BSTSet<>();
        for (String word: woedsTwo) {
            setTwo.add(word);
        }
        System.out.println("Total different words:" + setTwo.getSize());

    }
}
