package day10;

public class DiameterBT {
    static int diameter=0;
    public static int diaFind(TreeNode root){
        depth(root);
        return diameter;
    }
    public static int depth(TreeNode node){
        if(node==null) return 0;
        int lDepth = depth(node.left);
        int rDepth = depth(node.right);
        diameter = Math.max(diameter,(lDepth+rDepth));
        return 1+Math.max(lDepth, rDepth);
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        System.out.println(diaFind(root));
    }
}
