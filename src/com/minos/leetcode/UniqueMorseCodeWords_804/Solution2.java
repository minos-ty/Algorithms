package com.minos.leetcode.UniqueMorseCodeWords_804;

import javax.swing.*;
import java.util.TreeSet;

/**
 * 优雅一点实现
 * 和第一个方法比较，这个方法的时间和空间的开销上都要优于第一个方法
 * @Author: minos
 * @Date: 2020/10/27 19:28
 */
public class Solution2 {

    public static int uniqueMorseRepresentations(String[] words) {
        String[] morse = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....",
                "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.",
                "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};
        TreeSet<String> set = new TreeSet<>();

        for (String word : words) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < word.length(); i ++) {
                sb.append(morse[word.charAt(i) - 'a']);
            }
            set.add(sb.toString());
        }

        return set.size();

    }

}
