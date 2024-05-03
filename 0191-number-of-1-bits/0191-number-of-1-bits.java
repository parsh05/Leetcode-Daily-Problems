class Solution {
    public int hammingWeight(int n) {
        return kernighan_Algorithm(n);
    }
    private int kernighan_Algorithm(int n){
        int count = 0;
        while(n > 0){
            int rmsb = n & -n;
            n -= rmsb;
            count++;
        }
        return count;
    }
}