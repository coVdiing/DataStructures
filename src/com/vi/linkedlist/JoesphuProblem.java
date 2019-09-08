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
//		jl.addNode(25);
//		jl.showList();
		//测试约瑟夫环游戏
		jl.joesphuProblem(10,125,20);
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
	
	/**
	 * 约瑟夫环问题，娃儿报数出圈
	 * @param startNo 开始序号
	 * @param number 娃儿的总数
	 * @param pace 每次第几个娃儿出圈
	 */
	public void joesphuProblem(int startNo,int number,int pace){
		//对数据做一个判断
		if(startNo > number || pace < 1 ) {
			System.out.println("数据有问题撒!");
		}
		//先生成指定number的环
		addNode(number);
		//定义一个辅助指针，用于指向遍历指针的前一个节点
		BoyNode helper = first;
		while(helper.getNext() != first) {
			helper = helper.getNext();
		}
		//让first指针移动到startNo这个娃儿这里
		for(int i = 0 ; i < startNo - 1;i++) {
			first = first.getNext();
			helper = helper.getNext();
		}
		System.out.println("link start!\n=================================");
		//开始游戏
		while(true) {
			if(helper == first)
				break;
			for(int i = 0 ; i < pace - 1; i++) {
				//开始移动两个指针
				first = first.getNext();
				helper = helper.getNext();
			}
			System.out.println("娃儿["+first.getNo()+"]退出了连接!");
			first = first.getNext();
			helper.setNext(first);
		}
		System.out.println("最后留下的幸运儿是娃儿["+first.getNo()+"]!奖励一辆乔碧萝tank");
		System.out.println("=================================");
		System.out.println("game over!");
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
