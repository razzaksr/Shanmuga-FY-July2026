package day6;

import java.util.Arrays;

public class CoinChangeViaDP {
    public static int dispense(int[] den,int req){
        int def = req+1;
        int[] dp = new int[def];
        Arrays.fill(dp, def);
        dp[0]=0;
        for(int cur:den){
            for(int index=cur;index<def;index++)
                dp[index] = Math.min(dp[index], 1+dp[index-cur]);
        }
        return (dp[req]<req)?dp[req]:-1;
    }
    public static void main(String[] args) {
        int[] denom = {100,200,500};
        System.out.println(dispense(denom, 300));
        System.out.println(dispense(denom, 600));
        System.out.println(dispense(denom, 1350));
        System.out.println(dispense(denom, 2500));
        System.out.println(dispense(denom, 1));
    }
}
