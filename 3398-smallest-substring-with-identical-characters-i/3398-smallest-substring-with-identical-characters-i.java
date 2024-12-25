class Solution {
    public int minLength(String s, int numOps) {
        int n = s.length();
        int l = 1, r = n;
        while(l < r){
            int mid = (l + r)/2;
            if(minMoves(s, mid) > numOps){ // min no of moves to have greatest length = mid
                l = mid + 1;
            }else{
                r = mid;
            }
        }
        return l;
    }

    public int minMoves(String s, int maxLen){
        int n = s.length();
        int[][] dp = new int[maxLen + 1][2];
        for(int[] row : dp){
            Arrays.fill(row, n);
        }

        dp[0][0] = dp[0][1] = 0;

        for(char ch : s.toCharArray()){
            int curch = ch - '0';

            for(int i = maxLen; i >= 1; i--){
                for(int j = 0; j < 2; ++j){
                    dp[i][j] = dp[i-1][j] + (curch != j? 1 : 0);
                }
            }

            dp[0][0] = dp[0][1] = n;
            for(int i = 1; i <= maxLen; i++){
                for(int j = 0; j < 2; j++){
                    dp[0][j] = Math.min(dp[0][j], dp[i][1-j]);
                }
            }
        }

        int res = n; 
        for(int i = 0; i <= maxLen; i++){
            for(int j = 0; j < 2; j++){
                res = Math.min(res, dp[i][j]);
            }
        }
        return res;
    }
}