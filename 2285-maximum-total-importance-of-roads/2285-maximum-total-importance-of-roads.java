class Solution {
    public long maximumImportance(int n, int[][] roads) {
        int[] edges = new int[n];
        for(int[] road : roads ){
            edges[ road[0] ]++;
            edges[ road[1] ]++;
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b - a );
        for( int edge : edges ) pq.add(edge );

        long ans = 0;
        while(pq.size() > 0){
            ans = ans + pq.poll() * (n);
            n--;
        }
        return ans;
    }
}