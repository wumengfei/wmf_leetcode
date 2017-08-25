package binaryTree;

import binaryTree.largest_bst.Node;

public class reConBt {
	public class Node{
		public int value;
		public Node left;
		public Node right;
		
		public Node(int data){
			this.value = data;
		}
	}
	//使用前序和中序数组重构二叉树
	public Node preInToTree(int[] pre, int[] in){
		Node node = preRecon(pre, 0, pre.length-1, in, 0, in.length-1);
		return node;
	}
	
	public Node preRecon(int[] pre, int pre_start, int pre_end, int[] in, int in_start, int in_end){
		if (pre_start>pre_end || in_start>in_end){
			return null;
		}
		Node root = new Node(pre[pre_start]);
		for(int i=in_start; i<=in_end; i++){
			if(in[i]==root.value){
				root.left = preRecon(pre, pre_start+1, pre_start+i-in_start, in, in_start, i-1);
				root.right = preRecon(pre, pre_start+i-in_start+1, pre_end, in, i+1, in_end);
			}
		}
		return root;
	}
	
	
	//使用后序和中序数组重构二叉树
	public Node posInToTree(int[] pos, int[] in){
		Node node = posRecon(pos, 0, pos.length-1, in, 0, in.length-1);
		return node;
	}
	
	public Node posRecon(int[] pos, int pos_start, int pos_end, int[] in, int in_start, int in_end){
		if (pos_start>pos_end || in_start>in_end) return null;
		Node root = new Node(pos[pos_end]);
		for(int i=in_start; i<=in_end; i++){
			if(in[i]==root.value){
				root.left = posRecon(pos, pos_start, pos_start+i-in_start-1, in, in_start, i-1);
				root.right = posRecon(pos, pos_start+i-in_start, pos_end-1, in, i+1, in_end);
			}
		}
		return root;
	}
}
