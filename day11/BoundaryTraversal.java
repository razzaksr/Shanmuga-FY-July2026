package day11;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import day10.TreeNode;

public class BoundaryTraversal {
    static List<Integer> result=new ArrayList<>();
    public static boolean isLeaf(TreeNode node){
        return (node.getLeft()==null&&node.getRight()==null);
    }
    public static void boundLeft(TreeNode node){
        TreeNode cNode = node.getLeft();
        while(cNode!=null){
            if(!isLeaf(cNode)) result.add(cNode.getVal());
            if(cNode.getLeft()!=null) cNode = cNode.getLeft();
            else cNode=cNode.getRight();
        }
    }
    public static void leaves(TreeNode node){
        if(isLeaf(node)) result.add(node.getVal());
        if(node.getLeft()!=null) leaves(node.getLeft());
        if(node.getRight()!=null) leaves(node.getRight());
    }
    public static void boundRight(TreeNode node){
        TreeNode cNode = node.getRight();
        List<Integer> temp = new ArrayList<>();
        while(cNode!=null){
            if(!isLeaf(cNode)) temp.add(cNode.getVal());
            if(cNode.getRight()!=null) cNode = cNode.getRight();
            else cNode=cNode.getLeft();
        }
        Collections.reverse(temp);
        result.addAll(temp);
    }
    public static List<Integer> travel(TreeNode root){
        if(!isLeaf(root)) result.add(root.getVal());
        boundLeft(root);
        leaves(root);
        boundRight(root);
        return result;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.setLeft(new TreeNode(2));
        root.setRight(new TreeNode(3));
        root.getLeft().setLeft(new TreeNode(4));
        root.getLeft().setRight(new TreeNode(5));
        root.getLeft().getRight().setLeft(new TreeNode(8));
        root.getLeft().getRight().setRight(new TreeNode(9));
        root.getRight().setLeft(new TreeNode(6));
        root.getRight().setRight(new TreeNode(7));
        root.getRight().getRight().setRight(new TreeNode(11));
        root.getRight().getRight().setLeft(new TreeNode(10));
        System.out.println(travel(root));
    }
}
