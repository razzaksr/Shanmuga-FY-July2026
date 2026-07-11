package day10;

public class MaxPathSum {
    static int maxSum=Integer.MIN_VALUE;
    public static int maxPathSum(TreeNode root){
        findSum(root);
        return maxSum;
    }
    private static int findSum(TreeNode node){
        if(node==null) return 0;
        int lSum = Math.max(findSum(node.left), 0);
        int rSum = Math.max(findSum(node.right), 0);
        int cSum = node.val+lSum+rSum;
        maxSum = Math.max(maxSum, cSum);
        return node.val+Math.max(lSum, rSum);
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(-10);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println(maxPathSum(root));
    }
}
