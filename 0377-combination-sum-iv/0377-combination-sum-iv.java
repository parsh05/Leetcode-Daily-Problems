class Solution {
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        Arrays.fill(dp, -1);
        return countWays(nums, target, dp);
    }

    private int countWays(int[] nums, int target, int[] dp) {
        if (target == 0) return 1; // Base case: Found a combination
        if (target < 0) return 0;  // Invalid case: Overshot the target

        if (dp[target] != -1) return dp[target]; // Return memoized result

        int ways = 0;
        for (int num : nums) {
            ways += countWays(nums, target - num, dp);
        }

        dp[target] = ways;
        return ways;
    }
}
