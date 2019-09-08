package com.vi.linkedlist;

/**
 * 约瑟夫环问题
 * 
 * @author vi
 *
 */
public class JoesphuProblem {
	public static void main(String[] args) {
		JoesphuList jl = new JoesphuList();
		jl.addNode(25);
		jl.showList();
	}
}

/**
 * 单向环形链表
 * 
 * @author vi
 *
 */
class JoesphuList {
	private BoyNode first = null;

	/**
	 * 添加节点
	 * 
	 * @param num
	 *            添加节点的数量
	 */
	public void addNode(int num) {
		// 辅助节点用于遍历
		BoyNode cur = null;
		if (num < 1) {
			return;
		}

		for (int i = 1; i <= num; i++) {
			if (i == 1) {
				first = new BoyNode(1);
				cur = first;
			} else {
				BoyNode newBoy = new BoyNode(i);
				cur.setNext(newBoy);
				newBoy.setNext(first);
				cur = newBoy;
			}
		}
	}

	/**
	 * 遍历链表
	 */
	public void showList() {
		if (first == null) {
			System.out.println("还没得娃儿来耍");
			return;
		}
		// 辅助节点用于遍历
		BoyNode cur = first;
		while (true) {
			if (cur.getNext() == first) {
				System.out.printf("娃儿的号码是:%d\n", cur.getNo());
				System.out.println("已经是最后一个娃儿了，散了吧~");
				return;
			}
			System.out.printf("娃儿的号码是:%d\n", cur.getNo());
			cur = cur.getNext();
		}
	}
}

/**
 * 孩子节点
 * 
 * @author vi
 *
 */
class BoyNode {
	private int no;
	private BoyNode next;

	public BoyNode(int no) {
		this.no = no;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public BoyNode getNext() {
		return next;
	}

	public void setNext(BoyNode next) {
		this.next = next;
	}
}
