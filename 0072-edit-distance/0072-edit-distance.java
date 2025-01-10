class Solution {
    int solve(String w1, int i, String w2, int j, int[][] dp) {
        if (i < 0)
            return j+1;
        if (j < 0)
            return i + 1;

        if(dp[i][j] != -1) return dp[i][j];

        if (w1.charAt(i) == w2.charAt(j)) {
            dp[i][j] = solve(w1, i-1, w2, j - 1, dp);
        } else {
            dp[i][j] = 1
                    + Math.min(solve(w1, i - 1, w2, j - 1, dp), 
                    Math.min(solve(w1, i - 1, w2, j, dp), solve(w1, i, w2, j - 1, dp)));
        }
        return dp[i][j];
    }

    public int minDistance(String word1, String word2) {
        int n1 = word1.length(), n2 = word2.length();
        if(n1 == 0) return n2;
        int[][] dp = new int[n1][n2];
        for(int i = 0; i < dp.length; i++){
            for(int j = 0; j < dp[0].length; j++){
                dp[i][j] = -1;
            }
        }
        return solve(word1, n1-1, word2, n2-1, dp);
    }
}