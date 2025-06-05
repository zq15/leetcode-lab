package com.zds.leetcode.stack;

import java.util.Stack;

public class P20 {
    public boolean isValid(String s) {
        if (s.length() % 2 != 0) {
            return false;
        }
        int n = s.length();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < n; i++){
            if (s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{'){
                stack.push(s.charAt(i));
            } else {
                if (stack.isEmpty()){
                    return false;
                } else {
                    char c = stack.pop();
                    if (s.charAt(i) == ')' && c != '('){
                        return false;
                    }
                    if (s.charAt(i) == ']' && c != '['){
                        return false;
                    }
                    if (s.charAt(i) == '}' && c != '{'){
                        return false;
                    }
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(new P20().isValid("()"));
        System.out.println(new P20().isValid("(]"));
        System.out.println(new P20().isValid("([)]"));
    }

}
