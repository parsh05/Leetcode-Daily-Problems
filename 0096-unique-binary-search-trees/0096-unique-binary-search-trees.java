class Solution {
    int[] dp ;
    int solve(int n){
        if(n <= 1) return 1;
        if(dp[n] != -1) return dp[n];
        int ways = 0;
        for(int i = 1; i <= n; i++){
            ways += solve(i-1) * solve(n-i);
        }
        return dp[n] = ways;
    }
    public int numTrees(int n) {
        dp = new int[n+1];
        Arrays.fill(dp, -1);
        return solve(n);
    }
}