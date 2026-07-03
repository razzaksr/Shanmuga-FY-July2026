package day3;

import java.util.Arrays;

public class MeetingRoom {
    public static boolean meet(int[][] arr){
        Arrays.sort(arr,(a,b)->a[0]-b[0]);
        for(int index=1;index<arr.length;index++){
            if(arr[index][0]<arr[index-1][1]) return false;
        }
        return true;
    }
    public static void main(String[] args) {
        int[][] meetings1 = {{0, 30}, {5, 10}, {15, 20}};
        System.out.println(meet(meetings1));
        int[][] meetings2 = {{7, 10}, {2, 4}};
        System.out.println(meet(meetings2));
    }
}
