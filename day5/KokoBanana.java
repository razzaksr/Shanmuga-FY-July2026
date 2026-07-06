package day5;

import java.util.Arrays;

public class KokoBanana {
    public static int minSpeed(int[] arr, int hours){
        int start=1, end=Arrays.stream(arr).
        max().orElse(0);
        int mid=0;
        while(start<=end){
            mid=start+(end-start)/2;
            if(canEat(arr, hours, mid)) end=mid-1;
            else start=mid+1;
        }
        return start;
    }
    public static boolean canEat(int[] arr, int hours,
         int mid){
        long curHours = 0;
        for(int each:arr) curHours += (each+mid-1)/mid;
        return curHours<=hours;
    }
    public static void main(String[] args) {
        System.out.println(minSpeed(new int[]{3,6,7,11}, 8));
    }
}
