package day15;

import java.util.Arrays;

// 1584
public class MSTViaPrims {
    public static int minCostConnectPoints(int[][] points) {
        int n = points.length;
        boolean[] visited = new boolean[n];
        int[] minDist = new int[n];
        Arrays.fill(minDist, Integer.MAX_VALUE);
        minDist[0] = 0; // start from point 0
        int result = 0;
        for (int i = 0; i < n; i++) {
            int u = -1;
            for (int j = 0; j < n; j++)
                if (!visited[j] && (u == -1 || minDist[j] < minDist[u]))
                    u = j;
            visited[u] = true;
            result += minDist[u];
            for (int v = 0; v < n; v++) {
                if (!visited[v]) {
                    int dist = Math.abs(points[u][0] - points[v][0]) + 
                               Math.abs(points[u][1] - points[v][1]);
                    minDist[v] = Math.min(minDist[v], dist);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] points1 = {{0,0},{2,2},{3,10},{5,2},{7,0}};
        System.out.println(minCostConnectPoints(points1)); // 20

        int[][] points2 = {{3,12},{-2,5},{-4,1}};
        System.out.println(minCostConnectPoints(points2)); // 18
    }
}
