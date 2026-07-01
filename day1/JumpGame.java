package day1;

public class JumpGame {
    public static boolean isPossible(int[] arr){
        int maxLen=0, index=0, size=arr.length;
        while(index<size){
            if(index>maxLen)return false;
            maxLen= Math.max(maxLen, index+arr[index]);
            index++;
        }
        return true;
    }
    public static void main(String[] args) {
        int[] arr1 = {2,3,1,1,4};
        int[] arr2 = {3,2,1,0,4};
        System.out.println(isPossible(arr1));
        System.out.println(isPossible(arr2));
    }
}
