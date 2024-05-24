class Solution {
    int maxGold = 0;

    private void collectMaxGold( int[][] grid, int r, int c, int currentVal){
        if( r < 0 || c < 0 || r >= grid.length || c >= grid[0].length || grid[r][c] <= 0) return;
        currentVal += grid[r][c];
        maxGold = Math.max(currentVal, maxGold );
        grid[r][c] *= -1;

        collectMaxGold(grid, r - 1, c, currentVal);
        collectMaxGold(grid, r , c + 1, currentVal);
        collectMaxGold(grid, r , c - 1, currentVal);
        collectMaxGold(grid, r + 1, c, currentVal);
        grid[r][c] *= -1;
    }

    public int getMaximumGold(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] != 0 ) collectMaxGold(grid, i, j, 0);
            }
        }
        return maxGold;
    }

}