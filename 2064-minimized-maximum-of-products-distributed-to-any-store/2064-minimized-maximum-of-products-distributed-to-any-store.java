class Solution {
    public int minimizedMaximum(int n, int[] quantities) {
        int sum = 0, max = 0;
        for(int quantity : quantities){
            max = Math.max(quantity, max);
            sum += quantity;
        }
        int l = (sum - 1) / n + 1;
        int h = max;
        int ans = max;
        while(l < h){
            int mid = ( h - l)/2 + l;
            if(canDistribute(mid, quantities, n)){
                ans = Math.min(ans, mid);
                h = mid;
            } else{
                l = mid;
            }
        }
        return ans;
    }
    boolean canDistribute(int k, int[] quantities, int n){
        int stores = 0;
        for(int quantity : quantities) stores += 1 + (quantity - 1) / k;
        return stores <= n;
    }

}