package day16;

public class MaxAreOfIsland {
    public static int dfs(int[][] grid, int row, int col){
        if(row<0||col<0||row>=grid.length||
            col>=grid[0].length||grid[row][col]==0) return 0;
        int count=1;
        grid[row][col]=0;
        count+=dfs(grid,row+1,col);count+=dfs(grid,row-1,col);
        count+=dfs(grid,row,col+1);count+=dfs(grid,row,col-1);
        return count;
    }
    public static int maxFind(int[][] grid){
        int oMax = Integer.MIN_VALUE, rSize = grid.length;
        int cSize = grid[0].length, cMax= Integer.MIN_VALUE;
        for(int row=0;row<rSize;row++){
            for(int col=0;col<cSize;col++){
                if(grid[row][col]==1){
                    cMax=dfs(grid,row,col);
                    oMax = Math.max(oMax, cMax);
                }
            }
        }
        return oMax;
    }
    public static void main(String[] args) {
        int[][] grid1 = {
            {1,0,0,0,0},{0,1,1,1,0},
            {1,0,1,0,0},{1,1,0,1,1},{1,1,1,1,1}
        };
        // System.out.println(maxFind(grid1));
        int[][] grid2 = {
            {0,0,1,0,0},
            {0,1,1,1,0},
            {1,0,1,0,0},
            {1,1,0,1,1}
        };
        System.out.println(maxFind(grid2));
    }
}
