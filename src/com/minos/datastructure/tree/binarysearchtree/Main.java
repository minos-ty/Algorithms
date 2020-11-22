package com.minos.datastructure.tree.binarysearchtree;

import java.util.ArrayList;
import java.util.Random;

/**
 * @Author: minos
 * @Date: 2020/10/20 22:02
 */
public class Main {

    public static void main(String[] args) {

        BST<Integer> bst = new BST<>();
        Random random = new Random();

        int n = 1000;

        for (int i = 0; i < n; i++) {
            bst.add(random.nextInt(10000));
        }

        ArrayList<Integer> nums = new ArrayList<>();
        while (!bst.isEmpty()) {
            nums.add(bst.removeMin());
        }

        System.out.println(nums);

    }
}
