class Solution {
    public int chalkReplacer(int[] chalk, int k) {
        long sum = 0;
        for(int i = 0; i < chalk.length; i++) sum += chalk[i];
        long k_th = k % sum;
        // k = k % sum;
        k = (int) k_th;
        int i = 0;
        while( k >= chalk[i]){
            k -= chalk[i];
            i++;
        }
        return i;
    }
}