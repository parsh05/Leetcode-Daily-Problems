class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] freq_s1 = new int[26];
        
        // Build frequency map for s1
        for (int i = 0; i < s1.length(); i++) {
            freq_s1[s1.charAt(i) - 'a']++;
        }
        
        int i = 0, j = 0;
        
        // Initialize the first window by decrementing frequencies for the first s1.length() characters of s2
        while (j < s1.length() && j < s2.length()) {
            freq_s1[s2.charAt(j) - 'a']--;
            j++;
        }

        // Now start sliding the window
        while (j < s2.length()) {
            // Check if freq_s1 is all zeros, which would mean a permutation is found
            boolean isPresent = true;
            for (int idx = 0; idx < 26; idx++) {
                if (freq_s1[idx] != 0) {
                    isPresent = false;
                    break;
                }
            }
            if (isPresent) return true;

            // Slide the window: increment freq for the character at index 'i' and decrement for 'j'
            freq_s1[s2.charAt(i) - 'a']++;
            freq_s1[s2.charAt(j) - 'a']--;
            
            i++;
            j++;
        }

        // Final check after sliding the window to the last position
        boolean isPresent = true;
        for (int idx = 0; idx < 26; idx++) {
            if (freq_s1[idx] != 0) {
                isPresent = false;
                break;
            }
        }

        return isPresent;
    }
}
