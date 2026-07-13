package day11;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import day10.TreeNode;

public class RightViewBT {
    public static List<Integer> view(TreeNode root){
        List<Integer> result = new ArrayList<>();
        if(root==null) return result;
        Deque<TreeNode> que = new LinkedList<>();que.offer(root);
        while(!que.isEmpty()){
            result.add(que.peekLast().getVal());
            Deque<TreeNode> byLevel = new LinkedList<>();
            while(!que.isEmpty()){
                TreeNode node = que.pollFirst();
                if(node.getLeft()!=null) 
                    byLevel.offer(node.getLeft());
                if(node.getRight()!=null) 
                    byLevel.offer(node.getRight());
            }
            que = byLevel;
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.setLeft(new TreeNode(2));
        root.getLeft().setLeft(new TreeNode(4));
        root.getLeft().getLeft().setLeft(new TreeNode(5));
        root.setRight(new TreeNode(3));
        System.out.println(view(root));
    }
}
