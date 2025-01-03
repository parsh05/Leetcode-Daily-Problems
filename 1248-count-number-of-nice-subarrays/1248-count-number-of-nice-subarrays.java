class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int n = nums.length;
        int[] freq = new int[n+2];

        freq[0] = -1;
        int count = 0;
        int ans = 0;
        for(int i = 0; i < n; i++){
            if(nums[i] % 2 == 1) {
                count++;
                freq[count] = i;
            }

            if(count - k < 0) continue;
            else ans += freq[count-k+1] - freq[count - k];
        }

        return ans;
    }
}