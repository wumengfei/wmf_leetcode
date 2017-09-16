package binaryTree;
import binaryTree.traversing_bt.Node;

import java.util.Stack;

public class convertDuLinkList {
    // 将二叉树转成双向链表
    public Node convert(Node root){
        Stack<Node> stack = new Stack<>();
        Node p = root;
        Node pre = null;
        while (!stack.isEmpty() || p!=null){
            while (p!=null){
                stack.push(p);
                p = p.left;
            }
            p = stack.pop();
            p.left = pre;
            pre.right = p;
            pre = p;

            p = p.right;
        }
        while (p.left!=null){
            p = p.left;
        }
        return p;
    }
}
