class Solution {
    private int solve(int[] arr, int n, int idx, int count, int[][][] dp){
        if(n == 0) {
            if(arr[idx] >= count) return 1;
            return 0;
        }
        if(arr[idx] < count) return 0;

        if(dp[n][idx][count] != -1) return dp[n][idx][count];
        int totalWays = 0;
        for(int i = 0; i < 6; i++){
            if(i == idx) totalWays = (totalWays + solve(arr, n-1, i, count+1, dp) )%mod ;
            else totalWays = (totalWays + solve(arr, n-1, i, 1, dp)) % mod;
        }
        return dp[n][idx][count] = totalWays;
    }
    int mod = (int)(1e9+7);
    public int dieSimulator(int n, int[] rollMax) {
        int[][][] dp = new int[n+1][6][16];
        for(int[][] row : dp) {
            for(int[] col : row) Arrays.fill(col, -1);
        }

        int totalWays = 0;
        for(int i = 0; i < 6; i++){
            totalWays = (totalWays + solve(rollMax, n-1, i, 1, dp)) % mod;
        }
        return totalWays;
    }
}