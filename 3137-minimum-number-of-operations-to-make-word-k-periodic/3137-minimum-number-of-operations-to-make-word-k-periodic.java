class Solution {
    public int minimumOperationsToMakeKPeriodic(String word, int k) {
        HashMap<String,Integer> mp = new HashMap<>();
        int max = 0;
        for(int i=0;i<word.length();i=i+k){
            String s = word.substring(i,i+k);
            mp.put(s,mp.getOrDefault(s,0)+1);
            max = Math.max(mp.get(s) , max);
        }
        return (word.length() / k ) - max;
    }
}