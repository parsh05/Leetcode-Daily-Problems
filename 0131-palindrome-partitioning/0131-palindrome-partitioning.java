class Solution {
    public List<List<String>> partition(String s) {
       ArrayList<String> curr = new ArrayList<String>(); 
       if(s.length()==1){
        curr.add(s);
        ans.add(curr);
        return ans;
       }
       helper(curr , s);
       return ans;
    }
    List<List<String>> ans = new ArrayList<>();
    private void helper(List<String> curr , String s){
        int n = s.length();
        
        for(int i=1;i<n;i++){
            if( !isPalindrome(s.substring(0,i) )) continue;
            curr.add(s.substring(0,i));
            if(isPalindrome(s.substring(i)) ) {
                curr.add(s.substring(i));
                ans.add(new ArrayList<>(curr));
                curr.remove(curr.size()-1);
            }
            helper(curr, s.substring(i));
            curr.remove(curr.size()-1);
        }
    }

    private boolean isPalindrome(String s){
        int n = s.length();
        for(int i=0;i<n/2;i++){
            if(s.charAt(i) != s.charAt(n-1-i))return false;
        }
        return true;
    }
}