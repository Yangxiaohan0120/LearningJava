package DataStructureAndAlgorithm.algorithm;

import java.util.HashMap;

/**
 * @ author: yxh
 * @ created: 2022-02-19 : 2:59 PM
 */
public class Dijkstra {

    boolean[] visited;
    int[] w;

    public int findPath(int[][] weights, int start) {
        visited = new boolean[weights.length];
        w = new int[weights.length];
        for (int i = 0; i < visited.length; i++) {
            visited[i] = false;
            w[i] = weights[start][i];
        }

        for (int i = 0; i < start; i++) {
            
        }

        int node = findlowestWay(0);
        while (!visited[node]){
            int costs = w[node];
            for (int i = 0; i < weights.length; i++) {
                if(weights[node][i] != -1){
                    int newcost = costs + weights[node][i];
                    if(newcost < costs){
                        w[node] = newcost;
                    }
                }
            }
            node = findlowestWay(costs);
        }

        return 1;
    }

    private int findlowestWay(int costs) {
        int index = 0;
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < w.length; i++) {
            if(w[i] < costs){
                res = costs;
                index = i;
            }
        }
        return index;
    }

}