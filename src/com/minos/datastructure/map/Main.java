package com.minos.datastructure.map;

import java.util.ArrayList;

/**
 * 比较两个不同实现的map
 *
 * @Author: minos
 * @Date: 2020/10/26 19:56
 */
public class Main {

    private static double testMap(Map<String, Integer> map, String fileName) {

        long startTime = System.nanoTime();

        // 词频统计
        ArrayList<String> words = new ArrayList<>();
        if (FileOperation.readFile(fileName, words)) {
            System.out.println("Total words: " + words.size());

            for (String word : words) {
                if (map.contains(word)) {
                    map.set(word, map.get(word) + 1);
                } else {
                    map.add(word, 1);
                }
            }
            System.out.println("Total different words: " + map.getSize());
            System.out.println("Frequency of PRIDE: " + map.get("pride"));
            System.out.println("Frequency of PREJUDICE" + map.get("prejudice"));
        }

        long endTime = System.nanoTime();

        return (endTime - startTime) / 1000000000.0;
    }

    public static void main(String[] args) {
        String fileName = "src/com/minos/datastructure/set/files/pride-and-prejudice.txt";

        BSTMap<String, Integer> bstMap = new BSTMap<>();
        double timeOne = testMap(bstMap, fileName);
        System.out.println("BSTMap: " + timeOne + "s");
        System.out.println();

        LinkedListMap<String, Integer> linkedListMap = new LinkedListMap<>();
        double timeTwo = testMap(linkedListMap, fileName);
        System.out.println("LinkedListMap: " + timeTwo + "s");

    }
}
