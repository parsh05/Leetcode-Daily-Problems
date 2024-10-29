class Solution {
    public int maxMoves(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        int[][] dp = new int[n][m];
        
        // Initialize last column's moves to zero as there are no further moves possible.
        for (int i = 0; i < n; i++) {
            dp[i][m - 1] = 0;
        }
        
        // Fill dp array from the second-last column to the first
        for (int j = m - 2; j >= 0; j--) {
            for (int i = 0; i < n; i++) {
                int maxOpt = 0;

                // Move to top-right cell
                if (i > 0 && grid[i][j] < grid[i - 1][j + 1]) {
                    maxOpt = Math.max(maxOpt, 1 + dp[i - 1][j + 1]);
                }
                
                // Move to right cell
                if (grid[i][j] < grid[i][j + 1]) {
                    maxOpt = Math.max(maxOpt, 1 + dp[i][j + 1]);
                }
                
                // Move to bottom-right cell
                if (i < n - 1 && grid[i][j] < grid[i + 1][j + 1]) {
                    maxOpt = Math.max(maxOpt, 1 + dp[i + 1][j + 1]);
                }
                
                dp[i][j] = maxOpt;  // Set the maximum moves possible from this cell
            }
        }
        
        // Find the maximum moves starting from any cell in the first column
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, dp[i][0]);
        }
        return ans;
    }
}
