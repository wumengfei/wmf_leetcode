package offer;

import binaryTree.traversing_bt.Node;

public class q27 {
    // bst转化成双向链表
    public Node convert(Node head){
        Node lastNode = null;
        convertNode(head, lastNode);
        while (lastNode!=null && lastNode.left!=null){
            lastNode = lastNode.left;
        }
        return lastNode;
    }

    public void convertNode(Node head, Node lastNode){
        // 把head加入到lastNode当中
        if (head==null){
            return;
        }
        if (head.left != null){
            convertNode(head.left, lastNode);
        }
        head.left = lastNode;
        if (lastNode != null){
            lastNode.right = head;
        }
        lastNode = head;
        if (head.right != null){
            convertNode(head.right, lastNode);
        }
    }
}
