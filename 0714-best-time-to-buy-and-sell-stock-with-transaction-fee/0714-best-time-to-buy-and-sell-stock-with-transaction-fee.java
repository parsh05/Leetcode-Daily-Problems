class Solution {
    // int solve(int[] arr, int i, int min,  int fee, int[] dp){
    //     if(i >= arr.length) return 0;

    //     if(dp[i] != -1) return dp[i];

    //     int ifNotSell = solve(arr, i+1, min, fee, dp);
    //     min = Math.min(min, arr[i]);
    //     int sell = (arr[i] - min - fee) + solve(arr, i+1, min, fee, dp);

    //     return dp[i] = Math.max(sell, ifNotSell);
    // }
    public int maxProfit(int[] arr, int fee) {
        int n = arr.length;
        int c0 = 0, c1 = 0; //curr
        int n0 = 0, n1 = 0; //next

        for(int idx = n - 1; idx >= 0; idx--) {
            //For canBuy = true
            c1 = Math.max(-arr[idx] + n0, n1);
            //For canBuy = false
            c0 = Math.max(arr[idx] - fee + n1, n0);
            //next = curr
            n0 = c0; n1 = c1;
        }

        //next[1]
        return n1;
    }
}