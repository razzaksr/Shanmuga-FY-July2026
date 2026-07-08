package day7;

public class EditDistanceViaDP {
    public static int minFind(String w1, String w2){
        int rSize=w1.length(), cSize=w2.length();
        int[][] dp = new int[rSize+1][cSize+1];
        for(int col=0;col<=cSize;col++) dp[0][col]=col;
        for(int row=0;row<=rSize;row++) dp[row][0]=row;
        for(int row=1;row<=rSize;row++)
            for(int col=1;col<=cSize;col++)
                if(w1.charAt(row-1)==w2.charAt(col-1))
                    dp[row][col]=dp[row-1][col-1];
                else
                    dp[row][col]=1+Math.min(dp[row-1][col],
                    Math.min(dp[row][col-1],dp[row-1][col-1]));
        return dp[rSize][cSize];
    }
    public static void main(String[] args) {
        System.out.println(minFind("horse", "ros"));
        System.out.println(minFind("horse", "rose"));
        System.out.println(minFind("intention", "execution"));
    }
}