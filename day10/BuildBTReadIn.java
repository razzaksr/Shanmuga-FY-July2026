package day10;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Node{
    String val;
    Node left,right;
    public Node(String data){val=data;}
}

public class BuildBTReadIn {
    Node root;
    public BuildBTReadIn(String[] arr){
        if(arr.length==0) return;
        root=construction(arr, 0);
    }
    public static Node construction(String[] arr,int index){
        if(index>=arr.length||arr[index]==null) return null;
        Node node = new Node(arr[index]);
        node.left = construction(arr, 2*index+1);
        node.right = construction(arr, 2*index+2);
        return node;
    }
    public static List<String> traverseInViaLoop(Node root){
        List<String> result = new ArrayList<>();
        Stack<Node> stk = new Stack<>();
        Node cur = root;
        while(cur!=null||!stk.isEmpty()){
            while(cur!=null)
                {stk.push(cur);cur=cur.left;}
            cur=stk.pop();
            result.add(cur.val);
            cur=cur.right;
        }
        return result;
    }
    public static List<String> traverseInViaRecur(Node root){
        List<String> result = new ArrayList<>();
        perform(root, result);
        return result;
    }
    private static void perform(Node node, List<String> result){
        if(node==null) return;
        perform(node.left, result);
        result.add(node.val);
        perform(node.right, result);
    }
    public static void main(String[] args) {
        BuildBTReadIn bt=new BuildBTReadIn(new String[]{
            "tcs","cts","infy","lti","ibm","zoho"});
        // System.out.println(traverseInViaLoop(bt.root));
        System.out.println(traverseInViaRecur(bt.root));
    }
}
