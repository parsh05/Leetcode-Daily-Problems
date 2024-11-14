class Solution {
    public long countFairPairs(int[] arr, int lower, int upper) {
        long ans = 0;
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            int left = Arrays.binarySearch(arr, lower - arr[i]);
            if (left < 0) left = -left - 1;  // Adjust to insertion point if not found
            if (left <= i) left = i + 1;    // Ensure j > i

            int right = Arrays.binarySearch(arr, upper - arr[i]);
            if (right < 0) right = -right - 1;
            else right += 1;  // Include the exact match

            if (right > i && left < arr.length) {
                ans += Math.max(0, right - left);
            }
        }
        return ans;
    }
}
