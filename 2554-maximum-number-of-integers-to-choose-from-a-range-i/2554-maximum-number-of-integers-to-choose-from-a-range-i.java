class Solution {
    public int maxCount(int[] banned, int n, int maxSum) {
        HashSet<Integer> hs = new HashSet<>();
        for(int num : banned) if(num <= n) hs.add(num);
        int sum = 0;
        int length = 0;
        for(int i = 1; i <= n; i++){
            if(hs.contains(i)) continue;
            if(sum + i > maxSum) return length;
            sum += i;
            length++;
        }
        return length;
    }
}