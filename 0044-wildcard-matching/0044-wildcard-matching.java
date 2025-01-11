class Solution {
    private boolean solve(String s, int i, String p, int j, Boolean[][] dp){
        if(j >= p.length() ){
            return i == s.length();
        }
        if(i >= s.length()){
            for(int k = j;  k < p.length(); k++){
                if(p.charAt(k) != '*') return false;
            }
            return true;
        }

        if(dp[i][j] != null ) return dp[i][j];

        if(p.charAt(j) == '?' || s.charAt(i) == p.charAt(j)){
            return dp[i][j] = solve(s, i+1, p, j+1, dp);
        }
        if(p.charAt(j) == '*'){
            return dp[i][j] = solve(s, i, p, j+1, dp) || solve(s, i+1, p, j, dp);
        }
        return dp[i][j] = false;

    }
    public boolean isMatch(String s, String p) {
        Boolean[][] dp = new Boolean[s.length()+1][p.length()+1];
        return solve(s, 0, p, 0, dp);
    }
}