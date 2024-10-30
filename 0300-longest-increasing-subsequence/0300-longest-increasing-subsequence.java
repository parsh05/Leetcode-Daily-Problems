import java.util.Arrays;

class Solution {
    private int solve(int[] arr, int idx, int prevIdx, int[][] dp) {
        if (idx == arr.length) {
            return 0;
        }
        
        if (dp[idx][prevIdx + 1] != -1) {
            return dp[idx][prevIdx + 1];
        }

        // Option to exclude current element
        int exclude = solve(arr, idx + 1, prevIdx, dp);

        // Option to include current element if it forms an increasing sequence
        int include = 0;
        if (prevIdx == -1 || arr[idx] > arr[prevIdx]) {
            include = 1 + solve(arr, idx + 1, idx, dp);
        }

        // Memoize and return the maximum of including or excluding the element
        dp[idx][prevIdx + 1] = Math.max(include, exclude);
        return dp[idx][prevIdx + 1];
    }

    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][n + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return solve(nums, 0, -1, dp);
    }
}
