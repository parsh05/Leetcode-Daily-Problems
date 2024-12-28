
class Solution {
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int n = nums.length;

        // Step 1: Compute the window sums of size `k`
        int[] sum = new int[n - k + 1];
        int winSum = 0;
        for (int i = 0; i < n; i++) {
            winSum += nums[i];
            if (i >= k - 1) {
                sum[i - k + 1] = winSum;
                winSum -= nums[i - k + 1];
            }
        }

        // Step 2: Arrays to store best indices for subarrays
        int[] left = new int[n - k + 1];
        int[] right = new int[n - k + 1];

        // Fill the `left` array (best starting index for 1st subarray up to index i)
        int bestLeft = 0;
        for (int i = 0; i < sum.length; i++) {
            if (sum[i] > sum[bestLeft]) bestLeft = i;
            left[i] = bestLeft;
        }

        // Fill the `right` array (best starting index for 3rd subarray from index i onward)
        int bestRight = sum.length - 1;
        for (int i = sum.length - 1; i >= 0; i--) {
            if (sum[i] >= sum[bestRight]) bestRight = i;
            right[i] = bestRight;
        }

        // Step 3: Find the best middle subarray with maximum total sum
        int[] ans = new int[3];
        int maxSum = 0;

        for (int mid = k; mid < sum.length - k; mid++) {
            int l = left[mid - k];      // Best left subarray
            int r = right[mid + k];    // Best right subarray
            int totalSum = sum[l] + sum[mid] + sum[r];
            if (totalSum > maxSum) {
                maxSum = totalSum;
                ans[0] = l;
                ans[1] = mid;
                ans[2] = r;
            }
        }

        return ans;
    }
}
