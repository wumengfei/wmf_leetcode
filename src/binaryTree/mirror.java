package binaryTree;

import binaryTree.traversing_bt.Node;

public class mirror {
    // 二叉树的镜像, 采用递归
    public void mirror_recur(Node pNode){
        if (pNode==null){
            return;
        }
        if (pNode.left==null && pNode.right==null){
            return;
        }

        Node tmp = pNode.left;
        pNode.left = pNode.right;
        pNode.right = tmp;

        if (pNode.left != null){
            mirror_recur(pNode.left);
        }
        if (pNode.right != null){
            mirror_recur(pNode.right);
        }
    }
}
