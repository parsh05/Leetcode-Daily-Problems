class Solution {
    public String shortestCommonSupersequence(String str1, String str2) {
        

        // calculate lcs
        int n1 = str1.length(), n2 = str2.length();
        int[][] dp = new int[n1+1][n2+1];

        for(int i = 1; i <= n1; i++){
            for(int j = 1; j <= n2; j++){
                if(str1.charAt(i-1) == str2.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                } else{
                    dp[i][j]= Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        int lcs = dp[n1][n2];

        // 
        StringBuilder s = new StringBuilder();
        int i = n1-1, j = n2-1;
        while(i >= 0 && j >= 0){
            if(str1.charAt(i) == str2.charAt(j)) {
                s.append(str1.charAt(i));
                i--;
                j--;
            } else{
                if(dp[i][j+1] > dp[i+1][j]){
                    s.append(str1.charAt(i));
                    i--;
                } else{
                     s.append(str2.charAt(j));
                    j--;
                }
            }
        }
        while(i >= 0) {
            s.append(str1.charAt(i));
            i--;
        }

        while(j >= 0){
            s.append(str2.charAt(j));
            j--;
        }
       return s.reverse().toString();
    }

    
}