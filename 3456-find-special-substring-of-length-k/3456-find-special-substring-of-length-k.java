class Solution {
    public boolean hasSpecialSubstring(String s, int k) {
        int count = 0;
        char prev = '0';
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) != prev){
                if(count == k) return true;
                count = 1;
                prev = s.charAt(i);
            }else{
                count++;
            }
        }
        if(count == k) return true;
        return false;
    }
}