package com.mask.leetcode.MinStack;

import java.util.Stack;

/**
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min 函数在该栈中，调用 min、push 及 pop 的时间复杂度都是 O(1)。
 * 官方题解
 * @author Mask
 */
public class MinStack {

	Stack<Integer> A, B;

	public MinStack() {
		A = new Stack<>();
		B = new Stack<>();
	}

	public void push(int x) {
		A.add(x);
		if (B.empty() || B.peek() >= x)
			B.add(x);
	}

	public void pop() {
		if (A.pop().equals(B.peek()))
			B.pop();
	}

	public int top() {
		return A.peek();
	}

	public int min() {
		return B.peek();
	}

	public static void main(String[] args) {
		MinStack minStack = new MinStack();

		minStack.push(-2);
		minStack.push(0);
		minStack.push(-3);
		System.out.println(minStack.min());   // --> 返回 -3.
		minStack.pop();
		System.out.println(minStack.top());      // --> 返回 0.
		System.out.println(minStack.min());   // --> 返回 -2.
	}
}
