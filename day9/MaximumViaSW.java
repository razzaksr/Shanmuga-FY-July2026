package day9;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class MaximumViaSW {
    public static int[] maxFind(int[] nums, int k){
        int[] res = new int[nums.length-k+1];
        Deque<Integer> dq = new LinkedList<>();
        int j=0;
        for(int index=0;index<nums.length;index++){
            while(!dq.isEmpty()&&dq.peekFirst()<=index-k)
                dq.pollFirst();
            while(!dq.isEmpty()&&
                            nums[dq.peekLast()]<nums[index])
                dq.pollLast();
            dq.offer(index);
            if(index>=k-1)
                res[j++]=nums[dq.peekFirst()];
        }
        return res;
    }
    public static void main(String[] args) {
        int[] og = {1,3,-1,-3,5,3,6,7};
        int[] res = maxFind(og, 3);
        System.out.println(Arrays.toString(res));
    }
}
