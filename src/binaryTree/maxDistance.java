package binaryTree;

import binaryTree.largest_bst.Node;

public class maxDistance {
	public class Node{
		public int value;
		public Node left;
		public Node right;
		
		public Node(int data){
			this.value = data;
		}
	}
	
	public int maxDist(Node head){
		int[] record = new int[1];
		return posOrder(head, record);
	}
	
	public int posOrder(Node head, int[] record){
		if (head==null) {
			record[0] = 0;
			return 0;
		}
		int lMax = posOrder(head.left, record);
		int maxFromLeft = record[0];
		int rMax = posOrder(head.right, record);
		int maxFromRight = record[0];
		int cur = maxFromLeft + maxFromRight + 1;
		record[0] = Math.max(maxFromLeft, maxFromRight) + 1;
		return Math.max(Math.max(lMax, rMax), cur);
	}
}
