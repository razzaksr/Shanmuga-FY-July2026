package day13;

import java.util.ArrayList;
import java.util.List;

import day10.TreeNode;

public class GoodPairLeaf {
    private int result=0;
    List<Integer> dDive(TreeNode node, int dist){
        if(node==null) return new ArrayList<>();
        if(node.getLeft()==null&&node.getRight()==null){
            List<Integer> temp = new ArrayList<>();
            temp.add(1);
            return temp;
        }
        List<Integer> lLeft = dDive(node.getLeft(), dist);
        List<Integer> rLeft = dDive(node.getRight(), dist);
        for(int l:lLeft)
            for(int r:rLeft) if(l+r <= dist) result++;
        List<Integer> level = new ArrayList<>();
        for(int l:lLeft) if(l+1<=dist) level.add(l+1);
        for(int r:rLeft) if(r+1<=dist) level.add(r+1);
        return level;
    }
    public int countPairs(TreeNode root, int dist){
        dDive(root, dist);
        return result;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.setLeft(new TreeNode(2));
        root.setRight(new TreeNode(3));
        root.getLeft().setLeft(new TreeNode(4));
        root.getLeft().setRight(new TreeNode(5));
        root.getRight().setLeft(new TreeNode(6));
        root.getRight().setRight(new TreeNode(7));
        System.out.println(new GoodPairLeaf().countPairs(root, 3));
    }
}
