class Solution {
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        // Memoization table: dp[moves][i][j]
        int[][][] dp = new int[maxMove + 1][m][n];
        for (int[][] layer : dp) {
            for (int[] row : layer) {
                Arrays.fill(row, -1);
            }
        }
        return solve(startRow, startColumn, m, n, maxMove, dp);
    }

    private int solve(int i, int j, int m, int n, int remainingMoves, int[][][] dp) {
        // If out of bounds, it is one valid path
        if (i < 0 || i >= m || j < 0 || j >= n) return 1;

        // If no moves left, no paths are possible
        if (remainingMoves == 0) return 0;

        // Check if result is already computed
        if (dp[remainingMoves][i][j] != -1) return dp[remainingMoves][i][j];

        int mod = (int) (1e9 + 7);

        // Explore all possible directions
        int up = solve(i - 1, j, m, n, remainingMoves - 1, dp);
        int down = solve(i + 1, j, m, n, remainingMoves - 1, dp);
        int left = solve(i, j - 1, m, n, remainingMoves - 1, dp);
        int right = solve(i, j + 1, m, n, remainingMoves - 1, dp);

        // Store the result in dp and return
        dp[remainingMoves][i][j] = ((up + down) % mod + (left + right) % mod) % mod;
        return dp[remainingMoves][i][j];
    }
}
