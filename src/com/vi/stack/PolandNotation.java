package com.vi.stack;

import java.util.Stack;

/**
 * 简易计算器，对逆波兰表达式(后缀表达式)进行计算
 *  计算机对后缀表达式计算的过程:
 * 	从左至右扫描表达式，如果遇到数，将数存入栈中，如果遇到符号，将栈顶的两个元素弹出，进行运算，
 *  如果是除法或者减法，用后弹出的数做被除数或被减数
 * @author vi
 *
 */
public class PolandNotation {
	public static void main(String[] args) {
		//待计算的目标表达式，做一个约定，数与数、运算符之间用空格隔开，简化过程
		//3*5+4-8/2 ->  3 5 * 4 + 8 2 / -
//		String targetExp = "3 5 * 4 + 8 2 / -";
		String targetExp = "4 5 * 8 - 60 + 8 2 / +";
		System.out.println(new PolandNotation().caculate(targetExp));
	}
	
	//后缀表达式计算方法
	public int caculate(String expression) {
		//将目标表达式切割成数与运算符的数组
		String[] target = expression.split(" ");
		//用栈对目标表达式进行计算
		int result = 0;
		int num1;
		int num2;
		Stack<String> stack = new Stack<String>();
		for(String ele : target) {
			if(ele.matches("\\d+")) {
				//如果元素是一位或者多位的数字，压入栈中
				stack.push(ele);
			} else if("+".equals(ele)) {
				num1 = Integer.parseInt(stack.pop());
				num2 = Integer.parseInt(stack.pop());
				result = num1 + num2;
				stack.push(""+result);
			} else if("-".equals(ele)) {
				num1 = Integer.parseInt(stack.pop());
				num2 = Integer.parseInt(stack.pop());
				result = num2 - num1;
				stack.push(""+result);
			} else if("*".equals(ele)) {
				num1 = Integer.parseInt(stack.pop());
				num2 = Integer.parseInt(stack.pop());
				result = num2 * num1;
				stack.push(""+result);
			} else if("/".equals(ele)) {
				num1 = Integer.parseInt(stack.pop());
				num2 = Integer.parseInt(stack.pop());
				result = num2 / num1;
				stack.push(""+result);
			} else {
				throw new RuntimeException("您这表达式里头有问题!");
			}
		}
		return result;
	}
}
