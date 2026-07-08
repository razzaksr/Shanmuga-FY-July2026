package day7;

public class LCSViaDP {
    public static int seqFind(String word1,String word2){
        int rSize= word1.length(),cSize=word2.length();
        int[][] dp=new int[rSize+1][cSize+1];
        for(int row=1;row<=rSize;row++)
            for(int col=1;col<=cSize;col++)
                if(word1.charAt(row-1)==word2.charAt(col-1))
                    dp[row][col]=dp[row-1][col-1]+1;
                else
                    dp[row][col]=Math.max(dp[row-1][col], dp[row][col-1]);
        return dp[rSize][cSize];
    }
    public static void main(String[] args) {
        System.out.println(seqFind("abcde", "ace"));
        System.out.println(seqFind("ezupkr", "ubmrapg"));
    }
}
