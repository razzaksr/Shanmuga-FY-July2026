package day5;

public class EliminationGame {
    public static int lastRem(int number){
        if(number==1) return 1;
        return 2*(1+number/2 - lastRem(number/2));
    }
    public static void main(String[] args) {
        System.out.println(lastRem(9));
        System.out.println(lastRem(1));
    }
}
