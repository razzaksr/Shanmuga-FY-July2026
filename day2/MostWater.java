package day2;

public class MostWater {
    public static int findMost(int[] arr){
        int left=0, right=arr.length-1, mWater = 0;
        while(left<right){
            int width = right-left;
            int height = Math.min(arr[left],arr[right]);
            mWater = Math.max(mWater, width*height);
            if(arr[left]<arr[right]) left++;
            else right--;
        }
        return mWater;
    }
    public static void main(String[] args) {
        int[] arr = {1,8,6,2,5,4,8,3,7};
        System.out.println(findMost(arr));
    }
}
