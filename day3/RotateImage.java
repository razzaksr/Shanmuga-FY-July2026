package day3;

import java.util.Arrays;

public class RotateImage {
    public static void rotate(int[][] arr){
        // transpose
        for(int row=0;row<arr.length;row++){
            for(int col=row+1;col<arr.length;col++){
                arr[row][col] ^= arr[col][row];
                arr[col][row] ^= arr[row][col];
                arr[row][col] ^= arr[col][row];
            }
        }
        // reverse
        for(int row=0;row<arr.length;row++){
            int left=0, right=arr[row].length-1;
            while(left<right){
                arr[row][left] ^= arr[row][right];
                arr[row][right] ^= arr[row][left];
                arr[row][left] ^= arr[row][right];
                left++;right--;
            }
        }
    }
    public static void main(String[] args) {
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        rotate(matrix);
        for(int row=0;row<matrix.length;row++){
            System.out.println(Arrays.toString(matrix[row]));
        }
    }
}
