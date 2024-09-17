class Solution {
    public String[] uncommonFromSentences(String s1, String s2) {
        HashMap<String, Integer > mp = new HashMap<>(); 
        String[] arr1 = s1.split(" ");
        String[] arr2 = s2.split(" ");
        for(String s : arr1){
            mp.put(s, mp.getOrDefault(s, 0) + 1);
        }
        for(String s : arr2){
            mp.put(s, mp.getOrDefault(s, 0) + 1);
        }

        // 
        ArrayList<String> ansList = new ArrayList<>();
        for(String key : mp.keySet() ){
           // System.out.println(key + "-->" + mp.get(key));
            if(mp.get(key) == 1){
                ansList.add(key);
            }
        }
        int listSize = ansList.size(), idx = 0;
        String[] ans = new String[listSize];
        for(String s : ansList){
            ans[idx++] = s; 
        }
        return ans;
    }
}