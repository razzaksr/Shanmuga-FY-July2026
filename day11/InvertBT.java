package day11;

import day10.LevelOrder;
import day10.TreeNode;

public class InvertBT {
    public static TreeNode invert(TreeNode root){
        if(root==null) return null;
        TreeNode temp = root.getLeft();
        root.setLeft(root.getRight());
        root.setRight(temp);
        invert(root.getLeft());
        invert(root.getRight());
        return root;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.setLeft(new TreeNode(2)); 
        root.setRight(new TreeNode(3)); 
        root.getLeft().setLeft(new TreeNode(4)); 
        root.getLeft().setRight(new TreeNode(5)); 
        root.getRight().setLeft(new TreeNode(6)); 
        root.getRight().setRight(new TreeNode(7));
        root = invert(root);
        System.out.println(LevelOrder.orderLevel(root));
    }
}
