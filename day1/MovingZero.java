package day1;

import java.util.Arrays;

class Alpha{
    public static void main(String[] args) {
        System.out.println("Hi there!");
    }
}

public class MovingZero {
    public static void react(int[] arr, int index, int correct){
        if(index==arr.length){
            Arrays.fill(arr, correct, arr.length, 0);
            return;
        }
        if(arr[index]!=0){
            arr[correct] = arr[index];
            correct++;
        }
        react(arr, index+1, correct);
    }
    public static void alter(int[] current){
        int index=0, correct=0, size = current.length;
        while(index<size){
            if(current[index]!=0){
                current[correct] = current[index];
                correct++;
            }
            index++;
        }
        Arrays.fill(current, correct,size,0);
    }
    public static void main(String[] args) {
        int[] arr1 = {0,1,0,3,12};
        int[] arr2 = {1,0,3,1,0,0,2};
        alter(arr1);
        alter(arr2);
        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));
    }
    public static void main(String args) {
        
    }
}
