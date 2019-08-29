package com.vi.queue;

import java.util.Scanner;

/**
 * 用数组实现队列
 * 这个队列并非环形，只能使用一次
 * @author vi
 *
 */
public class ArrayQueue {

	public static void main(String[] args) {
		// 测试队列
		Queue queue = new Queue(3);
		// 用key接收从键盘输入的关键字
		char key = ' ';
		Scanner sc = new Scanner(System.in);
		boolean loop = true;
		while (loop) {
			System.out.println("s(show) 展示队列");
			System.out.println("e(exit) 退出程序");
			System.out.println("a(add) 添加元素");
			System.out.println("g(get) 从队列取出数据");
			System.out.println("h(head) 查看队列头的数据");
			key = sc.next().charAt(0);
			try {
				switch (key) {
					case 's':
						queue.showQueue();
						break;
					case 'e':
						loop = false;
						break;
					case 'a':
						System.out.println("输入要添加的元素");
						int data = sc.nextInt();
						queue.add(data);
						break;
					case 'g':
						int get = queue.get();
						System.out.println(get);
						break;
					case 'h':
						int head = queue.getHead();
						System.out.println(head);
					default:
						break;
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}

		}
		System.out.println("程序结束!");

	}

}

class Queue {
	// 队列容量
	private int maxSize;
	// 队列头指针
	private int front;
	// 队列尾指针
	private int rear;
	// 封装一个数组
	int[] arr;

	public Queue(int maxSize) {
		this.maxSize = maxSize;
		arr = new int[maxSize];
		// 头和尾指针初始化时都指向-1
		front = -1;
		rear = -1;
	}

	// 判断队列是否为空
	public boolean isEmpty() {
		return front == rear;
	}

	// 判断队列是否已满
	public boolean isFull() {
		return rear == maxSize - 1;
	}

	// 添加数据到队列中
	public void add(int data) {
		// 队列是否已满
		if (isFull()) {
			throw new RuntimeException("队列已满");
		}
		rear++;
		arr[rear] = data;
	}

	// 取出队列中的数据
	public int get() {
		// 队列是否为空
		if (isEmpty()) {
			throw new RuntimeException("队列为空");
		}
		front++;
		return arr[front];
	}

	// 遍历队列
	public void showQueue() {
		if (isEmpty()) {
			throw new RuntimeException("队列为空");
		}
		for (int data : arr)
			System.out.printf("%d\t", data);
		System.out.println();
	}

	// 获得队列头
	public int getHead() {
		if (isEmpty()) {
			throw new RuntimeException("队列为空");
		}
		return arr[front + 1];
	}
}