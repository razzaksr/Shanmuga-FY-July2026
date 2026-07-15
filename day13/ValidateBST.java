package day13;

import day10.TreeNode;

public class ValidateBST {
    public static boolean isValid(TreeNode root){
        return check(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    public static boolean check(TreeNode node, 
        long min, long max){
        if(node==null) return true;
        if(node.getVal()<=min||node.getVal()>=max) 
            return false;
        return check(node.getLeft(), min, node.getVal())&&
        check(node.getRight(), node.getVal(), max);
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.setLeft(new TreeNode(1));
        root.setRight(new TreeNode(4));
        root.getRight().setLeft(new TreeNode(3));
        root.getRight().setRight(new TreeNode(6));
        System.out.println(isValid(root));
        root = new TreeNode(2);
        root.setLeft(new TreeNode(1));
        root.setRight(new TreeNode(3));
        System.out.println(isValid(root));
    }
}
