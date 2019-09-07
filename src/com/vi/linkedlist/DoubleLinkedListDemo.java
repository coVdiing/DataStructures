package com.vi.linkedlist;
/**
 * 双向链表
 * 相比单向链表，每一个节点都可以找到自己的上一个节点，可以双向查找
 * @author vi
 *
 */
public class DoubleLinkedListDemo {
	public static void main(String[] args) {
		HeroNode2 node1 = new HeroNode2(1,"火影忍者","岸本齐史");
		HeroNode2 node2 = new HeroNode2(2,"海贼王","尾田荣一郎");
		HeroNode2 node3 = new HeroNode2(3,"死神","久保带人");
		HeroNode2 node4 = new HeroNode2(4,"犬夜叉","高桥留美子");
		DoubleLinkedList dll = new DoubleLinkedList();
		//添加节点
		dll.add(node1);
		dll.add(node2);
		dll.add(node3);
		dll.add(node4);
		//遍历链表
		DoubleLinkedList.showList(dll.getHead());
		//测试删除方法
//		dll.delete(1);
//		DoubleLinkedList.showList(dll.getHead());
		dll.update(new HeroNode2(1,"龙珠Z","鸟山明"));
		dll.update(new HeroNode2(5,"进击的巨人","谏山创"));
		DoubleLinkedList.showList(dll.getHead());
	}
}

class DoubleLinkedList {
	//头结点
	private HeroNode2 head = new HeroNode2(0,"","");
	
	
	//返回头结点
	public HeroNode2 getHead() {
		return this.head;
	}
	//遍历链表方法
	public static void showList(HeroNode2 head) {
		if(head.getNext() == null) {
			System.out.println("链表为空!");
			return;
		}
		head = head.getNext();
		while(head.getNext() != null) {
			System.out.println(head);
			head = head.getNext();
		}
		System.out.println(head);
	}
	
	//添加节点方法
	public void add(HeroNode2 node) {
		HeroNode2 temp = head;
		while(temp.getNext() != null) {
			temp = temp.getNext();
		}
		//添加节点的双向关系
		temp.setNext(node);
		node.setPre(temp);
	}
	
	//删除节点方法
	public void delete(int value) {
		HeroNode2 cur = this.getHead().getNext();
		if(cur == null) {
			System.out.println("链表为空!没有可删除的节点");
		}
		while(cur != null) {
			if(cur.getValue() == value) {
				//找到目标节点，把该节点的上一个节点和下一个节点连接起来
				cur.getPre().setNext(cur.getNext());
				//如果cur的下一个节点不是null，还需要下一个节点的pre指向cur的上一个节点
				if(cur.getNext() != null) {
					cur.getNext().setPre(cur.getPre());
				}
				System.out.println("目标节点已删除");
				return;
			}
			cur = cur.getNext();
		}
		System.out.println("链表中没有找到要删除的节点");
	}
	
	//修改节点方法
	public void update(HeroNode2 node) {
		HeroNode2 cur = this.getHead().getNext();
		if(cur == null) {
			System.out.println("链表为空");
		}
		//是否修改的标记
		boolean flag = false;
		while(cur != null) {
			if(cur.getValue() == node.getValue()) {
				cur.setName(node.getName());
				cur.setNickName(node.getNickName());
				flag = true;
			}
			cur = cur.getNext();
		}
		if(flag) {
			System.out.println("修改成功!");
		} else {
			System.out.println("链表中没有找到该节点");
		}
	}
}

class HeroNode2 {
	private int value;
	private String name;
	private String nickName;
	//指向上一个节点
	private HeroNode2 pre;
	//指向下一个节点
	private HeroNode2 next;
	public HeroNode2(int value,String name,String nickName) {
		this.value = value;
		this.name = name;
		this.nickName = nickName;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public HeroNode2 getPre() {
		return pre;
	}
	public void setPre(HeroNode2 pre) {
		this.pre = pre;
	}
	public HeroNode2 getNext() {
		return next;
	}
	public void setNext(HeroNode2 next) {
		this.next = next;
	}
	@Override
	public String toString() {
		return "HeroNode2 [value=" + value + ", name=" + name + ", nickName=" + nickName + "]";
	}
}