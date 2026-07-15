package day13;

import day10.TreeNode;

public class KthMinInBST {
    int count=0;
    int result = -1;
    public int kth(TreeNode root,int k){
        inOrder(root, k);
        return result;
    }
    void inOrder(TreeNode node, int k){
        if(node==null) return;
        inOrder(node.getLeft(),k);
        count++;
        if(count==k) {result = node.getVal();return;}
        inOrder(node.getRight(), k);
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(230);
        root.setLeft(new TreeNode(210));
        root.setRight(new TreeNode(450));
        root.getLeft().setLeft(new TreeNode(98));
        root.getLeft().setRight(new TreeNode(220));
        System.out.println(new KthMinInBST().kth(root, 2));
    }
}
