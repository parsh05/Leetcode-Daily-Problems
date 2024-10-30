class Solution {
    int lis(int[] arr, int i, int prevI, int[][] dp){
        if(i == arr.length) return 0;
        if(dp[i][prevI+1] != -1) return dp[i][prevI + 1];
        int include = 0, exclude = 0;
        if(prevI == -1 || arr[i] > arr[prevI] ){
            include = 1 +  lis(arr, i+1, i, dp);
            exclude = lis(arr, i + 1, prevI, dp);
        } else{
            exclude = lis(arr, i + 1, prevI, dp);
        }

        return dp[i][prevI+1] = Math.max(include, exclude);
    }
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n+1][n+1];
        for(int[] row : dp) Arrays.fill(row, -1);
        return lis(nums, 0, -1, dp);
    }
}