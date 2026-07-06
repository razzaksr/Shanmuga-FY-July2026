package day5;

public class ClimbViaRecursion {
    public static int count(int stairs){
        if(stairs==1) return 1;
        if(stairs==2) return 2;
        else return count(stairs-1)+count(stairs-2);
    }
    public static void main(String[] args) {
        System.out.println(count(8));
    }
}
