class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) sum += num;

        // If sum is odd, we cannot partition it into two equal subsets
        if (sum % 2 == 1) return false;

        int target = sum / 2;
        Boolean[][] dp = new Boolean[nums.length][target + 1]; // Memoization table
        return solve(nums, 0, 0, target, dp);
    }

    boolean solve(int[] nums, int i, int currentSum, int target, Boolean[][] dp) {
        // Base cases
        if (currentSum == target) return true;
        if (i >= nums.length || currentSum > target) return false;

        // If already computed, return the stored result
        if (dp[i][currentSum] != null) return dp[i][currentSum];

        // Include the current element or skip it
        dp[i][currentSum] = solve(nums, i + 1, currentSum + nums[i], target, dp) ||
                            solve(nums, i + 1, currentSum, target, dp);
        return dp[i][currentSum];
    }
}
