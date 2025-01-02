class Solution {
    public int[] vowelStrings(String[] words, int[][] queries) {
        int n = words.length;
        int[] freq = new int[n+2];
        int[] ans = new int[queries.length];
        for(int i = n-1; i >= 0; i--){
            freq[i] += freq[i+1];
            String s = words[i];
            if(isVowel(s.charAt(0)) && isVowel(s.charAt(s.length() - 1) ) ) {
                freq[i]++;
            }
        }

        int j = 0;
        for(int[] query : queries){
            int r = query[1], l = query[0];
            ans[j] = freq[l] - freq[r+1];
            j++;
        }
        return ans;
    }
    private boolean isVowel(char ch){
        if(ch =='a' || ch =='e' || ch == 'i' || ch =='o' || ch == 'u' ) return true;
        return false;
    }
}