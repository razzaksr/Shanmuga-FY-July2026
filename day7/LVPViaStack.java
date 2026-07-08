package day7;

import java.util.Stack;

public class LVPViaStack {
    public static int findLen(String exp){
        Stack<Integer> stk = new Stack<>();
        stk.push(-1);
        int maxLen=0;
        for(int index=0;index<exp.length();index++){
            char cur = exp.charAt(index);
            if(cur=='(') stk.push(index);
            else{
                stk.pop();
                if(stk.isEmpty()) stk.push(index);
                maxLen = Math.max(maxLen, index-stk.peek());
            }
        }
        return maxLen;
    }
    public static void main(String[] args) {
        System.out.println(findLen("(()"));
        System.out.println(findLen(")()())"));
    }
}
