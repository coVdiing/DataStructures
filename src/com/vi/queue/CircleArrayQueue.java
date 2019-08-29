package com.vi.queue;

import java.util.Scanner;

public class CircleArrayQueue {

	public static void main(String[] args) {
		// 测试队列
		CircleArrayQueue queue = new CircleArrayQueue(4);
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

	// 队列容量
	private int maxSize;
	// 队列头指针,指向第一个元素，初始化为0
	private int front;
	// 队列尾指针,约定在队列中空出一个位置，让尾指针指向最后一个元素的后一位，初始化为0
	private int rear;
	// 封装一个数组
	int[] arr;

	public CircleArrayQueue(int maxSize) {
		this.maxSize = maxSize;
		arr = new int[maxSize];
	}

	// 判断队列是否为空
	public boolean isEmpty() {
		return front == rear;
	}

	// 判断队列是否已满
	public boolean isFull() {
		return (rear + 1) % maxSize == front;
	}

	// 添加数据到队列中
	public void add(int data) {
		// 队列是否已满
		if (isFull()) {
			throw new RuntimeException("队列已满");
		}
		arr[rear] = data;
		// 环形队列，取模防止下标越界
		rear = (rear + 1) % maxSize;
	}

	// 取出队列中的数据
	public int get() {
		// 队列是否为空
		if (isEmpty()) {
			throw new RuntimeException("队列为空");
		}
		int result = arr[front];
		front = (front + 1) % maxSize;
		return result;
	}

	// 遍历队列
	public void showQueue() {
		if (isEmpty()) {
			throw new RuntimeException("队列为空");
		}
		for (int i = front; i < front + size(); i++) {
			System.out.printf("arr[%d]=%d\t",i%maxSize, arr[i%maxSize]);
			System.out.println();
		}
		
	}

	// 获得有效元素数量
	public int size() {
		return (rear + maxSize - front) % maxSize;
	}

	// 获得队列头
	public int getHead() {
		if (isEmpty()) {
			throw new RuntimeException("队列为空");
		}
		return arr[front];
	}
}
