package binaryTree;

import java.util.Stack;

public class traversing_bt {
	//定义Node类
	public class Node{
		public int value;
		public Node left;
		public Node right;
		
		public Node(int data){
			this.value = data;
		}
	}
	// 先序，递归
	public void preOrderRecur(Node head){
		if (head==null){
			return;
		}
		System.out.println(head.value + " ");
		preOrderRecur(head.left);
		preOrderRecur(head.right);
	}
	// 中序，递归
	public void inOrderRecur(Node head){
		if (head==null){
			return;
		}
		inOrderRecur(head.left);
		System.out.println(head.value + " ");
		inOrderRecur(head.right);
	}
	//后序，递归
	public void posOrderRecur(Node head){
		if (head==null){
			return;
		}
		posOrderRecur(head.left);
		posOrderRecur(head.right);
		System.out.println(head.value + " ");
	}
	//先序，非递归
	public void preOrderUnRecur(Node head){
		if (head != null){
			Stack<Node> stack = new Stack<Node>();
			stack.add(head);
			while(!stack.isEmpty()){
				head = stack.pop();
				System.out.println(head.value + " ");
				if (head.right != null){
					stack.push(head.right);
				}
				if (head.left != null){
					stack.push(head.left);
				}
			}
		}		
	}
	// 中序，非递归
	public void inOrderUnRecur(Node head){
		if (head != null){
			Stack<Node> stack = new Stack<Node>();
			while(head != null || !stack.isEmpty()){
				if (head != null){
					stack.push(head);
					head = head.left;
				}else{
					head = stack.pop();
					System.out.println(head.value + " ");
					head = head.right;
				}	
			}
		}
	}
	// 后序，非递归
	public void posOrderUnRecur(Node head){
		if (head != null){
			Stack<Node> s1 = new Stack<Node>();
			Stack<Node> s2 = new Stack<Node>();
			s1.push(head);
			while(!s1.isEmpty()){
				head = s1.pop();
				if (head.left != null) s1.push(head.left);
				if (head.right != null) s1.push(head.right);
				s2.push(head);
			}
			while (!s2.isEmpty()){
				System.out.println(s2.pop().value + " ");
			}
		}
	}
}

