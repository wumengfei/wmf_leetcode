package offer;

import binaryTree.traversing_bt.Node;

public class q24 {
    // 判断一个数组是不是二叉搜索树的后序遍历序列
    public boolean verifySequenceOfBST(int[] seq, int length){
        if (length<0 || seq==null){
            return false;
        }

        int root = seq[length-1];
        int sep = length-1;
        for (int i=0; i<length; i++){
            if (seq[i] > root){
                sep = i;
                break;
            }
        }
        for (int i=sep; i<length-1; i++){
            if (seq[i] < root){
                return false;
            }
        }

        int[] left = new int[sep];
        int[] right = new int[length-sep-1];
        System.arraycopy(seq, 0, left, 0, sep);
        System.arraycopy(seq, sep, right, 0, length-sep-1);
        return verifySequenceOfBST(left, sep) && verifySequenceOfBST(right, length-sep-1);

    }
}
