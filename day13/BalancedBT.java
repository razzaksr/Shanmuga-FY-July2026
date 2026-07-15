package day13;

import day10.TreeNode;

public class BalancedBT {
    static int depth(TreeNode node){
        if(node==null) return 0;
        int lDepth = depth(node.getLeft());
        if(lDepth==-1) return -1;
        int rDepth = depth(node.getRight());
        if(rDepth==-1) return -1;
        if(Math.abs(lDepth-rDepth)>1) return -1;
        return Math.max(lDepth, rDepth)+1;
    }
    public static boolean isBalanced(TreeNode root){
        return depth(root)!=-1;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.setLeft(new TreeNode(9));
        root.setRight(new TreeNode(20));
        root.getRight().setLeft(new TreeNode(15));
        root.getRight().setRight(new TreeNode(7));
        System.out.println(isBalanced(root));
    }
}
