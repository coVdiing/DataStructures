package com.vi.linkedlist;

import java.util.Stack;

//栈的使用示例
public class TestStack {
	public static void main(String[] args) {
		Stack<String> stack = new Stack<>();
		stack.push("jack");
		stack.push("rose");
		stack.push("Tatanic");
		stack.push("eason");
		while(stack.size() > 0) {
			System.out.println(stack.pop());
		}
	}
}
