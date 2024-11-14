class Solution {
    public int largestCombination(int[] candidates) {
        int[] bits = new int[32];
        for(int candidate : candidates){
            int mask = 1;
            for(int i = 0; i < 32; i++){
                if((mask & candidate) > 0 ) {
                    bits[i]++;
                }
                mask *= 2;
            }
        }
        int max = Arrays.stream(bits).max().getAsInt();
        return max;
    }
}