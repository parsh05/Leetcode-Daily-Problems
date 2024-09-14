class Solution {
    public int longestSubarray(int[] nums) {
        int k = 0;
        for(int num : nums) k = Math.max(num, k);
        int i = 0, j = 0;
        int maxSize = 0;
        while(j < nums.length && j >= i){
            if((nums[j] & nums[i]) < k ){
                // 
                j++;
                i = j;
            } 
            else{
                maxSize = Math.max( maxSize, j - i + 1);
                j++;
            }
            
        }
        return maxSize;
    }
}