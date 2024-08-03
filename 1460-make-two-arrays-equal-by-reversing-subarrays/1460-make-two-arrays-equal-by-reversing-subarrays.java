class Solution {
    public boolean canBeEqual(int[] target, int[] arr) {
        HashMap<Integer, Integer> freq1 = new HashMap<>();
        HashMap<Integer, Integer> freq2 = new HashMap<>();
        if(target.length != arr.length ) return false;
        for( int num : target ) freq1.put(num,1 + freq1.getOrDefault( num, 0));
        for( int num : arr ) freq2.put(num,1 + freq2.getOrDefault( num, 0));

        for( int num : freq1.keySet() ){
            if( freq1.get(num) != freq2.getOrDefault( num, 0) ) return false;
        }
        return true;
    }
}