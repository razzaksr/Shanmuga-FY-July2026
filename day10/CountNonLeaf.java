package day10;

public class CountNonLeaf {
    public static int count(TreeNode node){
        if(node==null||node.left==null&&node.right==null) 
            return 0;
        return 1+count(node.left)+count(node.right);
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        System.out.println(count(root));
    }
}
