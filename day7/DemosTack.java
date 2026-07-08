package day7;

import java.util.Stack;

public class DemosTack {
    public static void main(String[] args) {
        Stack<String> myTeam = new Stack<>();
        myTeam.push("Vetrikanth");
        myTeam.push("Dharun Prakash");
        myTeam.push("Selvarasan");
        myTeam.push("Viswak");
        System.out.println(myTeam.search("Selvarasan"));
        myTeam.pop();
        System.out.println(myTeam.peek());
        myTeam.clear();
        System.out.println(myTeam.isEmpty());
    }
}
