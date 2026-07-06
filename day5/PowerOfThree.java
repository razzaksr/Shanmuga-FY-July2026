package day5;

public class PowerOfThree {
    public static boolean isDiv(int number){
        if(number<=0) return false;
        if(number==1) return true;
        if(number%3!=0) return false;
        return isDiv(number/3);
    }
    public static void main(String[] args) {
        System.out.println(isDiv(27));
        System.out.println(isDiv(0));
        System.out.println(isDiv(-1));
    }
}
