class Solution {
    int[] dr = { -1, 1, 0, 0};
    int[] dc = { 0, 0, -1, 1};
    void dfs(int[][] grid, int r, int c){
        int n = grid.length;
        int m = grid[0].length;


        grid[r][c] = -1;
        for(int i = 0; i < 4; i++){
            int nR = r + dr[i], nC = c + dc[i];
            if(nR < 0 || nR >= n || nC < 0 || nC >= m || grid[nR][nC] != 1) continue;

            dfs(grid, nR, nC);
        }

    }
    public int numEnclaves(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        // traverse every 1 of boundary and its connected components
        for(int i = 0; i < n; i++){
            if(grid[i][0] == 1) dfs(grid, i, 0);
            if(grid[i][m-1] == 1) dfs(grid,i, m-1);
        }
        for(int j = 0; j < m; j++){
            if(grid[0][j] == 1) dfs(grid, 0, j);
            if(grid[n-1][j] == 1) dfs(grid, n-1, j);
        }

        int count = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 1) count++;
                else if(grid[i][j] == -1) grid[i][j] = 1;
            }
        }
        return count;
    }
}