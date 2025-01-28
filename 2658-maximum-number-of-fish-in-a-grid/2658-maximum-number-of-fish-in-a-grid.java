class Solution {
    int max = 0;
    int[][] dir = { {1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    private int dfs(int[][]grid, int r, int c, int fish){
        
        fish += Math.abs(grid[r][c]);
        max = Math.max(fish, max);

        // mark visited
        grid[r][c] *= -1;

        for(int i = 0; i < 4; i++){
            int newR = r + dir[i][0];
            int newC = c + dir[i][1];

            if(newR < 0 || newC < 0 || newR >= grid.length || newC >= grid[0].length || grid[newR][newC] <= 0) continue;
            fish = dfs(grid, newR, newC, fish);
        }
        // grid[r][c] *= -1;
        return fish;
    }

    public int findMaxFish(int[][] grid) {
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] > 0) dfs(grid, i, j, 0);
            }
        }

        return max;
    }
}