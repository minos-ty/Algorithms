package com.minos.datastructure.binarySearchTree;

/**
 * @Author: minos
 * @Date: 2020/10/20 22:02
 */
public class Main {
    public static void main(String[] args) {
        BST2<Integer> bst2 = new BST2<>();
        int[] nums = {5, 3, 6, 8, 4, 2};
        for(int num : nums){
            bst2.add(num);
        }

//        bst2.preOder();
//        System.out.println();
//        //bst2.inOder();
//        bst2.preOrderNR();

        bst2.levelOrder();

    }
}
