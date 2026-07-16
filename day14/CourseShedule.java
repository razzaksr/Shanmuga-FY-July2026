package day14;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// true if detect acyclic
public class CourseShedule {
    public static boolean canFinish(int n, int[][] pre){
        List<List<Integer>> graph = new ArrayList<>();
        for(int index=0;index<n;index++)
            graph.add(new ArrayList<>());
        int[] in = new int[n];
        for(int[] p:pre)
        {graph.get(p[1]).add(p[0]);in[p[0]]++;}
        Queue<Integer> que = new LinkedList<>();
        for(int index=0;index<n;index++)
            if(in[index]==0) que.offer(index);
        int count=0;
        while(!que.isEmpty()){
            int course = que.poll();
            count++;
            for(int nei:graph.get(course)){
                in[nei]--;
                if(in[nei]==0) que.offer(nei);
            }
        }
        return count==n;
    }
    public static void main(String[] args) {
        int[][] req= {{1,0}};
        System.out.println(canFinish(2, req));
        req = new int[][] {{1,0},{0,1}};
        System.out.println(canFinish(2, req));
        req = new int[][] {{1,0},{2,1},{2,0}};
        System.out.println(canFinish(3, req));
    }
}
