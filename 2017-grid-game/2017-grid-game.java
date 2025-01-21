class Solution {
    public long gridGame(int[][] grid) {
        int m = grid[0].length;
        long max = solve(grid);


        return max;


    }
    long solve(int[][] grid){
        long max = 0;
        int idx = 0;
        int m = grid[0].length;
        long[][] arr = new long[2][m+2];
        // prefix of 1st row
        for(int j = 0; j < m; j++){
            arr[0][j+1] = grid[0][j] + arr[0][j]; // shift j by 1 to right
            arr[1][j+1] = grid[1][j] + arr[1][j]; 
        }
       
        long ans = Long.MAX_VALUE;
        for(int j = 1; j <= m; j++){
            long temp = Math.max(arr[1][j-1], arr[0][m] - arr[0][j] );
            ans = Math.min(ans, temp);
        }
        return ans;
    }
}