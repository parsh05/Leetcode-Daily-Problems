import java.util.TreeMap;

class Solution {
    public long continuousSubarrays(int[] nums) {
        int l = 0, r = 0;
        long count = 0;
        TreeMap<Integer, Integer> freqMap = new TreeMap<>();

        while (r < nums.length) {
            // Add the current element to the frequency map
            freqMap.put(nums[r], freqMap.getOrDefault(nums[r], 0) + 1);

            // Check if the condition is violated
            while (freqMap.lastKey() - freqMap.firstKey() > 2) {
                // Remove the element at the left pointer
                freqMap.put(nums[l], freqMap.get(nums[l]) - 1);
                if (freqMap.get(nums[l]) == 0) {
                    freqMap.remove(nums[l]);
                }
                l++;
            }

            // Count subarrays ending at `r`
            count += r - l + 1;
            r++;
        }

        return count;
    }
}
