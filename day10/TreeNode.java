package day10;

public class TreeNode {
    int val;
    TreeNode left,right;
    public TreeNode(int v){val=v;}
    public int getVal() {
        return val;
    }
    public void setVal(int val) {
        this.val = val;
    }
    public TreeNode getLeft() {
        return left;
    }
    public void setLeft(TreeNode left) {
        this.left = left;
    }
    public TreeNode getRight() {
        return right;
    }
    public void setRight(TreeNode right) {
        this.right = right;
    }
}
