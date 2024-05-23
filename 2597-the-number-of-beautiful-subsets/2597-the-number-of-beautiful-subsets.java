class Solution {
    public int beautifulSubsets(int[] nums, int k) {
        int n = nums.length;
        Arrays.sort(nums);
        HashMap<Integer,Integer> mp = new HashMap<>();
        for(int i=0;i<n;i++) mp.put(nums[i],i);
        int[] dp = new int [n+1];
        dp[0] = 1;
        for(int i=0;i<n;i++){
           int num = 0;
            if(mp.containsKey( nums[i]-k ) ){
                int idx = mp.get(nums[i]-k );
                if(idx > 0) num = nums[idx-1];
                dp[i+1] = dp[i] + 2 * num;
            }
            else {
                dp[i+1] = dp[i]*2;
            }
            
        }
        return dp[n]-1;
    }
}