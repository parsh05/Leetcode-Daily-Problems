class Solution {
    public int minOperations(int[] nums, int k) {
        PriorityQueue<Long> pq = new PriorityQueue<>();
        for (int num : nums) {
            pq.add((long)num);
        }
        int steps = 0;
        while(pq.size() >= 2 && pq.peek() < k){
            steps++;
            long min = pq.poll();
            long secMin = pq.poll();
            pq.add(min*2 + secMin);
        }
        return steps;
    }
}