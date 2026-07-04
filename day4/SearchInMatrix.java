package day4;

public class SearchInMatrix {
    public static boolean bin(int[][] arr, int desired){
        int rSize = arr.length, cSize = arr[0].length;
        int start=0, end=rSize*cSize-1, mid=0, row=0, col=0;
        while(start<=end){
            mid = start+(end-start)/2;
            row=mid/cSize;col=mid%cSize;
            if(arr[row][col]==desired) return true;
            else if(arr[row][col]<desired)start=mid+1;
            else end=mid-1;
        }
        return false;
    }
    public static void main(String[] args) {
        System.out.println(bin(new int[][]{
            {1,3,5,7},{10,11,16,20},{23,30,34,60}
        }, 16));
    }
}
