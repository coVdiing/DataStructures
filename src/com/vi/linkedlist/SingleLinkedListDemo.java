package com.vi.linkedlist;

import java.util.Stack;

public class SingleLinkedListDemo {

	public static void main(String[] args) {
		HeroNode hero1 = new HeroNode(1, "李白", "诗仙");
		HeroNode hero2 = new HeroNode(2, "杜甫", "诗圣");
		HeroNode hero3 = new HeroNode(3, "李贺", "诗鬼");
		HeroNode hero4 = new HeroNode(4, "王勃", "初唐四杰");
		HeroNode hero5 = new HeroNode(5,"李商隐", "无题");
		HeroNode hero6 = new HeroNode(6, "秦", "千古一帝");
		HeroNode hero7 = new HeroNode(7, "唐", "贞观之治");
		HeroNode hero8 = new HeroNode(8, "汉", "丝绸之路");
		HeroNode hero9 = new HeroNode(9, "清", "九子夺嫡");
		SingleLinkedList s1 = new SingleLinkedList();
		SingleLinkedList s2 = new SingleLinkedList();
		s1.add(hero1);
		s1.add(hero2);
		s2.add(hero3);
		s1.add(hero4);
		s2.add(hero5);
		s2.add(hero6);
		s2.add(hero7);
		s2.add(hero8);
		s1.add(hero9);
		System.out.println("链表的初始状态:");
		s1.showList();
		System.out.println("---------");
		s2.showList();
		System.out.println("测试合并方法:");
		HeroNode newHead = SingleLinkedList.mergeLinkedList(s1.getHead(), s2.getHead());
		SingleLinkedList.showList(newHead);
		// 测试getLength方法
//		System.out.println(sll.getLength(sll.getHead()));
		// 测试返回倒数第index个节点的方法
//		System.out.println(sll.findNodeByIndex(sll.getHead(),4));
		//测试反转单链表方法
//		System.out.println("测试反转方法");
//		sll.reverse();
//		System.out.println("测试逆序打印单链表方法:");
//		sll.reversePrint(sll.getHead());
	}

}

class SingleLinkedList {
	private HeroNode head = new HeroNode(0, null, null);
	
	//反转单链表
	public void reverse() {
		if(head.next == null || head.next.next == null)
			return ;
		HeroNode temp = head.next;
		HeroNode newHead = new HeroNode(0,"","");
		while(temp!=null){
			//如果newHead.next==null，说明后面没有节点，把遍历的节点直接加上去即可
			if(newHead.next == null) {
				newHead.next = temp;
				HeroNode next = temp.next;
				//末尾的节点next需要置null
				temp.next = null;
				temp = next;
			}
			else {
				HeroNode next = temp.next;
				temp.next = newHead.next;
				newHead.next = temp;
				temp = next;
			}
		}
		head.next = newHead.next;
	}
	
	//合并两个有序单链表，要求合并之后依旧有序
	public static HeroNode mergeLinkedList(HeroNode head1,HeroNode head2) {
		HeroNode newHead = new HeroNode(0, "", "");
		HeroNode cur1 = head1.next;
		HeroNode cur2 = head2.next;
		HeroNode newCur = newHead;
		while(cur1 != null || cur2 != null) {
				if(cur1 != null && cur2 != null) {
					if(cur1.no >= cur2.no) {
						newCur.next = cur2;
						newCur = newCur.next;
						cur2 = cur2.next;
					} else {
						newCur.next = cur1;
						newCur = newCur.next;
						cur1 = cur1.next;
					}
				} else if(cur1 == null && cur2 != null) {
					newCur.next = cur2;
					newCur = newCur.next;
					cur2 = cur2.next;
				} else {
					newCur.next = cur1;
					newCur = newCur.next;
					cur1 = cur1.next;
				}
			}
		return newHead;
	}
	
	//逆序打印单链表,利用栈
	public void reversePrint(HeroNode head) {
		if(head.next == null)
			return;
		HeroNode cur = head.next;
		Stack<HeroNode> nodeStack = new Stack<>();
		while(cur != null) {
			nodeStack.push(cur);
			cur = cur.next;
		}
		while(nodeStack.size()>0) {
			System.out.println(nodeStack.pop());
		}
	}
	
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
	
	// 遍历链表2
		public static void showList(HeroNode head) {
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