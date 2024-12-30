class Solution {
    int[][] moves = {{-2, -1}, {-2, 1}, {-1, -2}, {-1, 2}, {1, -2}, {1, 2}, {2, -1}, {2, 1}};
    int mod = (int)(1e9 + 7);
    private int solve(int r, int c, int n, int[][][] dp){
        if(r < 0 || c < 0 || r >= 4 || c >= 3) return 0;
        if(r == 3 && (c == 0 || c == 2)) return 0;
        if(n == 0) return dp[r][c][n] = 1;
        if(dp[r][c][n] != -1) return dp[r][c][n];

        int count = 0;
        for(int[] move : moves ){
            int newRo = r + move[0], newCo = c + move[1];
            count = (count + solve(newRo, newCo, n-1, dp)) % mod;
        }
        return dp[r][c][n] = count % mod;
    }

    public int knightDialer(int n) {
        int[][][] dp = new int[4][3][n];
        for(int[][] row : dp){
            for(int[] col : row){
                Arrays.fill(col, -1);
            }
        }
        int moves = 0;
        for(int r = 0; r < 4; r++){
            for(int c = 0; c < 3; c++){
                moves = (moves + solve(r, c, n-1, dp)) % mod;
            }
        }
        return moves;
    }
}