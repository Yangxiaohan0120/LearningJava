package weekContest.Double128;

import java.util.Arrays;

public class Test03 {


    public int[] minimumTime(int n, int[][] edges, int[] disappear) {
        int[][] arr = new int[n][n];
        for (int[] row : arr) {
            Arrays.fill(row,-1);
        }
        for (int i = 0; i < edges.length; i++) {
            arr[edges[i][0]][edges[i][1]] = edges[i][2];
            arr[edges[i][1]][edges[i][0]] = edges[i][2];
        }
        int[] dis = new int[n];
        Arrays.fill(dis,0);
        for (int i = 1; i < dis.length; i++) {
            if(arr[0][i] != -1){
                dis[i] = arr[0][i];
                continue;
            }
            int min = Integer.MAX_VALUE;
            for (int j = 1; j < i; j++) {
                if(arr[0][j] != -1 && arr[j][i] != -1){
                    min = Math.min(min,arr[0][j] + arr[j][i]);
                }
            }
            if(arr[0][i] != -1){
                dis[i] = Math.min(arr[0][i],min);
            }else{
                dis[i] = min;
            }

        }
        for (int i = 0; i < dis.length; i++) {
            if(dis[i] > disappear[i]){
                dis[i] = -1;
            }
        }
        return dis;
    }



    public void test(){
        int n = 3;
        int[][] edges = {{0,1,2},{1,2,1},{0,2,4}};
        int[] disappear = {1,3,5};

        int[] res = minimumTime(n,edges,disappear);
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }
    }

    public static void main(String[] args) {
        new Test03().test();
    }
}
