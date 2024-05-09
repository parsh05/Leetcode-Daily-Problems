class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        Arrays.sort(happiness);
        int n = happiness.length;
        long sum = 0;
        for(int i=0;i<k;i++){
            int index = n-1-i;
            int num = happiness[index]-i;
            if(num<0)return sum;
            sum = sum+num;
        }
        return sum;
    }
}