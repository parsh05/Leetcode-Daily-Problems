class Solution {
    public boolean canConstruct(String s, int k) {
        if(k > s.length()) return false;
        if(s.length() == k) return true;

        HashMap<Character, Integer> map = new HashMap<>();

        for(char ch : s.toCharArray()){
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        int oddCount = 0;
        for(Character ch : map.keySet()){
            if(map.get(ch) % 2 == 1) oddCount++;

        }
       return oddCount <= k;
        
    }
}