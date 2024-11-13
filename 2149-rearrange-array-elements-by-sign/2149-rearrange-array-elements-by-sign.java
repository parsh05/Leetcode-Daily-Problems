class Solution {
    public int[] rearrangeArray(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        int j=0, k=1; // j for +ve's
        for(int i=0; i<n; i++){
            if(nums[i] > 0){
                ans[j] = nums[i];
                j += 2;
            }
            else{
                ans[k] = nums[i];
                k += 2;
            }
        }
        return ans;
    }
}