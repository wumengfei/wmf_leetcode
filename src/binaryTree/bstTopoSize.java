package binaryTree;

import binaryTree.traversing_bt.Node;

public class bstTopoSize {
	//定义Node类
	public class Node{
		public int value;
		public Node left;
		public Node right;
		
		public Node(int data){
			this.value = data;
		}
	}
	
	public int bstTopoSize1(Node head){
		if (head == null){
			return 0;
		}
		int max = maxTopo(head, head);
		max = Math.max(bstTopoSize1(head.left), max);
		max = Math.max(bstTopoSize1(head.right), max);
		return max;
	}
	//返回head的最大拓扑结构数
	public int maxTopo(Node head, Node n){
		if(head != null && n != null & isBSTNode(head, n, n.value)){
			return maxTopo(head, n.left) + maxTopo(head, n.right) + 1;
		}
		return 0;
	}
	//判断n是不是h的拓扑结构
	public boolean isBSTNode(Node head, Node n, int value){
		if (head == null){
			return false;
		}
		if (head == n){
			return true;
		}
		return isBSTNode(head.value > value ? head.left : head.right, n, value);
	}
	
	public boolean isBSTNode(Node head, int value){
		if (head == null) return false;
		if (head.value == value) return true;
		return isBSTNode(head.value>value?head.left:head.right, value);
	}
}
