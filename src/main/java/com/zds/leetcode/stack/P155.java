package com.zds.leetcode.stack;

import java.util.Stack;

public class P155 {
    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin()); // -3
        minStack.pop(); // -3
        System.out.println(minStack.top()); // -2
        System.out.println(minStack.getMin()); // -2
    }
}

class MinStack {
    private Stack<Integer> stack = new Stack<>();
    private Stack<Integer> stack_copy = new Stack<>();
    private Integer min = Integer.MAX_VALUE; // push 和 pop 过程中记录最小值

    public MinStack() {

    }

    public void push(int val) {
        stack.push(val);
        if (val < min) min = val;
    }

    public void pop() {
        stack.pop();
        min = Integer.MAX_VALUE;
        // 处理最小值维护
        while (!stack.isEmpty()) {
            if (stack.peek() < min) {
                min = stack.peek();
            }
            stack_copy.push(stack.pop());
        }
        while (!stack_copy.isEmpty()){
            stack.push(stack_copy.pop());
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
