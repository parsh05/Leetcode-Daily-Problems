class Solution {
    public boolean isCircularSentence(String sentence) {
        String[] arr = sentence.split(" ");
        int n = arr.length;
        for(int i = 0; i < n; i++){
           String s1 = arr[i];
           String s2 = arr[(i+1)%n];
            if(s1.charAt(s1.length()-1) != s2.charAt(0) ) return false;
        }
        return true;
    }
}