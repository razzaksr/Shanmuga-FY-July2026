package day8;

import java.util.Stack;

public class ReversePolishNotationViaStack {
    public static int evaluate(String[] exp){
        Stack<Integer> stk=new Stack<>();
        for(String tok:exp){
            if(tok.equals("+")||
            tok.equals("-")||
            tok.equals("*")||
            tok.equals("/")){
                int data2=stk.pop(), data1=stk.pop();
                switch(tok){
                    case "+": stk.push(data1+data2);break;
                    case "-": stk.push(data1-data2);break;
                    case "*": stk.push(data1*data2);break;
                    case "/": stk.push(data1/data2);break;
                }
            }
            else stk.push(Integer.parseInt(tok));
        }
        return stk.pop();
    }
    public static void main(String[] args) {
        System.out.println(evaluate(new String[]{
            "2","1","+","3","*"
        }));
        System.out.println(evaluate(new String[]{
            "4","13","5","/","+"
        }));
    }
}
