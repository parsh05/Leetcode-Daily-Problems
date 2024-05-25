class Solution {
    HashSet<String> wordmap = new HashSet<>();
    List<String> solve(String s){
        if(s.isEmpty() ) {
            List<String> result = new ArrayList<>();
            result.add("");
            return result;
        }

        List<String> result = new ArrayList<>();
        for( int l = 1; l <= s.length(); l++){
            String currWord = s.substring(0, l);
            if(wordmap.contains( currWord) ){
                String remWord = s.substring(l);
                List<String> remResult = solve( remWord );

                for(String w : remResult ){
                    String toAdd = currWord + (w.isEmpty() ? "" : " " )+ w;
                    result.add(toAdd);
                }
                
            }
        }
        return result;
    }

    public List<String> wordBreak(String s, List<String> wordDict) {
        for( String word : wordDict ) wordmap.add( word );
       return solve(s);
     
    }
}