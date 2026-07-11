package day10;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PreOrder {
    public static List<Integer> traversePreViaLoop(TreeNode root){
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stk = new Stack<>();
        stk.push(root);
        while(!stk.isEmpty()){
            TreeNode cur=stk.pop();
            result.add(cur.val);
            if(cur.right!=null) stk.push(cur.right);
            if(cur.left!=null) stk.push(cur.left);
        }
        return result;
    }
    public static List<Integer> traversePreViaRecur(TreeNode root){
        List<Integer> result = new ArrayList<>();
        perform(root, result);
        return result;
    }
    private static void perform(TreeNode node, List<Integer> result){
        if(node==null) return;
        result.add(node.val);
        perform(node.left, result);
        perform(node.right, result);
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        // System.out.println(traversePreViaRecur(root));
        System.out.println(traversePreViaLoop(root));
    }
}
