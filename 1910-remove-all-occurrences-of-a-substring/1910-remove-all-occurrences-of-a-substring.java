class Solution {
    public String removeOccurrences(String s, String part) {
        StringBuilder sb = new StringBuilder(s);
        
        while (sb.length() > 0) {
            int idx = sb.indexOf(part);
            if (idx < 0) break;
            sb.delete(idx, idx + part.length()); // Corrected delete method
        }
        return sb.toString();
    }
}
