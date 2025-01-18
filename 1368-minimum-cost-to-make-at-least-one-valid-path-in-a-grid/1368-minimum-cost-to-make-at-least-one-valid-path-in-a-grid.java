class Solution {
    
    int solve(int[][] grid, int i, int j, int[][] dp){
        if(i == grid.length-1 && j == grid[0].length-1) return 0;
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length){
            return Integer.MAX_VALUE/2;
        }
        if(grid[i][j] < 0) return Integer.MAX_VALUE/2;
        if(dp[i][j] != -1) return dp[i][j];

        int currDir = grid[i][j];

        // mark grid[i][j] as vis
        grid[i][j] *= -1;
        int[] dir = new int[4];

         dir[0] =  solve(grid, i, j+1, dp) + (Math.abs(grid[i][j]) == 1 ? 0 : 1); // right
         dir[1] = solve(grid, i, j-1, dp) + (Math.abs(grid[i][j]) == 2 ? 0 : 1); // left
         dir[2] = solve(grid, i+1, j, dp) + (Math.abs(grid[i][j]) == 3 ? 0 : 1); // down
         dir[3] = solve(grid, i-1, j, dp) + (Math.abs(grid[i][j]) == 4? 0 : 1);//up

        int min = Integer.MAX_VALUE;
        for(int k = 0; k < 4; k++){
            min = Math.min(min, dir[k]);
        }
        // mark unvisited
        grid[i][j] *= -1;
        return dp[i][j] = min;
    }
    public int minCost(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        int[][] dp = new int[n+1][m+1];
        for(int[] row : dp) Arrays.fill(row, -1);
        return solve(grid, 0, 0, dp);
    }
}