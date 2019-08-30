package com.vi.linkedlist;

public class SingleLinkedListDemo {

	public static void main(String[] args) {
		HeroNode hero1 = new HeroNode(1,"李白","诗仙");
		HeroNode hero2 = new HeroNode(2,"杜甫","诗圣");
		HeroNode hero3 = new HeroNode(3,"李贺","诗鬼");
		HeroNode hero4 = new HeroNode(4,"王勃","初唐四杰");
		SingleLinkedList sll = new SingleLinkedList();
		sll.add(hero1);
		sll.add(hero2);
		sll.add(hero3);
		sll.add(hero4);
		sll.showList();
	}

}

class SingleLinkedList {
	private HeroNode head = new HeroNode(0,null,null);
	
	//添加节点
	public void add(HeroNode hero) {
		HeroNode temp = head;
		while(true) {
			if(temp.next == null) {
				break;
			}
			temp = temp.next;
		}
		temp.next = hero;
	}
	
	//遍历链表
	public void showList() {
		HeroNode temp = head;
		//判断链表是否为空
		if(temp.next == null) {
			System.out.println("链表为空!");
			return;
		}
		temp = temp.next;
		while(true) {
			if(temp.next == null) {
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