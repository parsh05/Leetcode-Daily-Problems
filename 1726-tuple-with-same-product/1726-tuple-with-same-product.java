class Solution {
    public int tupleSameProduct(int[] nums) {
        Arrays.sort(nums);
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            for(int j =i+1; j < nums.length; j++){
                map.put(nums[i]*nums[j], map.getOrDefault(nums[i]*nums[j], 0) + 1);
            }
        }
        int ans = 0;
        for(int key : map.keySet()){
            int mulFre = map.get(key);
            ans += 8/2 * (mulFre)*(mulFre-1);
        }
        return ans;
    }
}