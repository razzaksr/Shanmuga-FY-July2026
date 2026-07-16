package day14;

public class NumberOfProvince {
    public static int findCircle(int[][] grid){
        int size = grid.length, province=0;
        boolean[] visit = new boolean[size];
        for(int index=0;index<size;index++)
            if(!visit[index]){
                dfs(grid,visit,index);
                province++;
            }
        return province;
    }
    public static void dfs(int[][] grid,boolean[] visit,
        int cur){
        visit[cur]=true;
        for(int col=0;col<grid.length;col++)
            if(grid[cur][col]==1&&!visit[col])
                dfs(grid, visit, col);
    }
    public static void main(String[] args) {
        int[][] grids = {{1,1,0},{1,1,0},{0,0,1}};
        System.out.println(findCircle(grids));
        grids = new int[][] {{1,0,0},{0,1,0},{0,0,1}};
        System.out.println(findCircle(grids));
    }
}
