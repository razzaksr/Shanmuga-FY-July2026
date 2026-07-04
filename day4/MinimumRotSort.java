package day4;

public class MinimumRotSort {
    public static int findMin(int[] arr){
        int start=0, end=arr.length-1, mid=0;
        while(start<end){
            mid=start+(end-start)/2;
            if(arr[mid]>arr[end]) start=mid+1;
            else end=mid;
        }
        return arr[start];
    }
    public static void main(String[] args) {
        System.out.println(findMin(new int[]{3,4,5,1,2}));
    }
}
