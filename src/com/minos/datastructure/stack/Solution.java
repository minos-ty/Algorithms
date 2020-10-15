package com.minos.datastructure.stack;

import java.util.Stack;

/**
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']',
 * determine if the input string is valid.
 *
 * An input string is valid if:
 *      1. Open brackets must be closed by the same type of brackets.
 *      2. Open brackets must be closed in the correct order.
 *
 * @Author: minos
 * @Date: 2020/10/15 18:44
 */
import java.util.Stack;

public class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if (c == '(' || c =='{' || c == '['){
                stack.push(c);
            }else {
                if (stack.isEmpty()){
                    return false;
                }
                char topChar = stack.pop();
                if (c == ')' && topChar != '('){
                    return false;
                }
                if (c == '}' && topChar != '{'){
                    return false;
                }
                if (c == ']' && topChar != '['){
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
















