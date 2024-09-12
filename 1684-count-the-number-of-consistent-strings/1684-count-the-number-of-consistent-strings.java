class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        HashSet<Character> allowedHs = new HashSet<>();
        for(int i =0; i < allowed.length(); i++) allowedHs.add(allowed.charAt(i));
        HashSet<Character> hs = new HashSet<>();
        int count = 0;
        for(String s : words){
            for(int i =0; i < s.length(); i++) hs.add(s.charAt(i));

            boolean isConsistent = true;
            // compare two String
            for(char ch : hs){

                if(!allowedHs.contains(ch)) {
                    isConsistent = false;
                    break;
                }
            }
            if(isConsistent ){
                count++;
            }
            hs.clear();
        }
        return count;
    }
}