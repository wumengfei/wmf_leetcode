package binaryTree;

import binaryTree.traversing_bt.Node;

// *****
public class boundary_bt {
	
	public int getHeight(Node h, int l){
		if (h == null){
			return l;
		}
		return Math.max(getHeight(h.left, l+1), getHeight(h.right, l+1));
	}
     
	public void setEdgeMap(Node h, int l, Node[][] edgeMap){
		if (h == null){
			return;
		}
		edgeMap[l][0] = edgeMap[l][0]==null ? h : edgeMap[l][0];
		edgeMap[l][1] = h;
		setEdgeMap(h.left, l+1, edgeMap);
		setEdgeMap(h.right, l+1, edgeMap);
	}
	
	public void printLeafNotInMap(Node h, int l, Node[][] m){
		if (h==null){
			return;
		}
		if (h.left == null && h.right == null && h != m[l][0] && h != m[l][1]){
			System.out.println(h.value + " ");
		}
		printLeafNotInMap(h.left, l+1, m);
		printLeafNotInMap(h.right, l+1, m);
	}
	
	public void printEdge(Node head){
		if (head == null){
			return;
		}
		int height = getHeight(head, 0);
		Node[][] edgeMap = new Node[height][2];
		setEdgeMap(head, 0, edgeMap);
		for (int i=0; i<edgeMap.length; i++){
			System.out.println(edgeMap[i][0].value + " ");
		}
		printLeafNotInMap(head, 0, edgeMap);
		for (int i=edgeMap.length-1; i>=0; i--){
			if (edgeMap[i][0] != edgeMap[i][1]){
				System.out.println(edgeMap[i][1].value + " ");
			}
		}
	}
}
