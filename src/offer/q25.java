package offer;

import binaryTree.traversing_bt.Node;

import java.util.LinkedList;

public class q25 {
    // 二叉树中和为某一值的路径
    public void findPath(Node head, int expSum){
        if (head == null){
            return;
        }
        int curSum = 0;
        LinkedList<Node> path = new LinkedList<>();
        findPath(head, expSum, path, curSum);
    }

    public void findPath(Node head, int expSum, LinkedList<Node> path, int curSum){
        curSum += head.value;
        path.addLast(head);

        boolean isLeaf = head.left==null && head.right==null;
        if (isLeaf && curSum==expSum){
            System.out.println("find a path");
        }

        if (head.left != null){
            findPath(head.left, expSum, path, curSum);
        }
        if (head.right != null){
            findPath(head.right, expSum, path, curSum);
        }

        path.pollLast();
    }
}
