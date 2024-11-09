class Solution {
    public long minEnd(int n, int x) {
        long minVal = x;
        for(int i = 0; i < n-1; i++){
            minVal = (minVal + 1) | x;
        }
        return minVal;
    }
}