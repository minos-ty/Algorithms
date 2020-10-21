package com.minos.datastructure.binarySearchTree;

/**
 * @Author: minos
 * @Date: 2020/10/20 22:02
 */
public class Main {
    public static void main(String[] args) {
        BST2<Integer> bst2 = new BST2<>();
        int[] nums = {1, 2, 3, 4, 5};
        for(int num : nums){
            bst2.add(num);
        }

        bst2.preOder();

    }
}
