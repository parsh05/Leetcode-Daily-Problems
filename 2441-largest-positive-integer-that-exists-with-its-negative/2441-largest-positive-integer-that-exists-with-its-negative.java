class Solution {
    public int findMaxK(int[] nums) {
        HashSet<Integer> hs = new HashSet<>();
        for(int num : nums) hs.add(num);
        int max = 0;
        for(int num : hs) if(hs.contains(-num) && num > max) max = num;
        if(max==0) return -1;
        return max;
    }
}