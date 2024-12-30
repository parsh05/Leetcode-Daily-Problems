class Solution {
    int maxSize ;
    int mod = (int)(1e9 + 7);
    int solve(int steps, int i, int[][] dp){
        if(i < 0 || i >= maxSize) return 0;
        if(steps == 0) return 1;
        if(dp[steps][i] != -1) return dp[steps][i];
        int right = solve(steps-1, i+1, dp);
        int stay = solve( steps-1, i, dp);
        int left = solve(steps-1, i-1, dp);
        return dp[steps][i] = ((right + left)% mod + stay)%mod;
    }
    public int numWays(int steps, int arrLen) {
        maxSize = Math.min(steps, arrLen );
        int[][] dp = new int[steps+1][maxSize];
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }

        return solve(steps-1, 0, dp);
    }
}