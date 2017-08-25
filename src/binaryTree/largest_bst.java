package binaryTree;

import binaryTree.traversing_bt.Node;

public class largest_bst {
	//定义Node类
		public class Node{
			public int value;
			public Node left;
			public Node right;
			
			public Node(int data){
				this.value = data;
			}
		}
		
	public Node biggestSubBST(Node head){
		int[] record = new int[3];// 存储size，min和max
		return posOrder(head, record);
	} 
	
	public Node posOrder(Node head, int[] record){
		if (head == null){
			record[0] = 0;
			record[1] = Integer.MAX_VALUE;
			record[2] = Integer.MIN_VALUE;
			return head;
		}
		Node left = head.left;
		Node right = head.right;
		Node lBST = posOrder(left, record);
		int lLen = record[0];
		int lMin = record[1];
		int lMax = record[2];
		Node rBST = posOrder(right, record);
		int rLen = record[0];
		int rMin = record[1];
		int rMax = record[2];
		record[1] = Math.min(lMin, head.value);//因为最大最小值只在head为bst时才有意义
		record[2] = Math.max(rMax, head.value);
		if (left == lBST && right == rBST && lMax < head.value && head.value < rMin){
			record[0] = lLen + rLen + 1;
			return head;
		}
		record[0] = Math.max(lLen, rLen);
		return lLen>rLen ? lBST : rBST;		
	}
}
