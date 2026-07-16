package day14;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ValidGraphPath {
    private List<List<Integer>> adj = new ArrayList<>();
    private boolean[] isVisited;
    public void buildAdjancency(int[][] edges){
        for(int index=0;index<isVisited.length;index++)
            adj.add(new ArrayList<>());
        for(int[] each:edges){
            adj.get(each[0]).add(each[1]);
            adj.get(each[1]).add(each[0]);
        }
    }
    public boolean bfs(int src, int dest){
        Queue<Integer> que = new LinkedList<>();
        que.offer(src);isVisited[src]=true;
        while (!que.isEmpty()) {
            int node = que.poll();
            if(node==dest) return true;
            for(int nei:adj.get(node)){
                if(!isVisited[nei])
                {isVisited[nei]=true;que.offer(nei);}
            }
        }
        return false;
    }
    public boolean dfs(int cur, int dest){
        if(cur==dest) return true;
        isVisited[cur]=true;
        for(int nei:adj.get(cur))
            if(!isVisited[nei]&&dfs(nei,dest)) 
                return true;
        return false;
    }
    public boolean isValidPath(int n, int[][] edges,int src,int dest){
        isVisited = new boolean[n];
        buildAdjancency(edges);
        // return bfs(src,dest);
        return dfs(src,dest);
    }
    public static void main(String[] args) {
        ValidGraphPath grpah = new ValidGraphPath();
        int[][] edges = {{0,1},{1,2},{2,0}};
        System.out.println(
            grpah.isValidPath(3, edges, 0, 2));
        edges = new int[][] {{0,1},{0,2},{3,5},{5,4},{4,3}};
        System.out.println(
            grpah.isValidPath(6, edges, 0, 5));
    }
}
