class Solution {
    public int minBitFlips(int start, int goal) {
        int bits = setBit(start ^ goal);
        return bits;
    }
    private int setBit(int num){
        int count = 0;
        while(num > 0){
            int rmsb = (num & -num);
            num = num-rmsb;
            count++;
        }
        return count;
    }
}