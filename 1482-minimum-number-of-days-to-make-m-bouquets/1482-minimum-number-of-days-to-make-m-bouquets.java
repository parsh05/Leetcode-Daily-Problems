class Solution {
    private boolean canMakeBouq(int[] bloomDay, int day, int k, int m){
        int consecutive_day = 0, noOfBouqet = 0;

        for(int i = 0; i < bloomDay.length; i++){
            if( bloomDay[i] <= day ){
                consecutive_day++;
            } else{
                consecutive_day = 0;
            }

            if( consecutive_day == k ){
                noOfBouqet++;
                consecutive_day = 0;
            }
        }
        return noOfBouqet >= m;
    }

    public int minDays(int[] bloomDay, int m, int k) {
        int n = bloomDay.length;
        if( bloomDay.length < m * k ) return -1;
        int startDay = 0, endDay = 0;
        for(int i = 0; i < n; i++) endDay = Math.max( bloomDay[i], endDay);

        int minDays = -1;

        while( startDay <= endDay ){
            int mid = startDay + ( endDay - startDay )/2;
            if( canMakeBouq (bloomDay, mid, k, m) ){
                minDays = mid;
                endDay = mid - 1;
            } else{
                startDay = mid + 1;
            }
            
        }
        return minDays;
    }
}