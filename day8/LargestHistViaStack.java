package day8;

import java.util.Stack;

public class LargestHistViaStack {
    public static int areaFind(int[] arr){
        int maxArea=0, temp=0;
        Stack<Integer> pos = new Stack<>();
        for(int index=0;index<=arr.length;index++){
            int cValue = (index==arr.length)?0:arr[index];
            while(!pos.isEmpty()&&cValue<arr[pos.peek()]){
                int len = arr[pos.pop()];
                int brd = pos.isEmpty()?
                        index:index-pos.peek()-1;
                temp = len*brd;
                maxArea = Math.max(maxArea, temp);
            }
            pos.push(index);
        }
        return maxArea;
    }
    public static void main(String[] args) {
        System.out.println(areaFind(new int[]{2,1,5,6,2,3}));
    }
}
