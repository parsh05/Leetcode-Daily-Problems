class Solution {
    int solve(String s, int i, String t, int j, Integer[][] dp){
        if(j >= t.length()) return 1;
        if(i >= s.length()) return 0;

        if(dp[i][j] != null) return dp[i][j];
        int skip = solve(s, i+1, t, j, dp);
        int take = 0;
        if(s.charAt(i) == t.charAt(j)){
             take = solve(s, i+1, t, j+1, dp);
        }
        return dp[i][j] = skip + take;
    }

    public int numDistinct(String s, String t) {
        int n = s.length(), m = t.length();
        Integer[][] dp = new Integer[n+1][m+1];
        return solve(s, 0, t, 0, dp);
    }
}