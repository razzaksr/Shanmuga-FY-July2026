package day5;

public class BusTrip {
    public static long minCount(int[] bus, int trip){
        long start=1, end = Long.MAX_VALUE, ans = 0, mid = 0;
        while(start<=end){
            mid=start+(end-start)/2;
            if(canComplete(bus, trip, mid))
            {end=mid-1;ans=mid;}
            else start=mid+1;
        }
        return ans;
    }
    public static boolean canComplete(int[] arr, 
        int trip, long mid){
        long sum=0;
        for(int each:arr){
            sum+=(mid/each);
            if(sum>=trip) return true;//
        }
        return sum>=trip;// 
    }
    public static void main(String[] args) {
        System.out.println(minCount(new int[]{1,2,3}, 5));
        System.out.println(minCount(new int[]{2,3,7}, 14));
    }
}
