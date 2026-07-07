package day6;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreakViaDP {
    public static boolean breaks(String wrd,List<String> dt){
        Set<String> dicts = new HashSet<>(dt);
        int size=wrd.length();
        boolean[] dp = new boolean[size+1];
        dp[0]=true;
        for(int ind=1;ind<=size;ind++){
            for(int j=0;j<ind;j++){
                if(dp[j]){
                    String sub = wrd.substring(j,ind);
                    if(dicts.contains(sub))
                        {dp[ind]=true;break;}
                }
            }
        }
        return dp[size];
    }
    public static void main(String[] args) {
        System.out.println(breaks("leetcode", List.of("leet","code")));
        System.out.println(breaks("catsandog", List.of(
            "cats","sand","and","dog","cat"
        )));
    }
}
