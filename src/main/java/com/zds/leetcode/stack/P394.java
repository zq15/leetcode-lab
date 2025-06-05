package com.zds.leetcode.stack;

import java.util.Stack;

public class P394 {
    public static void main(String[] args) {
//        System.out.println(decodeString("3[a]2[bc]"));
//
//        System.out.println(decodeString("3[a2[c]]"));

        System.out.println(decodeString("2[2[y]]]"));
    }

    private static Stack<String> strStack = new Stack<>();
    private static Stack<Integer> numStack = new Stack<>();
    private static int braketCount = 0;

    public static String decodeString(String s) {
        StringBuilder res =  new StringBuilder();
        // 一个数字栈，一个字符栈
        for (int i = 0; i < s.length(); i++) {
            // 判断 c 是否是数字
            if (Character.isDigit(s.charAt(i))) {
                StringBuilder sb = new StringBuilder();
                sb.append(s.charAt(i));
                while (i+1<s.length() && Character.isDigit(s.charAt(i + 1))){
                    sb.append(s.charAt(i + 1));
                    i++;
                }
                numStack.push(Integer.valueOf(sb.toString()));
            } else if (s.charAt(i) == '[') {
                braketCount++;
            } else if (Character.isLetter(s.charAt(i))) {
                StringBuilder sb = new StringBuilder();
                sb.append(s.charAt(i));
                while (i+1<s.length() && Character.isLetter(s.charAt(i + 1))){
                    sb.append(s.charAt(i + 1));
                    i++;
                }
                if (braketCount > 0) {
                    strStack.push(sb.toString());
                } else {
                    res.append(sb);
                }
            } else if (s.charAt(i) == ']') {
                braketCount--;
                String str = null;
                if (!strStack.isEmpty()){
                    str = strStack.pop();
                } else {
                    str = "";
                }
                int num = numStack.pop();
                // 判断 packet  的嵌套数
                if (braketCount == 0) { // 不需要嵌套
                    for (int j = 0; j < num; j++) {
                        res.append(str);
                    }
                } else {
                    StringBuilder tmp = new StringBuilder();
                    // 需要带上原始字符串嵌套
                    // 重写下层嵌套的字符串
                    for (int j = 0; j < num; j++) {
                        tmp.append(str);
                    }
                    if (strStack.isEmpty()){

                    } else {
                        String pop = strStack.pop();
                        pop  = pop + tmp;
                        strStack.push(pop);
                    }

                }

            }
        }
        return res.toString();
    }

}
