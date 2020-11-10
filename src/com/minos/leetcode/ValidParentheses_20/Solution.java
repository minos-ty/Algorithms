package com.minos.leetcode.ValidParentheses_20;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']',
 * determine if the input string is valid.
 *
 * An input string is valid if:
 *      1. Open brackets must be closed by the same type of brackets.
 *      2. Open brackets must be closed in the correct order.
 *
 *
 * 思路： { [ ( ) ] }  如此要匹配的话一定是这种结构的
 * 把左括号压栈，当遇到右括号时，拿出栈顶元素匹配。如果满足相同类型一左一右，则为真，其他情况为假
 * @Author: minos
 * @Date: 2020/10/15 18:44
 */
import java.util.Stack;

public class Solution {

    public boolean isValid(String s) {

        // Class ArrayDeque faster than Stack
        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            }else {
                if (stack.isEmpty()) {
                    return false;
                }
                char topChar = stack.poll();
                if (c == ')' && stack.pop() != '(') {
                    return false;
                }
                if (c == ']' && stack.pop() != '[') {
                    return false;
                }
                if (c == '}' && stack.pop() != '{') {
                    return false;
                }
            }
        }
        //只有栈中的所有元素都被弹出结果才可能正确
        return stack.isEmpty();
    }
}
















