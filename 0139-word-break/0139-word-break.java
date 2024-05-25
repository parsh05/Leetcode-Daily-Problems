class Solution {
    HashMap<String, Boolean> map = new HashMap();
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> wordmap = new HashSet<>(wordDict);
        return solve(s, 0, 0, wordmap);
    }

    private boolean solve(String s, int startIdx, int idx, HashSet<String> wordmap) {
        if (idx >= s.length()) {
            if (startIdx == s.length())
                return true;
            return false;
        }

        String key = startIdx + "_"+ idx;
        if(map.containsKey(key) ) return map.get(key);
        boolean ifContains = false;
        if (wordmap.contains(s.substring(startIdx, idx + 1))) {
            ifContains = solve(s, idx + 1, idx + 1, wordmap);
        }
        boolean ifNotContains = solve(s, startIdx, idx + 1, wordmap);

       boolean ans = ifContains || ifNotContains;
       map.put(key, ans);
       return map.get(key);
    }
}