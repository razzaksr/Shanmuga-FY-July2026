package day16;

public class BattleShip {
    public static int find(char[][] grid){
        int rSize = grid.length, cSize = grid[0].length;
        int count=0;
        for(int row=0;row<rSize;row++){
            for(int col=0;col<cSize;col++){
                if(grid[row][col]!='X') continue;
                if(row>0&&grid[row-1][col]=='X') continue;
                if(col>0&&grid[row][col-1]=='X') continue;
                count++;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        char[][] grid1={
            {'X','.','.','X'},
            {'.','.','.','X'},
            {'.','.','.','X'}
        };
        // System.out.println(find(grid1));
        char[][] grid2={
            {'X','X','X','X'},
            {'.','X','.','X'},
            {'X','.','.','.'},
            {'X','X','X','X'}
        };
        System.out.println(find(grid2));
    }
}
