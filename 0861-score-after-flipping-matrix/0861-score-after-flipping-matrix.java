class Solution {
    public int matrixScore(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        for(int i = 0; i < m; i++){
            if( grid[i][0] == 0 ){
                flipRow(grid, i);
            }
        }
        for(int col = 1; col < n ; col++){
            int count0 = 0 ;
            for(int row = 0; row < m; row++) if(grid[row][col] == 0 ) count0++;

            int countOne = m - count0;
            if(count0 > countOne ) flipCol( grid, col);
        }
        int ans = 0;
        for( int row = 0; row < m; row++ ){
            int pow = 1;
            for( int col = n - 1 ; col >= 0; col--){
                ans += ( grid[row][col] * pow );
                pow *= 2;
            }
        }
        return ans;
    }
    private void flipRow(int [][]grid, int idx){
        for(int i = 0; i < grid[0].length; i++){
            grid[idx][i] = 1 - grid[idx][i];
        }
    }
    private void flipCol(int [][]grid, int idx){
        for(int i = 0; i < grid.length; i++){
            grid[i][idx] = 1 - grid[i][idx];
        }
    }
}