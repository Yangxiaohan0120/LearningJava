package LCII;

/**
 * @ author: yxh
 * @ created: 2022-02-17 : 9:27 AM
 */
public class NumberofIslands {

    int[][] directions = {{-1,0},{0,1},{1,0},{0,-1}};
    boolean[][] visited;
    int m,n;

    public int numIslands(char[][] grid) {
        int res = 0;
        m = grid.length;
        if(m > 0){
            n = grid[0].length;
        }
        visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                visited[i][j] = false;
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(visited[i][j] == false && grid[i][j] == '1'){
                    res ++;
                    getIslands(grid,i,j,m,n);
                }
            }
        }

        return res;
    }


    private void getIslands(char[][] grid, int startx,int starty,int m,int n){

        visited[startx][starty] = true;
        for (int i = 0; i < directions.length; i++) {
            int newx = startx + directions[i][0];
            int newy = starty + directions[i][1];
            if(inArea(newx,newy,m,n) && grid[newx][newy] == '1' && !visited[newx][newy]){
                getIslands(grid,newx,newy,m,n);
            }
        }

        return;
    }

    private boolean inArea(int x,int y,int m,int n){
        return (x >= 0 && x < m && y >= 0 && y < n);
    }
}