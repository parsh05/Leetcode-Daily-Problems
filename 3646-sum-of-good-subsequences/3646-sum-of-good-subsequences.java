class Solution {
    public int sumOfGoodSubsequences(int[] nums) {
        int n = nums.length;
        long ans = 0;
        int[] count = new int[100002];
        int[] sum = new int[100002];
        int mod = 1000000007;
        for(int i = 0; i < n; i++){
            int x = nums[i];
            if(x > 0) {
                count[x] = ( count[x] + 1 + count[x-1] + count[x+1] ) % mod;

                sum[x] = ( sum[x] + (x + sum[x-1] + count[x-1] * x + sum[x+1] + count[x+1] * x) % mod ) % mod;
            }
            else{
                count[x] =( count[x] +  (1 + count[x+1]) % mod) % mod;

                sum[x] = ( sum[x] +  x + sum[x+1] + count[x+1] * x) % mod;
                ans  = ( ans + sum[x]) % mod;
            }
        }

        
        return (int)ans;
    }
}