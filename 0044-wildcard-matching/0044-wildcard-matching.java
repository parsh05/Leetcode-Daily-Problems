class Solution {
    boolean solve(String s, int i, String p, int j, Boolean[][] dp) {
        // Base case: If we've reached the end of the pattern
        if (j == p.length()) {
            return i == s.length(); // Return true only if the string is also fully matched
        }
        
        // Base case: If we've reached the end of the string but the pattern is not finished
        if (i == s.length()) {
            // Check if the remaining pattern is all '*' (which can match an empty sequence)
            for (int k = j; k < p.length(); k++) {
                if (p.charAt(k) != '*') return false;
            }
            return true;
        }

        // If result is already computed
        if (dp[i][j] != null) return dp[i][j];

        // Match current characters
        if (p.charAt(j) == '?' || s.charAt(i) == p.charAt(j)) {
            return dp[i][j] = solve(s, i + 1, p, j + 1, dp);
        }

        // If the current pattern character is '*'
        if (p.charAt(j) == '*') {
            // '*' can match zero or more characters
            return dp[i][j] = solve(s, i + 1, p, j, dp) || solve(s, i, p, j + 1, dp);
        }

        // Characters do not match
        return dp[i][j] = false;
    }

    public boolean isMatch(String s, String p) {
        int n = s.length(), m = p.length();
        Boolean[][] dp = new Boolean[n + 1][m + 1];
        return solve(s, 0, p, 0, dp);
    }
}
