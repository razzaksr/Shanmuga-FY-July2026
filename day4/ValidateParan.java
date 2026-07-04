package day4;

public class ValidateParan {
    public static boolean isValid(String expression){
        int opened=0, closed=0;
        char[] brackets = expression.toCharArray();
        for(char each:brackets){
            if(each=='('){
                opened++; closed++;
            }else if(each==')'){
                if(opened>0) opened--;
                closed--;
            }
            else{
                if(opened>0) opened--;
                closed++;
            }
            if(closed<0) return false;
        }
        return opened==0;
    }
    public static void main(String[] args) {
        System.out.println(isValid("()()()"));
        System.out.println(isValid("(*)"));
        System.out.println(isValid("(*))"));
        System.out.println(isValid("(()"));
    }
}
