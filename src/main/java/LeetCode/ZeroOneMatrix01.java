package LeetCode;

import Utils.printUtils;

import java.util.ArrayDeque;
import java.util.Deque;

import static java.lang.Boolean.TRUE;

/**
 * @author Chris Yang
 * created 2022-04-06 20:20
 **/

// 0\1 组成的矩阵，输出每个单位到最近的0的距离，相邻两个单位的距离为1

// 示例 1
// 0 0 0
// 0 1 0
// 1 1 1

// 解答 1
// 0 0 0
// 0 1 0
// 1 2 1
public class ZeroOneMatrix01 {
    int[][] dirs = new int[][] {{0,1},{1,0},{-1,0},{0,-1}};
    public int[][] updateMatrix(int[][] mat) {

        // Initialize the dimension of the input/output array
        int m = mat.length;
        int n = mat[0].length;

        int[][] res = new int[m][n];

        // Initialize boolean array to truck whether point
        // Has been seen or not
        boolean[][] visited = new boolean[m][n];

        // Initialize queue for BFS
        Deque<Integer[]> queue = new ArrayDeque<Integer[]>();

        // Loop through the entire input
        // 找到所有的0
        for (int i = 0; i < m; i++){
            for(int j = 0; j< n; j++){

                // Use reverse thinking and seek for 0
                if(mat[i][j] == 0){

                    // If found an 0 add to the queue
                    // And label as seen
                    queue.add(new Integer[] {i,j});
                    visited[i][j] = TRUE;
                }
            }
        }

        // Initialize the cost to 0
        int cost = 0;
        while (!queue.isEmpty()){

            // Size of queue indicates how many points in this layer
            int size = queue.size();

            // Loop through each node inside layer
            for(int s = 0; s < size; s++){

                // Pop the first node in line
                Integer[] cur = queue.pop();

                // Read its coordinates
                int i = cur[0];
                int j = cur[1];

                // If it is a one, update the answer to the current layer cost
                // 0本层都为0
                if (mat[i][j] == 1){
                    res[i][j] = cost;
                }

                // Loop through it's surrounding neighbours
                // Using the predefined direction array
                // 以0为中心向四个方向扩展
                for (int[] dir:dirs){

                    // Find the coordinate for each neighbour
                    int x = i + dir[0];
                    int y = j + dir[1];

                    // If the coordinate is still within the input dimension
                    // And it has not been visited previously
                    if (x >= 0 && x < m && y >= 0 && y < n && !visited[x][y]){

                        // Add that point to queue and inform boolean visited
                        queue.add(new Integer[] {x,y}); // 加入新的位置，并且设置访问过
                        visited[x][y] = TRUE;
                    }
                }
            }
            // 先循环所有的0
            // 再循环第一层
            // 再循环第二层
            cost++;
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] mat = {{0, 0, 0}, {0, 1, 0}, {1, 1, 1}};
        int[][] dis = new ZeroOneMatrix01().updateMatrix(mat);
        printUtils.print(dis);
    }
}
