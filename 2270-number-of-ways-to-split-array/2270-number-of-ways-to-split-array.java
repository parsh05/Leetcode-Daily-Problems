class Solution {
    public int waysToSplitArray(int[] nums) {
        long sum = 0, totalSum = 0;
        for(int i = 0; i < nums.length; i++){
            totalSum += nums[i];
        }
        int count = 0;
        for(int i = 0; i < nums.length - 1; i++){
            sum += nums[i];
            if(sum >= totalSum - sum) count++;
        }
        return count;
    }
}