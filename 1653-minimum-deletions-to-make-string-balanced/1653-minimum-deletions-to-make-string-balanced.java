/// Rewriting the question s is said to be balanced only when i<j such that s[i]=a and s[j]=b
// meaning always a will be at the starting and b will be the second character

class Solution {
    public int minimumDeletions(String s) {
        int n = s.length();
        
        // Array to store count of 'a's from right to left
        int[] countA = new int[n];
        
        // Fill the countA array
        countA[n-1] = (s.charAt(n-1) == 'a') ? 1 : 0;
        for (int i = n-2; i >= 0; i--) {
            countA[i] = countA[i+1];
            if (s.charAt(i) == 'a') {
                countA[i]++;
            }
        }
        
        int result = Integer.MAX_VALUE;
        int countB = 0;
        
        // Iterate through the string
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == 'b') {
                // If current char is 'b', we have two options:
                // 1. Keep this 'b' and delete all 'a's to its right
                // 2. Delete this 'b'
                result = Math.min(result, countB + countA[i]);
                countB++;
            }
        }
        
        // Check if deleting all 'b's is better
        result = Math.min(result, countB);
        
        return result;
    }
}