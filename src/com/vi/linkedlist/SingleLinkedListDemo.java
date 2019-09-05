package com.vi.linkedlist;

public class SingleLinkedListDemo {

	public static void main(String[] args) {
		HeroNode hero1 = new HeroNode(1, "李白", "诗仙");
		HeroNode hero2 = new HeroNode(2, "杜甫", "诗圣");
		HeroNode hero3 = new HeroNode(3, "李贺", "诗鬼");
		HeroNode hero4 = new HeroNode(4, "王勃", "初唐四杰");
		SingleLinkedList sll = new SingleLinkedList();
		sll.add(hero1);
		sll.add(hero2);
		sll.add(hero3);
		sll.add(hero4);
		sll.showList();
		// 测试getLength方法
		System.out.println(sll.getLength(sll.getHead()));
		// 测试返回倒数第index个节点的方法
		System.out.println(sll.findNodeByIndex(sll.getHead(),4));
	}

}

class SingleLinkedList {
	private HeroNode head = new HeroNode(0, null, null);

	// 返回头结点
	public HeroNode getHead() {
		return this.head;
	}

	// 查找有效节点个数
	public int getLength(HeroNode head) {
		if (head.next == null)
			return 0;
		int length = 0;
		HeroNode temp = head;
		while (temp.next != null) {
			length++;
			temp = temp.next;
		}
		return length;
	}

	// 查找链表中倒数第index个节点
	public HeroNode findNodeByIndex(HeroNode head, int index) {
		if (head.next == null) {
			return null;
		}
		// 获取链表的长度
		int size = getLength(head);
		HeroNode temp = head;
		if (index <= 0 || index > size) {
			return null;
		} else {
			for(int i = 0 ;  i < size - index+1;i++) {
				temp = temp.next;
			}
			return temp;
		}
	}

	// 添加节点
	public void add(HeroNode hero) {
		HeroNode temp = head;
		while (true) {
			if (temp.next == null) {
				break;
			}
			temp = temp.next;
		}
		temp.next = hero;
	}

	// 修改节点
	public void update(HeroNode newHero) {
		// 判断链表是否为空
		if (head.next == null) {
			return;
		}
		HeroNode temp = head;
		boolean flag = false;
		while (true) {
			temp = temp.next;
			if (temp.next == null)
				break;
			if (newHero.no == temp.no) {
				temp.name = newHero.name;
				temp.nickName = newHero.nickName;
				flag = true;
				break;
			}
		}
		if (flag) {
			System.out.println("修改成功");
		} else {
			System.out.println("没有找到该节点");
		}
	}

	// 删除节点
	public void del(int no) {
		if (head.next == null) {
			System.out.println("链表为空");
			return;
		}
		HeroNode temp = head;
		boolean flag = false;
		while (true) {
			if (temp.next == null) {
				break;
			}
			if (temp.next.no == no) {
				temp.next = temp.next.next;
				flag = true;
				break;
			}
			temp = temp.next;
		}
		if (flag) {
			System.out.printf("节点%d删除成功\n", no);
		} else {
			System.out.printf("节点%d删除失败\n", no);
		}
	}

	// 遍历链表
	public void showList() {
		HeroNode temp = head;
		// 判断链表是否为空
		if (temp.next == null) {
			System.out.println("链表为空!");
			return;
		}
		temp = temp.next;
		while (true) {
			if (temp.next == null) {
				System.out.println(temp.toString());
				break;
			}
			System.out.println(temp.toString());
			temp = temp.next;
		}
	}
}

class HeroNode {
	public int no;
	public String name;
	public String nickName;
	public HeroNode next;

	public HeroNode(int no, String name, String nickName) {
		super();
		this.no = no;
		this.name = name;
		this.nickName = nickName;
	}

	@Override
	public String toString() {
		return "HeroNode [no=" + no + ", name=" + name + ", nickName=" + nickName + "]";
	}

}