package day6;

public class DecodeViaDP {
    public static int ways(String msg){
        if(msg==null||msg.length()==0) return 0;
        int size = msg.length(), ind=0, pair=0;
        int[] dp = new int[size+1];
        dp[0]=1;dp[1]=(msg.charAt(0)!='0')?1:0;
        for(int index=2;index<=size;index++){
            ind = msg.charAt(index-1)-'0';
            if(ind>=1&&ind<=9) dp[index]+=dp[index-1];
            String sub = msg.substring(index-2,index);
            pair = Integer.parseInt(sub);
            if(pair>=10&&pair<=26) dp[index]+=dp[index-2];
        }
        return dp[size];
    }
    public static void main(String[] args) {
        System.out.println(ways("226"));
        System.out.println(ways("602"));
        System.out.println(ways("72925"));
    }
}
