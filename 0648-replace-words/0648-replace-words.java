class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {
        HashSet<String> roots = new HashSet<>(dictionary);
        String[] arr = sentence.split(" ");
        StringBuilder ans = new StringBuilder();
        for(String word : arr){
            boolean inserted = false;
            for(int i = 1; i <= word.length(); i++){
                
                String newWord = word.substring(0,i) ;
                if( roots.contains( newWord) ){
                    ans.append(newWord);
                    inserted = true;
                    break;
                }
            }
            if(!inserted){
                ans.append( word );
            }
            ans.append(" ");
        }
        String s = ans.toString();
        return s.substring(0, s.length()-1);
    }
}