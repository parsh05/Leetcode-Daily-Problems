class Solution {

    public String[] findRelativeRanks(int[] score) {
        int n = score.length;
        String[] ans = new String[score.length];
        HashMap<Integer,Integer> mp = new HashMap<>();
        for(int i=0;i<score.length;i++) mp.put(score[i],i);

        Arrays.sort(score);
        for(int i=0;i<n ;i++) {
           if(i==n-3) ans[mp.get(score[i])] = "Bronze Medal";
           else if(i==n-2) ans[mp.get(score[i])] = "Silver Medal";
           else if(i==n-1) ans[mp.get(score[i])] = "Gold Medal";
            else ans[mp.get(score[i])] = Integer.toString(n - i );
        
        
        }
        return ans;
    }
}