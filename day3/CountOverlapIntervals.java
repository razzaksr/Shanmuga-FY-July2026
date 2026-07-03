package day3;

import java.util.Arrays;

public class CountOverlapIntervals{
    public static int find(int[][] intervals){
        Arrays.sort(intervals,(a,b)->a[1]-b[1]);
        int count = 0, cEnd = intervals[0][1];
        for(int index=1;index<intervals.length;index++){
            if(intervals[index][0]<cEnd) count++;
            else cEnd = intervals[index][1];
        }
        return count;
    }
    public static void main(String[] args) {
        int[][] testcase1 = {{1,2},{2,3},{3,4},{1,3}};
        int[][] testcase2 = {{1,2},{1,2},{1,2}};
        System.out.println(find(testcase1));
        System.out.println(find(testcase2));
    }
}