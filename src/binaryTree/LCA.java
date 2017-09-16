package binaryTree;
import binaryTree.traversing_bt.Node;

public class LCA {
    public Node LCA(Node root, Node o1, Node o2){
        if (root==null || root==o1 || root==o2){
            return root;
        }
        Node left = LCA(root.left, o1, o2);
        Node right = LCA(root.right, o1, o2);
        if (left != null && right != null){
            return root;
        }
        return left!=null ? left : right;
    }
}
