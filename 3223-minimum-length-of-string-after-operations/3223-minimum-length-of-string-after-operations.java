class Solution {
    public int minimumLength(String s) {
        int n = s.length();

        int[] freq = new int[26];
        for(char ch : s.toCharArray()) freq[ch-'a']++;

        int removed = 0;
        for(int fre : freq){
            removed += ((fre - 1)/2 * 2);
        }
        return n - removed;
    }
}