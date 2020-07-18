package com.linearsearch;

public class LinearSearchDemo {
    public static void main(String[] args) {
        int[] dataInt = {24, 18, 12, 9, 16, 100, 21, 1};
        Character[] dataChar = {'a', 'b', 'd', 'e', 'c', 'f'};
        String[] dataString = {"tangyang", "minos", "汤洋"};

        System.out.println(LinearSearch.search(dataInt, 21));
        System.out.println(LinearSearch.search(dataChar, 'c'));
        System.out.println(LinearSearch.search(dataString,"汤洋"));
    }
}
