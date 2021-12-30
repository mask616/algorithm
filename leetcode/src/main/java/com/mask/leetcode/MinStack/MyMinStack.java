package com.mask.leetcode.MinStack;

import java.util.Stack;

public class MyMinStack {

	Stack<Integer> stack1, stack2;

	/**
	 * initialize your data structure here.
	 */
	public MyMinStack() {
		stack1 = new Stack<>();
		stack2 = new Stack<>();
	}

	public void push(int x) {
		stack1.push(x);
		if (stack2.isEmpty() || stack2.peek() >= x) stack2.push(x);
	}

	public void pop() {
		if (stack1.pop().equals(stack2.peek()))
			stack2.pop();
	}

	public int top() {
		return stack1.peek();
	}

	public int min() {
		return stack2.peek();
	}

	public static void main(String[] args) {
		MyMinStack minStack = new MyMinStack();

		minStack.push(-2);
		minStack.push(0);
		minStack.push(-3);
		System.out.println(minStack.min());   // --> 返回 -3.
		minStack.pop();
		System.out.println(minStack.top());      // --> 返回 0.
		System.out.println(minStack.min());   // --> 返回 -2.
	}
}
