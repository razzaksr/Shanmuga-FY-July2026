package day6;

import java.util.Arrays;

public class MergeSortViaDC {
    public static void conquer(int[] arr, int start,int mid, int end){
        int lSize=mid-start+1, rSize=end-mid;
        int[] lArr = new int[lSize];
        int[] rArr = new int[rSize];
        int left=0, right=0;
        while(left<lSize) 
            {lArr[left]=arr[left+start];left++;}
        while(right<rSize) 
            {rArr[right]=arr[mid+1+right];right++;}
        int index=start;left=0;right=0;
        while(left<lSize&&right<rSize){
            if(lArr[left]>rArr[right])
            {arr[index]=lArr[left];left++;}
            else{arr[index]=rArr[right];right++;}
            index++;
        }
        while(left<lSize)
            {arr[index]=lArr[left];left++;index++;}
        while(right<rSize)
            {arr[index]=rArr[right];right++;index++;}
    }
    public static void divide(int[] arr, int start, int end){
        if(start<end){
            int mid = start+(end-start)/2;
            divide(arr, start, mid);
            divide(arr, mid+1, end);
            conquer(arr, start, mid, end);
        }
    }
    public static void main(String[] args) {
        int[] numbers = {97,34,58,86,16};
        divide(numbers, 0, numbers.length-1);
        System.out.println(Arrays.toString(numbers));
    }
}
