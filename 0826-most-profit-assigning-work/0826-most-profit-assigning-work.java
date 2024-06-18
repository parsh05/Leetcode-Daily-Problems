class Pair implements Comparable<Pair>{
    int difficulty;
    int profit;

    Pair(int difficulty, int profit) {
        this.difficulty = difficulty;
        this.profit = profit;
    }

    @Override
    public int compareTo(Pair o) {
        if (this.difficulty == o.difficulty) return this.difficulty - o.difficulty;
    }
}

class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        Arrays.sort(worker);
        int n = worker.length;
        Pair[] diffProfit = new Pair[n];
        for (int i = 0; i < n; i++) {
            diffProfit [i] = new Pair( difficulty[i],profit[i] );
        }
        Arrays.sort(diffProfit);
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)-> b.profit - a.profit);
        pq.add(new Pair(-1,0) );
        int i = 0;
        int ans = 0;
        for( int w : worker ){
            while( i < diffProfit.length && diffProfit[i].difficulty <= w ){
                pq.add( diffProfit[i]);
                i++;
            }
            ans += pq.peek().profit;
        }
        return ans;
    }
}