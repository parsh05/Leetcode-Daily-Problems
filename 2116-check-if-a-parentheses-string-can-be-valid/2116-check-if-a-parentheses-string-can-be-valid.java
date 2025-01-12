class Solution {
    public boolean canBeValid(String s, String locked) {
        int n = s.length();
        
        // A valid parentheses string must have an even length
        if (n % 2 != 0) return false;

        int zero = 0, open = 0;

        // Forward pass to check balance considering '(' and unlocked positions
        for (int i = 0; i < n; i++) {
            if (locked.charAt(i) == '0') {
                open++; // unlocked, can be '('
                zero++;
            } else if (s.charAt(i) == '(') {
                open++;
            } else {
                open--; // must be ')'
            }

            if (open < 0) return false; // More ')' than '(' so far
        }

        // Backward pass to check balance considering ')' and unlocked positions
        int close = 0;
        zero = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (locked.charAt(i) == '0') {
                close++; // unlocked, can be ')'
                zero++;
            } else if (s.charAt(i) == ')') {
                close++;
            } else {
                close--; // must be '('
            }

            if (close < 0) return false; // More '(' than ')' so far
        }

        return true; // Passed both checks
    }
}
