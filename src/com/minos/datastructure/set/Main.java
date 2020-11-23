package com.minos.datastructure.set;

import java.util.ArrayList;

/**
 * Set的两种不同实现效率的比较
 *
 * @Author: minos
 * @Date: 2020/11/23 19:46
 */
public class Main {

    private static double testSet(Set<String> set, String fileName) {
        long startTime = System.nanoTime();

        ArrayList<String> words = new ArrayList<>();
        if (FileOperation.readFile(fileName, words)) {
            System.out.println("Total words: " + words.size());
            for (String word : words) {
                set.add(word);
            }
            System.out.println("Total different words: " + set.getSize());
        }

        long endTime = System.nanoTime();
        //单位 s
        return (endTime - startTime) / 1000000000.0;
    }

    public static void main(String[] args) {

        String filename = "src/com/minos/datastructure/set/files/pride-and-prejudice.txt";

        BSTSet<String> bstSet = new BSTSet<>();
        double timeOne = testSet(bstSet, filename);
        System.out.println("BSTset: "+ timeOne + "s");
        System.out.println();

        LinkedListSet<String> linkedListSet = new LinkedListSet<>();
        double timeTwo = testSet(linkedListSet, filename);
        System.out.println("LinkedListSet: "+ timeTwo + "s");
    }


}
