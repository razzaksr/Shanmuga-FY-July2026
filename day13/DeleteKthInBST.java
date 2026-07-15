package day13;

import day10.LevelOrder;
import day10.TreeNode;

public class DeleteKthInBST {
    static TreeNode minFind(TreeNode node){
        while(node.getLeft()!=null) node = node.getLeft();
        return node;
    }
    static TreeNode delete(TreeNode root, int key){
        if(root==null) return null;
        if(key<root.getVal()) 
            root.setLeft(delete(root.getLeft(), key));
        else if(key>root.getVal())
            root.setRight(delete(root.getRight(), key));
        else{
            if(root.getLeft()==null) return root.getRight();
            if(root.getRight()==null) return root.getLeft();
            TreeNode rep = minFind(root.getRight());
            root.setVal(rep.getVal());
            root.setRight(delete(root.getRight(), rep.getVal()));
        }
        return root;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(7);
        root.setLeft(new TreeNode(3));
        root.getLeft().setLeft(new TreeNode(2));
        root.getLeft().getLeft().setLeft(new TreeNode(1));
        root.setRight(new TreeNode(8));
        delete(root, 7);
        System.out.println(LevelOrder.orderLevel(root));
    }
}
