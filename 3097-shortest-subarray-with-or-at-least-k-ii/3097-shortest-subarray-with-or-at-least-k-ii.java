class Solution {
    public int minimumSubarrayLength(int[] nums, int k) {
        int[] bits = new int[32];
        // fill total no. of bits at each bit
        // for(int num : nums){
        // int mask = 1;
        // for(int i = 0; i < 32; i++){
        // if(num & mask != 0) bits[i]++;
        // mask *= 2;
        // }
        // }

        int l = 0, r = 0;
        int or = 0;
        int ans = Integer.MAX_VALUE;
        while (r < nums.length) {
            or |= nums[r];
            updateBits(bits, nums[r], 1);

            while (l<= r && or >= k) {
                ans = Math.min(ans, r - l + 1);
                // remove effect of l on bits
                updateBits(bits, nums[l], -1);
                or = updateOr(bits);
                l++;
            }
            r++;
        }
        return ans; 
    }
    static int updateOr(int[]bits){
        int mask = 1;
        int or = 0;
        for (int i = 0; i < 32; i++) {
            if (bits[i] != 0) or += mask;
            mask *= 2;
        }
        return or;
    }
    static void updateBits(int[] bits, int num, int sign) {
        int mask = 1;
        for (int i = 0; i < 32; i++) {
            if ((num & mask )!= 0) bits[i] += sign * 1;
            mask *= 2;
        }
    }
}