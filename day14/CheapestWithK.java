package day14;

import java.util.Arrays;

public class CheapestWithK {
    public static int findCheap(int n, int[][] flights,
        int src, int dest, int k){
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src]=0;
        for(int index=0;index<=k;index++){
            int[] copy = Arrays.copyOf(dist, n);
            for(int[] each:flights){
                int cS = each[0], cD=each[1], cost=each[2];
                if(dist[cS]!=Integer.MAX_VALUE&&
                    (dist[cS]+cost)<copy[cD])
                    copy[cD]=dist[cS]+cost;
            }
            dist=copy;
        }
        return dist[dest]!=Integer.MAX_VALUE?dist[dest]:-1;
    }
    public static void main(String[] args) {
        int[][] flights = {
            {0,1,100},{1,2,100},{2,0,100},
            {1,3,600},{2,3,200}
        };
        System.out.println(findCheap(4, flights, 0, 3, 1));
        System.out.println(findCheap(4, flights, 1, 3, 1));
    }
}
