class Solution {
    int n = 0;
    int max = 0;

    private void solve(String s, HashSet<String> hs, int idx, int[] count) {
        if (idx == n) {
            max = Math.max(max, count[0]);
            return;
        }

        // Uncomment this to add pruning for optimization
        if (count[0] + n - idx <= max) return;

        for (int j = idx; j < n; j++) {
            String sub = s.substring(idx, j + 1);
            if (!hs.contains(sub)) {
                hs.add(sub);  // Add substring to set
                count[0]++;   // Increment count of unique substrings
                solve(s, hs, j + 1, count); // Explore further with new index
                hs.remove(sub); // Backtrack (remove substring from set)
                count[0]--;     // Decrement count after backtracking
            }
        }
    }

    public int maxUniqueSplit(String s) {
        n = s.length();
        solve(s, new HashSet<String>(), 0, new int[1]);
        return max;
    }
}
