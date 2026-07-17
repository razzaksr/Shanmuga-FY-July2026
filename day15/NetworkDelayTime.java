package day15;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class NetworkDelayTime {
    static Map<Integer,List<int[]>> graph = 
        new HashMap<>();
    static PriorityQueue<int[]> pq=new PriorityQueue<>(
        Comparator.comparingInt(a->a[1])
    );
    public static int delayTime(int[][] grid, int n, int k){
        for(int[] row:grid)
            graph.computeIfAbsent(row[0], pair->new ArrayList<>())
                .add(new int[]{row[1],row[2]});
        pq.offer(new int[]{k,0});
        Map<Integer,Integer> dist=new HashMap<>();
        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            int node = cur[0], time=cur[1];
            if(dist.containsKey(node)) continue;
            dist.put(node,time);
            if(graph.containsKey(node)){
                for(int[] nei:graph.get(node)){
                    int next = nei[0], wt=nei[1];
                    if(!dist.containsKey(next))
                        pq.offer(new int[]{next,time+wt});
                }
            }
        }
        if(dist.size()!=n) return -1;
        return Collections.max(dist.values());
    }
    public static void main(String[] args) {
        int[][] grid={{2,1,1},{2,3,1},{3,4,1}};
        // System.out.println(delayTime(grid, 4, 2));
        grid=new int[][]{{1,2,1}};
        System.out.println(delayTime(grid, 2, 1));
    }
}
