package day9;

import java.util.Hashtable;

public class LongSubStrWTRepeatViaSW {
    public static int subStr(String s){
        int size=s.length(),start=0, end=0,maxLen=0;
        Hashtable<Character,Integer> tab=new Hashtable<>();
        while(end<size){
            char key=s.charAt(end);
            if(tab.containsKey(key))
                start=Math.max(start, tab.get(key)+1);
            tab.put(key, end);
            maxLen=Math.max(maxLen, end-start+1);
            end++;
        }
        return maxLen;
    }
    public static void main(String[] args) {
        System.out.println(subStr("abcabcbb"));
    }
}
