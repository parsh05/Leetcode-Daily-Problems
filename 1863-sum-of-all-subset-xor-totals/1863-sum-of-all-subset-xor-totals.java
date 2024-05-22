class Solution {
    public int subsetXORSum(int[] nums) {
        int ans = 0;
        List<Integer> res = new ArrayList<>();
        res.add(0);
        for (int i = 0 ; i < nums.length ; i++ ){
            int size = res.size();
            for( int j = 0 ; j < size ; j++ ){
                int temp_ans = res.get(j) ^ nums[i];
                res.add(temp_ans);
                ans += temp_ans ;
            }
        }
        return ans;
    }
}