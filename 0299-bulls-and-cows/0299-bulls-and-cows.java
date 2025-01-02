class Solution {
    public String getHint(String secret, String guess) {
        int n = secret.length();
        HashMap<Character, Integer> map = new HashMap<>();
        int bull = 0, cows = 0;
        for(int i = 0; i < n; i++){
            char ch = secret.charAt(i);
            if(ch == guess.charAt(i)) continue;
            else{
                map.put(ch, map.getOrDefault(ch, 1));
            }
        }
        for(int i = 0; i < n; i++){
            char ch = guess.charAt(i);
            if(ch == secret.charAt(i)) bull++;
            else{
                if(map.containsKey(ch)){
                    cows++;
                    if(map.get(ch) == 1) map.remove(ch);
                    else map.put(ch, map.get(ch) - 1);
                }
            }
        }

        String s = Integer.toString(bull) + "A"+Integer.toString(cows)+"B";
        return s;

    }
}