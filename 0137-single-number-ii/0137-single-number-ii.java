class Solution {
    public int singleNumber(int[] nums) {
        int[] bit = new int[32];
        for(int num : nums){
            int mask = 1;
            for(int i = 0; i < 32; i++){
                if((num & mask) != 0) bit[i]++;

                mask *= 2;
            }
        }


        int ans = 0;
        int mask = 1;
        for(int i = 0; i < 32; i++){
            if(bit[i]%3 != 0) ans = ans + mask;
            mask *= 2;
        }

        return ans;
    }
}