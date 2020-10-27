package com.minos.leetcode.UniqueMorseCodeWords_804;

import java.util.TreeSet;

/**
 *
 * International Morse Code defines a standard encoding where each letter
 * is mapped to a series of dots and dashes, as follows:
 * "a" maps to ".-", "b" maps to "-...", "c" maps to "-.-.", and so on.
 *
 * For convenience, the full table for the 26 letters of the English alphabet
 * is given below:
 *
 *      [".-","-...","-.-.","-..",".","..-.","--.","....","..",".---",
 *      "-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-",
 *      "...-",".--","-..-","-.--","--.."]
 *
 * Now, given a list of words, each word can be written as a concatenation
 * of the Morse code of each letter. For example, "cab" can be written as
 * "-.-..--...", (which is the concatenation "-.-." + ".-" + "-...").
 * We'll call such a concatenation, the transformation of a word.
 *
 * Return the number of different transformations among all words we have.
 *
 * Example:
 *      Input: words = ["gin", "zen", "gig", "msg"]
 * Output: 2
 * Explanation:
 *      The transformation of each word is:
 *              "gin" -> "--...-."
 *              "zen" -> "--...-."
 *              "gig" -> "--...--."
 *              "msg" -> "--...--."
 *
 * There are 2 different transformations, "--...-." and "--...--.".
 * Note:
 *
 * The length of words will be at most 100.
 * Each words[i] will have length in range [1, 12].
 * words[i] will only consist of lowercase letters.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/unique-morse-code-words。
 *
 * @Author: minos
 * @Date: 2020/10/27 16:53
 */

import java.util.TreeSet;
public class Solution {
    public static int uniqueMorseRepresentations(String[] words) {

        TreeSet<String> treeSet = new TreeSet<>();

        String[] morse = {".-","-...","-.-.","-..",".","..-.","--.","....","..",
                             ".---","-.-",".-..","--","-.","---",".--.","--.-",
                             ".-.","...", "-","..-","...-",".--","-..-","-.--","--.."};
        String myMorse = "";
        for (int i = 0; i < words.length; i++) {
            char[] chars = words[i].toCharArray();
            // ascII a = 97
            for (int j = 0; j < chars.length; j++) {
                //这里直接减去a就行了啊 ！！！！
                //这里字符串的拼接是在栈中进行的，并不好。涉及到字符串的拼接操作最好使用StringBuilder
                //StringBuilder效率高一点，但StringBuilder只适用与单线程，它并不是线程安全的
                //StringBuffer是线程安全的，但效率稍低，因为要花时间去检查控制线程安全的问题
                myMorse += morse[chars[j] - 'a'];
            }
            treeSet.add(myMorse);
            myMorse = "";

        }

        return treeSet.size();
    }

    public static void main(String[] args) {
       String[] a =  {"gin", "zen", "gig", "msg"};
        int i = uniqueMorseRepresentations(a);
        System.out.println(i);
    }
}
