class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        for(int i = 1; i < arr.length; i++){
            arr[i] ^= arr[i-1];
        }
        int[] ans = new int[queries.length];
        int j = 0;
        for(int[] q : queries){
            int left = q[0], right = q[1];
           ans[j++] =  (left == 0)? arr[right] : arr[right]^arr[left - 1];
        }
        return ans;
    }
}