package day13;

import day10.TreeNode;

public class LCAinBST {
    public static TreeNode findAncestor(
        TreeNode root, TreeNode p, TreeNode q){
        while(root!=null){
            if(p.getVal()<root.getVal()&&
                    q.getVal()<root.getVal())
                root = root.getLeft();
            else if(p.getVal()>root.getVal()&&
                    q.getVal()>root.getVal())
                root = root.getRight();
            else return  root;
        }
        return null;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(6);
        root.setLeft(new TreeNode(2));
        root.setRight(new TreeNode(8));
        root.getLeft().setLeft(new TreeNode(0));
        root.getLeft().setRight(new TreeNode(4));
        root.getRight().setLeft(new TreeNode(7));
        root.getRight().setRight(new TreeNode(9));
        root.getLeft().getRight().setLeft(new TreeNode(3));
        root.getLeft().getRight().setRight(new TreeNode(5));
        System.out.println(findAncestor(root,
             new TreeNode(0), new TreeNode(9)).getVal());
    }
}
