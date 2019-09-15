package com.vi.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 将中缀表达式转成后缀表达式
 * @author vi
 *
 */
public class InfixToSuffixDemo {
	public static void main(String[] args) {
		String expression = "1+((2+3)*4)-5";
		//将表达式存储在List中
		List<String> target = changeToList(expression);
		System.out.println(target);
		//开始转换
		//s1运算符栈
		Stack<String> s1 = new Stack<String>();
		//s2 用list保存结果
		List<String> s2 = new ArrayList<String>();
		for(String item : target ) {
			//如果匹配到数字，存入s2
			if(item.matches("\\d+")) {
				s2.add(item);
			} else{
					//匹配是非数字，判断是否"(",左括号直接入栈
					if("(".equals(item)) {
						s1.push(item);
					} else if(")".equals(item)) {
							//是否是")",是的话，需要比较栈顶元素是否(， 不是就弹出栈顶，存入s2中，直到栈顶为"("，然后消掉左括号
							while(s1.size()>0 && !s1.peek().equals("(")) {
								s2.add(s1.pop());
							}
							s1.pop();
						} else {
							//比较运算符与栈顶元素的优先级,低于栈顶元素，将栈顶弹出加入list中,高于栈顶就压入栈
							while(s1.size()>0 && priority(item) >= priority(s1.peek())) {
								s2.add(s1.pop());
							} 
							s1.push(item);
						}
					}
				}
			//将s1栈中剩余的元素依次弹出，存到s2中
			while(s1.size() > 0)
				s2.add(s1.pop());
			//打印s2，得到的就是转后缀表达式的结果
			System.out.println(s2);
		}
	
	
	/**
	 * 将目标中缀表达式解析后，存储到list中
	 * @param expression
	 * @return
	 */
	public static List<String> changeToList(String expression) {
		List<String> result = new ArrayList<String>();
		for(int i = 0 ; i < expression.length() ;i++) {
			String cur = expression.charAt(i)+"";
			//判断获得的是否是数字
			if(cur.matches("\\d+")) {//如果是数字，还需要判断下一位是否为数字，是的话进行拼接之后再存储
				int j = i+1;
				//如果下标没有超过表达式长度，并且表达式中的是数字，则进行拼接
				while(j<expression.length() && (expression.charAt(j)+"").matches("\\d+")) {
					cur = cur + expression.charAt(j)+"";
					j++;
				}
				result.add(cur);
				i = j - 1;
			} else {
				//如果不是数字，直接存入list中
				result.add(cur);
			}
		}
		return result;
	}
	
	/**
	 * 返回目标字符串的优先级
	 * @param target
	 * @return
	 */
	public static int priority(String target) {
		if("+".equals(target) || "-".equals(target)) {
			return 1;
		}
		else if("*".equals(target) || "/".equals(target)) {
			return 2;
		} else {//如果是括号
			return 3;
		}
	}
}
