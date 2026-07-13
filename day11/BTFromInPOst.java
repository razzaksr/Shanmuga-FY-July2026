package day11;

import java.util.Stack;

import day10.LevelOrder;
import day10.TreeNode;

public class BTFromInPOst {
    public static TreeNode buildTree(int[] in, int[] post){
        if(in==null||post==null||in.length==0) return null;
        int iIndex=in.length-1, pIndex=post.length-1;
        Stack<TreeNode> stk = new Stack<>();
        TreeNode root = new TreeNode(post[pIndex]);pIndex--;
        stk.push(root);
        while(pIndex>=0){
            TreeNode node = stk.peek();
            if(node.getVal()!=in[iIndex]){
                TreeNode right = new TreeNode(post[pIndex]);
                pIndex--;
                node.setRight(right);
                stk.push(right);
            }
            else{
                while(!stk.isEmpty()&&
                        stk.peek().getVal()==in[iIndex]){
                    node = stk.pop();iIndex--;
                }
                if(pIndex>=0){
                    TreeNode left = new TreeNode(post[pIndex]);
                    pIndex--;node.setLeft(left);stk.push(left);
                }
            }
        }
        return root;
    }
    public static void main(String[] args) {
        int[] pOrder = {9,15,7,20,3};
        int[] iOrder = {9,3,15,20,7};
        TreeNode root = buildTree(iOrder, pOrder);
        System.out.println(LevelOrder.orderLevel(root));
    }
}
