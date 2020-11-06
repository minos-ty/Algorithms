package com.minos.algorithm.myDemo.sorting;

/**
 * @Author: minos
 * @Date: 2020/11/6 19:47
 */
public class SelectedSort {

    private SelectedSort() {}

    public static int[] selectSort(int[] elements) {

        int minNum = elements[0];
        int minIndex = 0;

        for (int i = 0; i < elements.length; i++) {
            for (int j = i + 1; j < elements.length; j ++) {
                if (elements[i] > elements[j]) {
                    minIndex = j;
                    minNum = elements[j];
                }
            }
            elements[minIndex] = elements[i];
            elements[i] = minNum;
        }

        return elements;
    }

    public static void main(String[] args) {
        int[] numbers = {8, 6, 7, 3, 9, 10};
        int[] sortedNumbers = SelectedSort.selectSort(numbers);

        for (int number : sortedNumbers) {
            System.out.print( " " + number);
        }
    }
}










