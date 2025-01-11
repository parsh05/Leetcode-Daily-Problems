class Solution {
    public boolean hasMatch(String s, String p) {
        
       int i = 0;
       while( p.charAt(i) != '*'){
        i++;
       }

       String s1 = p.substring(0, i);
       String s2 = p.substring(i+1);

       int idx1 = s.indexOf(s1);
       int idx2 = s.lastIndexOf(s2);
       if(idx1 < 0 || idx2 < 0) return false;
       return idx2 >= idx1 + s1.length();
    }
}