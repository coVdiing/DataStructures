package com.vi.stack;

import java.util.Scanner;

/**
 * 用数组模拟栈
 * 
 * @author vi
 *
 */
public class ArrayStackDemo {
	public static void main(String[] args) {
		// 测试栈的功能
		boolean flag = true;
		Scanner sc = new Scanner(System.in);
		ArrayStack as = new ArrayStack(5);
		while (true) {
			System.out.println("添加数据进栈:a");
			System.out.println("删除栈中数据:d");
			System.out.println("遍历栈:l");
			System.out.println("退出程序:exit");
			System.out.println("输入:");
			String input = sc.next();
			switch (input) {
			case "a":
				System.out.println("请输入要添加的数:");
				try {
					int value = sc.nextInt();
					as.push(value);
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;
			case "d":
				as.pop();
				break;
			case "l":
				as.listStack();
				break;
			case "exit":
				System.out.println("程序结束!");
				flag = false;
				break;
			default:
				System.out.println("输入的指令有误!");
				break;
			}
		}
	}
}

class ArrayStack {
	// 栈的最大容量
	private int maxSize;
	// 栈顶,栈空时为-1
	private int top;
	// 数组模拟栈
	private int[] stack;

	// 初始化栈
	public ArrayStack(int maxSize) {
		this.maxSize = maxSize;
		stack = new int[maxSize];
		top = -1;
	}

	// 判断栈是否为空
	public boolean isEmpty() {
		return top == -1;
	}

	// 判断栈是否满
	public boolean isFull() {
		return top == maxSize - 1;
	}

	// 入栈
	public void push(int value) {
		if (!isFull()) {
			stack[++top] = value;
		} else {
			System.out.println("客官不可以，满了~");
		}
	}

	// 出栈
	public int pop() {
		if (!isEmpty()) {
			return stack[top--];
		} else {
			throw new RuntimeException("可惜，还是空的~");
		}
	}

	// 遍历栈
	public void listStack() {
		if(isEmpty()) {
			System.out.println("栈还是空的奥~");
			return;
		}
		for(int i = top ; i > -1 ; i--) {
			System.out.println("stack[" + i + "] = " + stack[i] + "");
		}
	}
}