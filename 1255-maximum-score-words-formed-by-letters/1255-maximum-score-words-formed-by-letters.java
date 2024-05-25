class Solution {
    int maxScore = Integer.MIN_VALUE;
    int n ;

    private void solve( String[] words,int i, int[] freq, int[] score, int currentScore){
        maxScore = Math.max( maxScore, currentScore);
        if(i >= n)return;

        int j = 0;
        int tempScore  = 0;
        int[] newfreq = freq.clone();
        while(j < words[i].length() ){
            char ch = words[i].charAt(j);
            tempScore += score[ch-'a'];

            newfreq[ch - 'a']--;
            if(newfreq[ch-'a'] < 0) break;

            j++;
        }
        if(j == words[i].length() ){
            solve( words, i+1, newfreq,score, currentScore + tempScore);
        }
        j = 0;
        
         solve( words, i+1, freq, score, currentScore );
    }

    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        n = words.length;
        int[] freq = new int[26];
        for(char ch : letters) freq[ ch - 'a']++;
        solve(words, 0,  freq, score, 0 );
        return maxScore;
    }
}