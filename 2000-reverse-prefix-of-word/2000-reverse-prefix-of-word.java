class Solution {
   public String reversePrefix(String word, char ch) {
        char[] s =word.toCharArray();
        int n = s.length;
        for(int i=0;i<n;i++){
            if(s[i]==ch) {
                reverse(s,i);
                break;
            }
        }
        return String.valueOf(s); 
    }

    private void reverse(char[] s, int end_idx) {
        for (int i = 0; i <= end_idx / 2; i++) {
            char temp = s[i];
            s[i] = s[end_idx - i];
            s[end_idx-i] = temp;
        }
    }
}