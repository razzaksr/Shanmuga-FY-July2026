package day1;

import java.util.Arrays;
// https://github.com/razzaksr/Shanmuga-FY-July2026
public class SortColors {
    public static void dutchFlag(int[] arr){
        int start=0,end=arr.length-1,index=0;
        while(index<=end){
            if(arr[index]==2){
                int third = arr[end];
                arr[end] = arr[index];
                arr[index] = third;
                end--;
            }
            else if(arr[index]==0){
                int first = arr[start];
                arr[start] = arr[index];
                arr[index] = first;
                start++;index++;
            }
            else index++;
        }
    }
    public static void main(String[] args) {
        int[] arr1 = {2,0,2,1,1,0};
        int[] arr2 = {2,0,1};
        dutchFlag(arr1);
        dutchFlag(arr2);
        for(int each:arr1) System.out.print(each+" ");
        System.out.println();
        System.out.println(Arrays.toString(arr2));
    }
}
