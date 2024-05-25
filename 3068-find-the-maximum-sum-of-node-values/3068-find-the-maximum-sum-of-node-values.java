class Solution {
    public long maximumValueSum(int[] nums, int k, int[][] edges) {
        long ans = 0;
        ArrayList<Integer> faayda = new ArrayList<>();
        for (int i = 0; i < nums.length; i++){
            faayda.add( (nums[i] ^ k) - nums[i] ) ;
            ans += nums[i];
        }
            

        Collections.sort(faayda);
        Collections.reverse(faayda);
        for(int i = 0; i+1 < faayda.size(); i = i+2 ){
            int sum = faayda.get(i) + faayda.get(i+1) ;
            if(sum <= 0) break;
            ans += sum;
        }
        return ans;
    }
}