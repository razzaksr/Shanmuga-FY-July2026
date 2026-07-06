package day5;

public class SumArrViaRecursion {
    public static int sum(int[] arr, int index){
        if(index==arr.length) return 0;
        return arr[index]+sum(arr,index+1);
    } 
    public static void main(String[] args) {
        System.out.println(sum(new int[]{1,2,3,4,5},0));
    }
}
