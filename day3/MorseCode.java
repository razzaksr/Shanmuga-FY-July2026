package day3;

import java.util.HashSet;
import java.util.Set;

public class MorseCode {
    public static int count(String[] words){
        String[] codes = {
            ".-","-...","-.-.","-..",".","..-.","--.",
            "....","..",".---","-.-",".-..","--","-.",
            "---",".--.","--.-",".-.","...","-",
            "..-","...-",".--","-..-","-.--","--.."
        };
        String temp="";
        Set<String> set = new HashSet<>();// factory pattern
        // HashSet<String> set = new HashSet<>();// leagacy
        for(String each:words){
            temp="";
            for(char ch:each.toCharArray()) 
                temp+=codes[ch-'a'];
            set.add(temp);
        }
        return set.size();
    }
    public static void main(String[] args) {
        System.out.println(count(new String[]{"gin", "zen", "gig", "msg"}));
        System.out.println(count(new String[]{"a"}));
    }
}
