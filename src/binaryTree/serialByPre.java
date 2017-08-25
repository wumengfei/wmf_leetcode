package binaryTree;
import java.util.Queue;
import java.util.LinkedList;
import java.util.List;
import binaryTree.traversing_bt.Node;

// ***
public class serialByPre {
	//定义Node类
		public class Node{
			public int value;
			public Node left;
			public Node right;
			
			public Node(int data){
				this.value = data;
			}
		}
	
	public String serialByPre(Node head){
		if (head == null){
			return "#!";
		}
		String str = head.value + "!";
		str += serialByPre(head.left);
		str += serialByPre(head.right);
		return str;
	}
	public Node reconByPreString(String preStr){
		String[] values = preStr.split("!");
		Queue<String> queue = new LinkedList<String>();
		for (int i=0; i<values.length; i++){
			queue.offer(values[i]);
		}
		return reconPreOrder(queue);
	}
	public Node reconPreOrder(Queue<String> queue){
		String value = queue.poll();
		if (value.equals("#")){
			return null;
		}
		Node head = new Node(Integer.valueOf(value));
		head.left = reconPreOrder(queue);
		head.right = reconPreOrder(queue);
		return head;
	}
}
