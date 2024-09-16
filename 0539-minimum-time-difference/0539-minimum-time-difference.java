class Solution {
    public int findMinDifference(List<String> timePoints) {
        int n = timePoints.size();
        int[] arr = new int[n];
        int j = 0;
        for(String s : timePoints){
            String[] time = s.split(":");
            int hr = Integer.parseInt( time[0] );
            int minutes = Integer.parseInt( time[1]);
            arr[j++] = hr * 60 + minutes;
        }
        Arrays.sort(arr);
        int ans = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++){
            int time1 = arr[i];
            int prev_idx = ( i - 1 + n) % n;
            int time2 = arr[ prev_idx ];
            // 3 options : (1) ==> |x - y|
            // (2) ==> (x + 24 hours) - y
            // (3) ==> (y + 24hours) - x
            int opt1 = Math.abs( time1 - time2);
            int opt2 = ( 24 * 60 + time1 - time2);
            int opt3 = ( 24 * 60 + time2 - time1);
            int temp_ans = Math.min( opt1, Math.min(opt2, opt3));
            ans = Math.min(ans, temp_ans);
        }
        return ans;
    }
}