class Solution {
    int lis(int[] arr, int i, int prevI, int[][] dp) {
        if (i == arr.length)
            return 0;
        if (dp[i][prevI + 1] != -1)
            return dp[i][prevI + 1];
        int include = 0, exclude = 0;
        if (prevI == -1 || arr[i] > arr[prevI]) {
            include = 1 + lis(arr, i + 1, i, dp);
            exclude = lis(arr, i + 1, prevI, dp);
        } else {
            exclude = lis(arr, i + 1, prevI, dp);
        }

        return dp[i][prevI + 1] = Math.max(include, exclude);
    }

    // public int lengthOfLIS(int[] arr) {
    //     int n = arr.length;
    //     int[][] dp = new int[n + 1][n + 1];
    //     for (int[] row : dp)
    //         Arrays.fill(row, 0);
    //     for (int i = n - 1; i >= 0; i--) {
    //         for (int prevI = i - 1; prevI >= -1; prevI--) {
    //             int include = 0, exclude = 0;
    //             if (prevI == -1 || arr[i] > arr[prevI]) {
    //                 include = 1 + dp[i+1][i+1];
    //             }
    //                 exclude = dp[i+1][prevI+1];
    //             dp[i][prevI + 1] = Math.max(include, exclude);
    //         }
    //     }
    //     return dp[0][-1 + 1];
    // }

    public int lengthOfLIS(int[] arr) {
        int n = arr.length;
        // int[][] dp = new int[n + 1][n + 1];
        int[] prev = new int[n+1];
        int[] curr = new int[n+1];
       
        for (int i = n - 1; i >= 0; i--) {
            for (int prevI = i - 1; prevI >= -1; prevI--) {

                int include = 0, exclude = 0;
                if (prevI == -1 || arr[i] > arr[prevI]) {
                    include = 1 + prev[i + 1];
                }
                    exclude = prev[prevI + 1];
                curr[prevI + 1] = Math.max(include, exclude);
                
            }
            int[] temp = prev;
                prev = curr;
                curr = temp;
                // Arrays.fill(curr, 0);
        }
        return prev[-1 + 1];
    }
}