package com.minos.datastructure.array;

/**
 * 数组的优点:快速查询
 * 数组最好应用于"索引有语义"的情况
 * @author minos
 */
public class Main {

   public static void main(String[] args) {

       Array<Integer> arr = new Array();
       for (int i = 0; i < 10; i++){
           arr.addLast(i);
       }
       System.out.println(arr);

       arr.add(1,100);
       System.out.println(arr);

       arr.addFirst(-1);
       System.out.println(arr);

       arr.remove(2);
       System.out.println(arr);

       arr.removeElement(4);
       System.out.println(arr);







       /*

        原生数组
        int[] arr = new int[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }

        int[] scores = new int[]{100, 99, 66};
        for (int i = 0; i <scores.length; i++){
            System.out.println(scores[i]);
        }

        for (int score: scores){
            System.out.println(score);
        }

        */
    }
}
