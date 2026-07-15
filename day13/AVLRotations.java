package day13;

import day10.LevelOrder;
import day10.TreeNode;

public class AVLRotations {
    public static int getHeight(TreeNode node){
        if(node==null) return 0;
        return Math.max(getHeight(node.getLeft()), getHeight(node.getRight()))+1;
    }
    public static int getFactor(TreeNode node){
        if(node==null) return 0;
        return getHeight(node.getLeft()) - getHeight(node.getRight());
    }
    public static TreeNode rightRotation(TreeNode node){
        TreeNode child = node.getLeft();
        TreeNode leaf = child.getRight();
        child.setRight(node);
        node.setLeft(leaf);
        return child;
    }
    public static TreeNode leftRotation(TreeNode node){
        TreeNode child = node.getRight();
        TreeNode leaf = child.getLeft();
        child.setLeft(node);
        node.setRight(leaf);
        return child;
    }
    public static TreeNode insert(TreeNode root, int newOne){
        if(root==null) return new TreeNode(newOne);
        if(newOne < root.getVal()) root.setLeft(insert(root.getLeft(), newOne));
        else if(newOne>root.getVal()) root.setRight(insert(root.getRight(), newOne));
        else return root;
        int currentFactor = getFactor(root);
        // Left skewed tree >> right rotation
        if(currentFactor>1&&newOne<root.getLeft().getVal())
            return rightRotation(root);
        // Right skewed tree>> left rotation
        if(currentFactor<-1 && newOne>root.getRight().getVal())
            return leftRotation(root);
        // Left right
        if(currentFactor>1&&newOne>root.getLeft().getVal()){
            root.setLeft(leftRotation(root.getLeft()));
            return rightRotation(root);
        }
        // right left rotation
        if(currentFactor<-1&&newOne<root.getRight().getVal()){
            root.setRight(rightRotation(root.getRight()));
            return leftRotation(root);
        }
        return root;
    }
    public static void main(String[] args) {
        TreeNode root = null;
        int[] nums = {25,20,15};
        for(int each:nums) root = insert(root, each);
        System.out.println(LevelOrder.orderLevel(root));
        nums = new int[]{25,30,40};root=null;
        for(int each:nums) root = insert(root, each);
        System.out.println(LevelOrder.orderLevel(root));
        nums = new int[]{25,20,22};root=null;
        for(int each:nums) root = insert(root, each);
        System.out.println(LevelOrder.orderLevel(root));
        nums = new int[]{25,30,28};root=null;
        for(int each:nums) root = insert(root, each);
        System.out.println(LevelOrder.orderLevel(root));
        nums = new int[]{100,150,50,200,125,110};root=null;
        for(int each:nums) root = insert(root, each);
        System.out.println(LevelOrder.orderLevel(root));
    }
}