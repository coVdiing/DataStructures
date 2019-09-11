package com.vi.stack;

/**
 * 用栈实现自定义计算器
 * 
 * @author vi
 *
 */
public class Caculator {
	public static void main(String[] args) {
		// 需要计算的表达式
		String expression = "1+2*3+4/2+11+22";
		// 扫描表达式的索引
		int index = 0;
		int num1 = 0;
		int num2 = 0;
		// 数栈
		ArrayStackForMath numStack = new ArrayStackForMath();
		// 符号栈
		ArrayStackForMath operStack = new ArrayStackForMath();
		// 用于拼接需要计算的数字
		String num = "";
		while (true) {
			// 开始解析表达式
			if (index == expression.length()) {
				//解析完成，退出循环
				break;
			}
			// 当前扫描到的字符
			char ch = expression.substring(index, index + 1).charAt(0);
			if (ArrayStackForMath.isOper(ch)) {
				// 如果当前字符是运算符
				if (operStack.isEmpty()) {
					// 符号栈为空，直接入栈
					operStack.push(ch);
				} else {
					// 如果不为空，和栈顶比较优先级大小，优先级高于栈顶直接入栈，优先级低于栈顶,
					// 先取出栈顶的符号来计算数栈，再将数栈的结果和新运算符分别入栈
					if (ArrayStackForMath.priority(ch) <= ArrayStackForMath.priority(operStack.peek())) {
						num1 = numStack.pop();
						num2 = numStack.pop();
						numStack.calculate(num1, num2, operStack.pop());
					}
					operStack.push(ch);
				}
			} else {
				// 如果当前字符是数字,需要看当前位置的下一位是否为数字，是的话就拼接在一起，然后入栈，否则直接入栈
				//这里需要考虑index是否越界
				num += ch;
				if(index != expression.length()-1) {
					ch = expression.substring(index+1,index+2).charAt(0);
					if(!ArrayStackForMath.isOper(ch)) {
						num += ch;	
						index++;
					}
				}
				numStack.push(Integer.parseInt(num));
				//清空num，为下次循环做准备
				num = "";
			}
			index++;
		}
		
		System.out.println("表达式解析完成!");
		
		//扫描完成,对栈中数据进行计算
		while(true) {
			if(operStack.isEmpty())
				break;
			num1 = numStack.pop();
			num2 = numStack.pop();
			numStack.calculate(num1, num2, operStack.pop());
		}
		
		System.out.println(expression+"="+numStack.pop());
	}
}

class ArrayStackForMath {
	// 栈的最大容量
	private int maxSize = 10;
	// 栈顶,栈空时为-1
	private int top;
	// 数栈
	private int[] stack;

	// 初始化栈
	public ArrayStackForMath() {
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
		if (isEmpty()) {
			System.out.println("栈还是空的奥~");
			return;
		}
		for (int i = top; i > -1; i--) {
			System.out.println("stack[" + i + "] = " + stack[i] + "");
		}
	}

	// 查看栈顶方法
	public int peek() {
		return stack[top];
	}

	// 判断输入是否是运算符
	public static boolean isOper(int oper) {
		return oper == '+' || oper == '-' || oper == '*' || oper == '/';
	}

	// 定义运算符之间的优先级
	public static int priority(int oper) {
		if (oper == '*' || oper == '/')
			return 1;
		else if (oper == '+' || oper == '-')
			return 0;
		else
			return -1;
	}

	// 定义计算方法
	public void calculate(int num1, int num2, int oper) {
		int result;
		switch (oper) {
		case '+':
			result = num1 + num2;
			push(result);
			break;
		case '-':
			result = num2 - num1;
			push(result);
			break;
		case '*':
			result = num1 * num2;
			push(result);
			break;
		case '/':
			result = num2 / num1;
			push(result);
			break;
		default:
			break;
		}
	}
}
