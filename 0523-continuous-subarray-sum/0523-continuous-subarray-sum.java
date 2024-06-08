class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
       HashMap<Integer, Integer> mp = new HashMap<>();
       mp.put(0,-1 );
       int sum = 0;
       for(int i = 0; i < nums.length; i++ ){
        sum += nums[i];
        nums[i] = sum;
        if(mp.containsKey(sum % k )) {
            int idx = mp.get( sum % k );
            if( i - idx > 1) return true;
        } else{
            mp.put( sum % k, i);
        }
       }
       return false;
    }
}