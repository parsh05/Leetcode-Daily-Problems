import java.util.Arrays;

class Solution {

    int solve(int[][] coins, int i, int j, int allowed, int[][][] dp) {
        int n = coins.length;
        int m = coins[0].length;

        // Base cases
        if (i >= n || j >= m || allowed < 0) {
            return Integer.MIN_VALUE / 2;
        }

        // If we reach the bottom-right cell
        if (i == n - 1 && j == m - 1) {
            if (coins[i][j] >= 0) {
                return coins[i][j];
            }
            return (allowed > 0) ? 0 : coins[i][j];
        }

        // Check if the result is already computed
        if (dp[i][j][allowed] != -1) {
            return dp[i][j][allowed];
        }

        // Recursively compute the values for moving down and right
        int down = solve(coins, i + 1, j, allowed, dp);
        int right = solve(coins, i, j + 1, allowed, dp);

        // If current cell value is non-negative
        if (coins[i][j] >= 0) {
            return dp[i][j][allowed] = Math.max(down + coins[i][j], right + coins[i][j]);
        } else {
            // Handle negative cell value
            int downWithNegation = solve(coins, i + 1, j, allowed - 1, dp);
            int rightWithNegation = solve(coins, i, j + 1, allowed - 1, dp);

            return dp[i][j][allowed] = Math.max(
                Math.max(down + coins[i][j], right + coins[i][j]),
                Math.max(downWithNegation, rightWithNegation)
            );
        }
    }

    public int maximumAmount(int[][] coins) {
        int[][][] dp = new int[coins.length][coins[0].length][3];

        // Initialize the dp array with -1
        for (int[][] row : dp) {
            for (int[] col : row) {
                Arrays.fill(col, -1);
            }
        }

        // Start solving from the top-left corner with 2 allowed negations
        return solve(coins, 0, 0, 2, dp);
    }
}
