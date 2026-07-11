package day10;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class PostOrder {
    public static List<Integer> traversePostViaLoop(TreeNode root){
        LinkedList<Integer> result = new LinkedList<>();
        Stack<TreeNode> stk = new Stack<>();
        stk.push(root);
        while(!stk.isEmpty()){
            TreeNode cur=stk.pop();
            result.addFirst(cur.val);
            if(cur.left!=null) stk.push(cur.left);
            if(cur.right!=null) stk.push(cur.right);
        }
        return result;
    }
    public static List<Integer> traversePostViaRecur(TreeNode root){
        List<Integer> result = new ArrayList<>();
        perform(root, result);
        return result;
    }
    private static void perform(TreeNode node, List<Integer> result){
        if(node==null) return;
        perform(node.left, result);
        perform(node.right, result);
        result.add(node.val);
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        System.out.println(traversePostViaRecur(root));
        // System.out.println(traversePostViaLoop(root));
    }
}
