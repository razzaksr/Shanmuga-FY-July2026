package day1;

import java.util.Arrays;

public class ValidAnagram{
    public static boolean validate(String src, String comp){
        // if(src.length()!=comp.length()) return false;
        // int[] count =new int[26];
        // src.chars().forEach(each->count[each-'a']++);
        // comp.chars().forEach(each->count[each-'a']--);
        // return Arrays.stream(count).allMatch(value->value==0);
        if(src.length()!=comp.length()) return false;
        // return Arrays.equals(
        //     src.chars().sorted().toArray(),
        //     comp.chars().sorted().toArray()
        // );
        char[] srcArr = src.toCharArray();
        char[] compArr = comp.toCharArray();
        Arrays.sort(srcArr);
        Arrays.sort(compArr);
        return Arrays.equals(
            srcArr, compArr
        );
    }

    public static void main(String[] args) {
        System.out.println(validate("anagram", "nagaram"));
        System.out.println(validate("ant", "tan"));
        System.out.println(validate("madam", "mam"));
    }
}