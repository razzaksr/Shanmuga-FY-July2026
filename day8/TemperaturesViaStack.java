package day8;

import java.util.Arrays;
import java.util.Stack;

public class TemperaturesViaStack {
    public static int[] warmFind(int[] arr){
        int[] res = new int[arr.length];
        Stack<Integer> pos = new Stack<>();
        for(int index=0;index<arr.length;index++){
            while(!pos.isEmpty()&&
                    arr[pos.peek()]<arr[index]){
                int popped = pos.pop();
                res[popped] = index-popped;
            }
            pos.push(index);
        }
        return res;
    }
    public static void main(String[] args) {
        int[] received = warmFind(new int[]{73,74,75,71,69,72,76,73});
        System.out.println(Arrays.toString(received));
    }
}
